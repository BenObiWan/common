package common.swing;

public class CheckBoxNode
{
	String text;

	boolean selected;

	public CheckBoxNode(final String text, final boolean selected)
	{
		this.text = text;
		this.selected = selected;
	}

	public boolean isSelected()
	{
		return selected;
	}

	public void setSelected(final boolean newValue)
	{
		selected = newValue;
	}

	public String getText()
	{
		return text;
	}

	public void setText(final String newValue)
	{
		text = newValue;
	}

	@Override
	public String toString()
	{
		return text;
	}
}