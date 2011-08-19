package common.config;

/**
 * Interface describing a leaf of the configuration tree which is describing a
 * {@link Number} configuration.
 * 
 * @author benobiwan
 * 
 * @param <TYPE>
 *            the type of the value described by this leaf.
 * @param <DISP_TYPE>
 *            the display type of the value described by this leaf.
 */
public interface IConfigurationNumberLeaf<TYPE extends Number, DISP_TYPE extends Enum<DISP_TYPE>>
		extends IConfigurationLeaf<TYPE, DISP_TYPE>
{
	/**
	 * Get the minimum value of this number.
	 * 
	 * @return Get the minimum value of this number.
	 */
	TYPE getMinValue();

	/**
	 * Get the maximum value of this number.
	 * 
	 * @return Get the maximum value of this number.
	 */
	TYPE getMaxValue();
}
