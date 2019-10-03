package wahpoc.mod.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import wahpoc.mod.util.handler.ItemRegistry;

public class WahPocTab extends CreativeTabs
{
	//creative tabs.
	public static final CreativeTabs wahpocbase = new WahPocTab("wahpocbase", "wahpoc.png", ItemRegistry.chocoBar);
	public static final CreativeTabs wahpocblock = new WahPocTab("wahpocblock", "wahpoc.png", ItemRegistry.chocoBar);
	
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
