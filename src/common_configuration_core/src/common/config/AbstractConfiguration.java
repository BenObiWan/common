package common.config;

/**
 * A general purpose abstract configuration.
 * 
 * @author benobiwan
 * 
 */
public abstract class AbstractConfiguration implements IConfiguration
{
	/**
	 * The parent of this {@link IConfiguration}.
	 */
	protected final IConfiguration _parentConf;

	/**
	 * Boolean telling whether this {@link IConfiguration} is locked.
	 */
	private volatile boolean _bConfLocked = false;

	/**
	 * Name of this {@link IConfiguration}.
	 */
	protected final String _strName;

	/**
	 * Creates a new AbstractConfiguration.
	 * 
	 * @param parent
	 *            the parent of this AbstractConfiguration.
	 * @param strName
	 *            the name of this AbstractConfiguration.
	 */
	protected AbstractConfiguration(final IConfiguration parent,
			final String strName)
	{
		_parentConf = parent;
		_strName = strName;
	}

	@Override
	public final String getName()
	{
		return _strName;
	}

	@Override
	public final void lock()
	{
		_bConfLocked = true;
	}

	/**
	 * Unlock this configuration element, and update it's value.
	 */
	@Override
	public final void unlock()
	{
		_bConfLocked = false;
		updateCurrentValue();
	}

	@Override
	public boolean isLocked()
	{
		if (_bConfLocked)
		{
			return true;
		}
		else if (_parentConf != null)
		{
			return _parentConf.isLocked();
		}
		return false;
	}

	@Override
	public boolean validateName(final String strName)
	{
		// TODO add a length test
		return strName.indexOf(IConfigurationLoader.CONF_NODE_SEP) == -1;
	}

}
