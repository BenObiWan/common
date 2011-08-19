package common.config.ui;

import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import common.config.InvalidConfigurationException;
import common.config.display.DoubleDisplayType;
import common.config.leaf.ConfigurationDouble;

/**
 * Object used to display a {@Link ConfigurationDouble} on the
 * {@link ConfigurationPanel}.
 * 
 * @author benobiwan
 * 
 */
public class DoubleEntryComponent extends
		NumberEntryComponent<Double, DoubleDisplayType, ConfigurationDouble>
{
	/**
	 * Creates a new DoubleEntryComponent.
	 * 
	 * @param entry
	 *            the configuration element to display.
	 */
	public DoubleEntryComponent(final ConfigurationDouble entry)
	{
		super(entry);
	}

	@Override
	protected void setToValueAndShowValidity(final Double value)
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
		double min, max, initValue;
		if (_entry.getMinValue() != null)
		{
			min = _entry.getMinValue().doubleValue();
		}
		else
		{
			min = Double.MIN_VALUE;
		}
		if (_entry.getMaxValue() != null)
		{
			max = _entry.getMaxValue().doubleValue();
		}
		else
		{
			max = Double.MAX_VALUE;
		}
		if (_entry.getCurrentValue() != null)
		{
			initValue = _entry.getCurrentValue().doubleValue();
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
			_entryComponent = new JTextField(Double.toString(initValue));
			_entryComponent.setToolTipText(strToolTip);
			((JTextField) _entryComponent)
					.addFocusListener(new ValidateFocusListener());
			break;
		}
	}

	@Override
	protected Double getDisplayedValue() throws InvalidConfigurationException
	{
		Double value;
		switch (_dispType)
		{
		case SPINNER:
			value = ((Double) ((JSpinner) _entryComponent).getModel()
					.getValue());
			break;
		case TEXTFIELD:
			try
			{
				value = Double
						.valueOf(((JTextField) _entryComponent).getText());
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
