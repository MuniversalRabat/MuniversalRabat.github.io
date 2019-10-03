package wahpoc.mod.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import wahpoc.mod.init.ItemInit;

public class WahPocTab extends CreativeTabs
{
	private Item toLabel;
	public WahPocTab(String label, String imageName, Item toLabel)
	{
		super(label);
		this.setBackgroundImageName(imageName);
		
		this.toLabel = toLabel;
		
	}
	
	@Override
	public ItemStack getTabIconItem()
	{
		return new ItemStack(this.toLabel);
	}
}
