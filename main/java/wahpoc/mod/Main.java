package wahpoc.mod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import wahpoc.mod.init.ItemInit;
import wahpoc.mod.proxy.CommonProxy;
import wahpoc.mod.tabs.WahPocTab;
import wahpoc.mod.util.Reference;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main 
{
	@Instance
	public static Main instance;
	
	//creative tabs.
	public static final CreativeTabs wahpocbase = new WahPocTab("wahpocbase", "wahpoc.png", ItemInit.CHOCO_BAR);
	public static final CreativeTabs wahpocblock = new WahPocTab("wahpocblock", "wahpoc.png", ItemInit.CHOCO_BAR);
	
	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {}

	@EventHandler
	public static void init(FMLInitializationEvent event) {}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {}

}
