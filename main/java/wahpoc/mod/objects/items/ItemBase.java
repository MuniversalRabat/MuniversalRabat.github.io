package wahpoc.mod.objects.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import wahpoc.mod.Main;
import wahpoc.mod.init.ItemInit;
import wahpoc.mod.util.IHasModel;

public class ItemBase extends Item implements IHasModel 
{
	public ItemBase(String name, CreativeTabs tab) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		
		ItemInit.ITEMS.add(this);
	}
	
	// Register the Item's Model.
	@Override
	public void registerModels()
	{
		Main.proxy.registerModel(this, 0);
	}
}
