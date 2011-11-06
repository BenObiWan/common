package common.logging.swing;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.util.concurrent.Executor;

import javax.swing.JInternalFrame;

import common.swing.IDisposableFrame;

/**
 * A JInternalFrame for displaying log event.
 * 
 * @author benobiwan
 * 
 */
public final class LogInternalFrame extends JInternalFrame implements
		IDisposableFrame
{
	/**
	 * serialVersionUID for Serialization.
	 */
	private static final long serialVersionUID = 8060437106139820856L;

	/**
	 * The main panel of this frame.
	 */
	private final LogPanel _mainPanel;

	/**
	 * The menu to use on this frame.
	 */
	private final LogMenuBar _mainMenu;

	/**
	 * Creates a new LogInternalFrame.
	 * 
	 * @param exec
	 *            Executor to use to execute the work of the {@link LogPanel}.
	 * @throws IOException
	 *             an IO error occurred in the opening of the streams.
	 */
	public LogInternalFrame(final Executor exec) throws IOException
	{
		super(LogPanel.FRAME_NAME, true, true, true, true);
		_mainPanel = new LogPanel(exec);
		_mainMenu = new LogMenuBar(_mainPanel);
		setContentPane(_mainPanel);
		setJMenuBar(_mainMenu);
	}

	/**
	 * Get the stream used to write log message on the {@link LogPanel}.
	 * 
	 * @return the stream used to write log message on the {@link LogPanel}.
	 */
	public PipedOutputStream getOutputStream()
	{
		return _mainPanel.getOutputStream();
	}

	/**
	 * Close this frame. Does nothing right now.
	 */
	public void close()
	{
		// TODO tools LogInternalFrame close
	}

	/**
	 * Start displaying log messages on the {@link LogPanel}.
	 */
	public void start()
	{
		_mainPanel.start();
	}
}
