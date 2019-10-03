package wahpoc.mod.util.handler;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import wahpoc.mod.objects.items.ItemBase;
import wahpoc.mod.tabs.WahPocTab;

@Mod.EventBusSubscriber
public class ItemRegistry {
	private static final HashMap<Item, String> itemRegistryMap = new HashMap<Item, String>();
	
	@GameRegistry.ObjectHolder("wahpoc:choco_bar")
	public static ItemBase chocoBar;
		
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		IForgeRegistry<Item> registry = event.getRegistry();
		
		registerItem(registry, new ItemBase("choco_bar", WahPocTab.wahpocbase), "");
	}
	
	@SubscribeEvent
	public static void registerItemModels(ModelRegistryEvent event) {
		for (Map.Entry<Item, String> itemEntry : itemRegistryMap.entrySet()) {
			registerItemRender(itemEntry.getKey(), itemEntry.getValue());
		}
	}
	
	private static void registerItem(IForgeRegistry registry, Item item, String folderLocation) {
		registry.register(item);
		itemRegistryMap.put(item, folderLocation);
	}
	
	private static void registerItemRender(Item item, String folderLocation) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation("wahpoc:" + folderLocation + item.getRegistryName().getResourcePath()), "inventory"));
	}
}
