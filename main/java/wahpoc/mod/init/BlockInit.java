package wahpoc.mod.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import wahpoc.mod.Main;
import wahpoc.mod.objects.blocks.BlockBase;

public class BlockInit 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//Chocolate
	public static final Block CHOCO_BLOCK = new BlockBase("choco_block", Material.IRON, Main.wahpocblock);
}
