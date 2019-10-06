package wahpoc.mod.objects.blocks.decor;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistry;

public abstract class SlabBase extends BlockSlab{
	public static final PropertyEnum<Variant> VARIANT = PropertyEnum.<Variant>create("variant", Variant.class);
	private HalfSlabBlock halfBlock;

	public SlabBase(String name, String registryName, Material material, CreativeTabs tab) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName("wahpoc:" + (isDouble() ? "double_" : "") + registryName);
		setCreativeTab(tab);
		
		useNeighborBrightness = !isDouble();
		IBlockState state = blockState.getBaseState().withProperty(VARIANT, Variant.DEFAULT);
		
		if (!isDouble()) {
			state.withProperty(HALF, EnumBlockHalf.BOTTOM);
			halfBlock = (HalfSlabBlock)this;
		}
		
		setDefaultState(state);
	}
	
	@Override
	public String getUnlocalizedName(int meta) {
		return super.getUnlocalizedName();
	}
	
	@Override
	public IProperty<?> getVariantProperty() {
		return VARIANT;
	}
	
	@Override
	public Comparable<?> getTypeForItem(ItemStack stack) {
		return Variant.DEFAULT;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(halfBlock);
	}
	
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(halfBlock);
	}
	
	public HalfSlabBlock getHalfBlock() {
		return halfBlock;
	}
	
	@Override
	public final IBlockState getStateFromMeta(final int meta) {
		IBlockState state = blockState.getBaseState().withProperty(VARIANT, Variant.DEFAULT);
		
		if (!isDouble())
				state = state.withProperty(HALF, ((meta & 8) != 0) ? EnumBlockHalf.TOP : EnumBlockHalf.BOTTOM);
		
		return state;
	}
	
	@Override
	public final int getMetaFromState(final IBlockState state) {
		int meta = 0;
		
		if (!isDouble() && state.getValue(HALF) == EnumBlockHalf.TOP)
			meta |= 8;
		
		return meta;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		if (!isDouble())
			return new BlockStateContainer(this, VARIANT, HALF);
		
		return new BlockStateContainer(this, VARIANT);
	}
	
	public static class DoubleSlabBlock extends SlabBase {
		public DoubleSlabBlock (String name, String registryName, Material material, CreativeTabs tab) {
			super(name, registryName, material, tab);
		}
		
		@Override
		public boolean isDouble() {
			return true;
		}
		
		public DoubleSlabBlock registerHalfSlab(IForgeRegistry<Block> registry) {
			HalfSlabBlock halfSlab = new SlabBase.HalfSlabBlock(this.getUnlocalizedName().replace("tile.", ""), this.getRegistryName().toString().replace("wahpoc:double_",  ""), this.getMaterial(getDefaultState()), null);
			setHalfBlock(halfSlab);
			registry.register(halfSlab);
			
			return this;
		}

	}

	
	public static class HalfSlabBlock extends SlabBase {
		public HalfSlabBlock(String name, String registryName, Material material, CreativeTabs tab) {
			super(name, registryName, material, tab);
			
		}
		
		@Override
		public boolean isDouble() {
			return false;
		}
	}
	
	public void setHalfBlock(HalfSlabBlock block) {
		this.halfBlock = block;
	}
	
	public enum Variant implements IStringSerializable {
		DEFAULT;
		
		@Override
		public String getName() {
			return "default";
		}
	}
}
