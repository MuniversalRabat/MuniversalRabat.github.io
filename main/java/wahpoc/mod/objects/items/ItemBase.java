package wahpoc.mod.objects.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import wahpoc.mod.Main;

public class ItemBase extends Item 
{
	public ItemBase(String name, CreativeTabs tab) 
	{
		setUnlocalizedName(name);
		setRegistryName("wahpoc:" + name);
		setCreativeTab(tab);
	}
}
