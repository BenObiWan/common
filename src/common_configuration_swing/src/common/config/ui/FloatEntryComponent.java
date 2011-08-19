package common.config.ui;

import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import common.config.InvalidConfigurationException;
import common.config.display.FloatDisplayType;
import common.config.leaf.ConfigurationFloat;

/**
 * Object used to display a {@Link ConfigurationFloat} on the
 * {@link ConfigurationPanel}.
 * 
 * @author benobiwan
 * 
 */
public class FloatEntryComponent extends
		NumberEntryComponent<Float, FloatDisplayType, ConfigurationFloat>
{
	/**
	 * Creates a new DoubleEntryComponnent.
	 * 
	 * @param entry
	 *            the configuration element to display.
	 */
	public FloatEntryComponent(final ConfigurationFloat entry)
	{
		super(entry);
	}

	@Override
	protected void setToValueAndShowValidity(final Float value)
	{
		switch (_dispType)
		{
		case SPINNER:
			((JSpinner) _entryComponent).setValue(value);
			break;
		case TEXTFIELD:
			((JTextField) _entryComponent).setText(value.toString());
			break;
		}
		validateAndShowValidity();
	}

	@Override
	protected void generateComponent()
	{
		float min, max, initValue;
		if (_entry.getMinValue() != null)
		{
			min = _entry.getMinValue().floatValue();
		}
		else
		{
			min = Float.MIN_VALUE;
		}
		if (_entry.getMaxValue() != null)
		{
			max = _entry.getMaxValue().floatValue();
		}
		else
		{
			max = Float.MAX_VALUE;
		}
		if (_entry.getCurrentValue() != null)
		{
			initValue = _entry.getCurrentValue().floatValue();
		}
		else
		{
			initValue = 0;
		}
		final String strToolTip = "Min : " + min + " Max : " + max;
		switch (_dispType)
		{
		case SPINNER:
			final SpinnerNumberModel spinnerModel = new SpinnerNumberModel(
					initValue, min, max, 1);
			_entryComponent = new JSpinner(spinnerModel);
			spinnerModel.addChangeListener(new ValidateChangeListener());
			_entryComponent.setToolTipText(strToolTip);
			break;
		case TEXTFIELD:
			_entryComponent = new JTextField(Float.toString(initValue));
			_entryComponent.setToolTipText(strToolTip);
			((JTextField) _entryComponent)
					.addFocusListener(new ValidateFocusListener());
			break;
		}
	}

	@Override
	protected Float getDisplayedValue() throws InvalidConfigurationException
	{
		Float value;
		switch (_dispType)
		{
		case SPINNER:
			value = ((Float) ((JSpinner) _entryComponent).getModel().getValue());
			break;
		case TEXTFIELD:
			try
			{
				value = Float.valueOf(((JTextField) _entryComponent).getText());
			}
			catch (final NumberFormatException ex)
			{
				throw new InvalidConfigurationException(ex);
			}
			break;
		default:
			throw new InvalidConfigurationException();
		}
		return value;
	}
}
