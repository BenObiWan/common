package common.logging.swing;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * A {@link JMenuBar} for the {@link LogInternalFrame} frame.
 * 
 * @author benobiwan
 * 
 */
public final class LogMenuBar extends JMenuBar
{
	/**
	 * serialVersionUID for Serialization.
	 */
	private static final long serialVersionUID = -1602853964724200412L;
	/**
	 * The {@link LogPanel} associated with this LogMenuBar.
	 */
	private final LogPanel _panel;

	/**
	 * Creates a new LogMenuBar.
	 * 
	 * @param panel
	 *            the {@link LogPanel} associated with this LogMenuBar.
	 */
	public LogMenuBar(final LogPanel panel)
	{
		super();
		_panel = panel;
		// Menu Logging
		final JMenu menu = new JMenu("Logging");
		menu.setMnemonic(KeyEvent.VK_L);
		add(menu);
		// Bouton Start
		JMenuItem menuItem = new JMenuItem("Start");
		menuItem.setMnemonic(KeyEvent.VK_S);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.ALT_MASK));
		menuItem.setActionCommand("Start");
		menuItem.addActionListener(_panel);
		menu.add(menuItem);
		// Bouton Close
		menuItem = new JMenuItem("Close");
		menuItem.setMnemonic(KeyEvent.VK_C);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				ActionEvent.ALT_MASK));
		menuItem.setActionCommand("Close");
		menuItem.addActionListener(_panel);
		menu.add(menuItem);
	}
}
