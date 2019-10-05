package wahpoc.mod.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class WahPocTab extends CreativeTabs
{
	private String toLabel;
	public WahPocTab(String label, String imageName, String toLabel)
	{
		super(label);
		this.setBackgroundImageName(imageName);
		
		this.toLabel = toLabel;
		
	}
	
	@Override
	public ItemStack getTabIconItem()
	{
		return new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("wahpoc", this.toLabel)));
	}
}
