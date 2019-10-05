package wahpoc.mod.objects.blocks.decor;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class StairsBase extends BlockStairs {
	public StairsBase (String name, Material material, CreativeTabs tab, Block baseBlock) {
		super(baseBlock.getDefaultState());
		setUnlocalizedName(name);
		setRegistryName("wahpoc:" + name);
		setCreativeTab(tab);
		useNeighborBrightness = true;
	}
}
