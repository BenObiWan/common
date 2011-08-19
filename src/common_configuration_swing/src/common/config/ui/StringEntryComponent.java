package common.config.ui;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import common.config.InvalidConfigurationException;
import common.config.display.StringDisplayType;
import common.config.leaf.ConfigurationString;

/**
 * Object used to display a {@Link ConfigurationString} on the
 * {@link ConfigurationPanel}.
 * 
 * @author benobiwan
 * 
 */
public class StringEntryComponent extends
		EntryComponent<String, StringDisplayType, ConfigurationString>
{
	/**
	 * Creates a new StringEntryComponnent.
	 * 
	 * @param entry
	 *            the configuration element to display.
	 */
	public StringEntryComponent(final ConfigurationString entry)
	{
		super(entry);
	}

	@Override
	protected void setToValueAndShowValidity(final String value)
	{
		switch (_dispType)
		{
		case TEXTFIELD:
			((JTextField) _entryComponent).setText(value);
			break;
		case TEXTAREA:
			((JTextArea) _entryComponent).setText(value);
			break;
		}
		validateAndShowValidity();
	}

	@Override
	protected void generateComponent()
	{
		switch (_dispType)
		{
		case TEXTAREA:
			_entryComponent = new JTextArea(_initValue);
			((JTextArea) _entryComponent)
					.addFocusListener(new ValidateFocusListener());
			break;
		case TEXTFIELD:
			_entryComponent = new JTextField(_initValue);
			((JTextField) _entryComponent)
					.addFocusListener(new ValidateFocusListener());
			break;
		}
	}

	@Override
	protected String getDisplayedValue() throws InvalidConfigurationException
	{
		String value;
		switch (_dispType)
		{
		case TEXTAREA:
			value = ((JTextArea) _entryComponent).getText();
			break;
		case TEXTFIELD:
			value = ((JTextField) _entryComponent).getText();
			break;
		default:
			throw new InvalidConfigurationException();
		}
		return value;
	}
}
