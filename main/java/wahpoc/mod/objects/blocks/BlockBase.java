package wahpoc.mod.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import wahpoc.mod.Main;
import wahpoc.mod.init.BlockInit;
import wahpoc.mod.init.ItemInit;
import wahpoc.mod.util.IHasModel;

public class BlockBase extends Block implements IHasModel
{
	public BlockBase(String name, Material material, CreativeTabs tab)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));
	}
	
	// Register the Block's Model.
	@Override
	public void registerModels()
	{
		Main.proxy.registerModel(Item.getItemFromBlock(this), 0);
	}

}
