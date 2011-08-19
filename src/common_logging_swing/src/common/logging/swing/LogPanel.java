package common.logging.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.Executor;

import javax.swing.DropMode;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.DefaultCaret;

import org.apache.log4j.Logger;

/**
 * 
 * @author benobiwan
 * 
 */
public final class LogPanel extends JScrollPane implements Runnable,
		ActionListener
{
	/**
	 * serialVersionUID for Serialization.
	 */
	private static final long serialVersionUID = -8102814903785311840L;

	/**
	 * Logger object.
	 */
	private static final Logger LOGGER = Logger.getLogger(LogPanel.class);

	/**
	 * Frame name to use on the frame holding this panel.
	 */
	public static final String FRAME_NAME = "Logs";

	/**
	 * {@link JTextArea} used to write the log messages.
	 */
	private final JTextArea _textArea;

	/**
	 * Stream used to write log message on this panel.
	 */
	private final PipedOutputStream _output;

	/**
	 * {@link BufferedReader} used to read the log lines.
	 */
	private final BufferedReader _brInput;

	/**
	 * {@link Executor} to use to execute the work of this LogPanel.
	 */
	private final Executor _exec;

	/**
	 * Boolean used to stop the work of this LogPanel.
	 */
	private volatile boolean _bStop = false;

	/**
	 * Boolean used to start the work of this LogPanel only once.
	 */
	private volatile boolean _bStarted = false;

	/**
	 * Creates a new LogPanel which always displays a vertical scrollbar and
	 * never displays an horizontal scrollbar.
	 * 
	 * @param exec
	 *            Executor to use to execute the work of this LogPanel.
	 * @throws IOException
	 *             an IO error occurred in the opening of the streams.
	 */
	public LogPanel(final Executor exec) throws IOException
	{
		this(exec, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}

	/**
	 * Creates a new LogPanel.
	 * 
	 * @param exec
	 *            Executor to use to execute the work of this LogPanel.
	 * @param vsbPolicy
	 *            the policy of the vertical scrollbar display.
	 * @param hsbPolicy
	 *            the policy of the horizontal scrollbar display.
	 * @throws IOException
	 *             an IO error occurred in the opening of the streams.
	 */
	public LogPanel(final Executor exec, final int vsbPolicy,
			final int hsbPolicy) throws IOException
	{
		super(vsbPolicy, hsbPolicy);
		_exec = exec;
		_textArea = new JTextArea();
		_textArea.setEditable(false);
		_textArea.setDropMode(DropMode.INSERT);
		((DefaultCaret) _textArea.getCaret())
				.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		if (hsbPolicy == ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER)
		{
			_textArea.setLineWrap(true);
		}
		setViewportView(_textArea);
		_output = new PipedOutputStream();
		_brInput = new BufferedReader(new InputStreamReader(
				new PipedInputStream(_output)));
	}

	/**
	 * Get the stream used to write log message on this panel.
	 * 
	 * @return the stream used to write log message on this panel.
	 */
	public PipedOutputStream getOutputStream()
	{
		return _output;
	}

	@Override
	public void run()
	{
		while (!_bStop)
		{
			try
			{
				_textArea.append(_brInput.readLine() + "\n");
			}
			catch (final IOException e)
			{
				LOGGER.error("IO Error while reading from input.");
			}
		}
	}

	/**
	 * Stop displaying log messages on this panel.
	 */
	public void stop()
	{
		_bStop = true;
	}

	/**
	 * Start displaying log messages on this panel.
	 */
	public void start()
	{
		synchronized (this)
		{
			if (!_bStarted)
			{
				_bStarted = true;
				_exec.execute(this);
			}
		}
	}

	@Override
	public void actionPerformed(final ActionEvent e)
	{
		if ("Start".equals(e.getActionCommand()))
		{
			start();
		}
		else if ("Close".equals(e.getActionCommand()))
		{
			stop();
		}
		else
		{
			LOGGER.error("Action command " + e.getActionCommand() + " Unknown.");
		}
	}
}
