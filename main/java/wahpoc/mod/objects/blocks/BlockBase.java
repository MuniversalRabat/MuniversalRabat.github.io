package wahpoc.mod.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import wahpoc.mod.Main;


public class BlockBase extends Block
{
	public BlockBase(String name, Material material, CreativeTabs tab)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName("wahpoc:" + name);
		setCreativeTab(tab);
	}
	
}