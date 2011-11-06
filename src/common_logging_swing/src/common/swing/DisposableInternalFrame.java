package common.swing;

import javax.swing.JInternalFrame;

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
	 */
	public DisposableInternalFrame(final String title)
	{
		super(title);
	}

	/**
	 * Creates a non-closable, non-maximizable, non-iconifiable JInternalFrame
	 * with the specified title and resizability.
	 */
	public DisposableInternalFrame(final String title, final boolean resizable)
	{
		super(title, resizable);
	}

	/**
	 * Creates a non-maximizable, non-iconifiable JInternalFrame with the
	 * specified title, resizability, and closability.
	 */
	public DisposableInternalFrame(final String title, final boolean resizable,
			final boolean closable)
	{
		super(title, resizable, closable);
	}

	/**
	 * Creates a non-iconifiable JInternalFrame with the specified title,
	 * resizability, closability, and maximizability.
	 */
	public DisposableInternalFrame(final String title, final boolean resizable,
			final boolean closable, final boolean maximizable)
	{
		super(title, resizable, closable, maximizable);
	}

	/**
	 * Creates a JInternalFrame with the specified title, resizability,
	 * closability, maximizability, and iconifiability.
	 */
	public DisposableInternalFrame(final String title, final boolean resizable,
			final boolean closable, final boolean maximizable,
			final boolean iconifiable)
	{
		super(title, resizable, closable, maximizable, iconifiable);
	}

}
