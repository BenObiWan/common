package common.swing;

import javax.swing.JInternalFrame;

/**
 * {@link JInternalFrame} implementing the {@link IDisposableFrame} interface.
 * 
 * @author benobiwan
 * 
 */
public final class DisposableInternalFrame extends JInternalFrame implements
		IDisposableFrame
{
	/**
	 * serialVersionUID for Serialization.
	 */
	private static final long serialVersionUID = 4380752419452507131L;

	/**
	 * Creates a non-resizable, non-closable, non-maximizable, non-iconifiable
	 * JInternalFrame with no title.
	 */
	public DisposableInternalFrame()
	{
		super();
	}

	/**
	 * Creates a non-resizable, non-closable, non-maximizable, non-iconifiable
	 * JInternalFrame with the specified title.
	 * 
	 * @param strTitle
	 *            the title of the frame.
	 */
	public DisposableInternalFrame(final String strTitle)
	{
		super(strTitle);
	}

	/**
	 * Creates a non-closable, non-maximizable, non-iconifiable JInternalFrame
	 * with the specified title and resizability.
	 * 
	 * @param strTitle
	 *            the title of the frame.
	 * @param bResizable
	 *            whether or not the frame is resizable.
	 */
	public DisposableInternalFrame(final String strTitle,
			final boolean bResizable)
	{
		super(strTitle, bResizable);
	}

	/**
	 * Creates a non-maximizable, non-iconifiable JInternalFrame with the
	 * specified title, resizability, and closability.
	 * 
	 * @param strTitle
	 *            the title of the frame.
	 * @param bResizable
	 *            whether or not the frame is resizable.
	 * @param bClosable
	 *            whether or not the frame is closable.
	 */
	public DisposableInternalFrame(final String strTitle,
			final boolean bResizable, final boolean bClosable)
	{
		super(strTitle, bResizable, bClosable);
	}

	/**
	 * Creates a non-iconifiable JInternalFrame with the specified title,
	 * resizability, closability, and maximizability.
	 * 
	 * @param strTitle
	 *            the title of the frame.
	 * @param bResizable
	 *            whether or not the frame is resizable.
	 * @param bClosable
	 *            whether or not the frame is closable.
	 * @param bMaximizable
	 *            whether or not the frame is maximizable.
	 */
	public DisposableInternalFrame(final String strTitle,
			final boolean bResizable, final boolean bClosable,
			final boolean bMaximizable)
	{
		super(strTitle, bResizable, bClosable, bMaximizable);
	}

	/**
	 * Creates a JInternalFrame with the specified title, resizability,
	 * closability, maximizability, and iconifiability.
	 * 
	 * @param strTitle
	 *            the title of the frame.
	 * @param bResizable
	 *            whether or not the frame is resizable.
	 * @param bClosable
	 *            whether or not the frame is closable.
	 * @param bMaximizable
	 *            whether or not the frame is maximizable.
	 * @param bIconifiable
	 *            whether or not the frame is iconifiable.
	 */
	public DisposableInternalFrame(final String strTitle,
			final boolean bResizable, final boolean bClosable,
			final boolean bMaximizable, final boolean bIconifiable)
	{
		super(strTitle, bResizable, bClosable, bMaximizable, bIconifiable);
	}

}
