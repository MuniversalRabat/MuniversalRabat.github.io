package wahpoc.mod.util.registration;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import wahpoc.mod.objects.blocks.BlockBase;
import wahpoc.mod.objects.blocks.decor.SlabBase;
import wahpoc.mod.objects.blocks.decor.StairsBase;
import wahpoc.mod.tabs.CreativeTabsRegistry;

@Mod.EventBusSubscriber
public class BlockRegistry {
	private static final HashMap<Item, String> itemBlockRegistryMap = new HashMap<Item, String>();
	
	@GameRegistry.ObjectHolder("wahpoc:choco_block")
	public static BlockBase chocoBlock;
	@GameRegistry.ObjectHolder("wahpoc:wafer_planks")
	public static BlockBase waferPlanks;
	@GameRegistry.ObjectHolder("wahpoc:wafer_slab")
	public static SlabBase waferSlab;
	@GameRegistry.ObjectHolder("wahpoc:wafer_stairs")
	public static StairsBase waferStairs;
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> registry = event.getRegistry();
		
		registerBlock(registry, new BlockBase("choco_block", Material.CAKE, CreativeTabsRegistry.wahpocblock).setLightLevel(15), "");
		registerBlock(registry, new BlockBase("wafer_planks", Material.WOOD, CreativeTabsRegistry.wahpocblock), "");
		registerBlock(registry, new SlabBase.DoubleSlabBlock("wafer_slab", "wafer_slab", Material.WOOD, CreativeTabsRegistry.wahpocblock), "");
		registerBlock(registry, new StairsBase("wafer_stairs", Material.WOOD, CreativeTabsRegistry.wahpocblock, getBlock("wafer_planks")), "");
	}
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
		for (Item itemBlock : itemBlockRegistryMap.keySet()) {
			event.getRegistry().register(itemBlock);
		}
	}
	
	@SubscribeEvent
	public static void registerItemModels(ModelRegistryEvent event) {
		for (Map.Entry<Item, String> itemEntry: itemBlockRegistryMap.entrySet()) {
			registerItemRender(itemEntry.getKey(), itemEntry.getValue());
		}
	}
	
	private static void registerBlock(IForgeRegistry registry, Block block, String folderLocation) {
		registry.register(block);
		itemBlockRegistryMap.put(new ItemBlock(block).setRegistryName(block.getRegistryName()), folderLocation);
	}
	
	private static void registerItemRender(Item item, String folderLocation) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation("wahpoc:" + folderLocation + item.getRegistryName().getResourcePath()), "inventory"));
	}
	
	public static Block getBlock(String registryName)
	{
		return ForgeRegistries.BLOCKS.getValue(new ResourceLocation("wahpoc", registryName));
	}
}
