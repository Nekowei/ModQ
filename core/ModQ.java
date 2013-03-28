package core;

import blocks.*;
import generater.GenerateCrystal;
import items.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import proxy.Proxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid="ModQ",name="ModQ",version="0.1.2")
@NetworkMod(clientSideRequired=true,serverSideRequired=false)
public class ModQ {
	@Instance("ModQ")
	public static ModQ instance;
	
	@SidedProxy(clientSide="proxy.ClientProxy",serverSide="proxy.Proxy")
	public static Proxy proxy;
		
	public static Block blockQ=new BlockQ(666,0,Material.air);
	public static Block blockCrystal = new BlockCrystal(667,17,Material.iron);
	public static Block blockCrystalGlass=new BlockCrystalGlass(668,19,Material.glass,false);
	public static Block blockCrystalPane=new BlockCrystalPane(669,19,19,Material.glass,false);
	
	public static Item haMaker = new HaMaker(10000);
	public static Item crystalPiece = new CrystalPiece(10001);
	
//	@PreInit
//	public void pre_init(FMLPreInitializationEvent event){
//		Configuration config= new Configuration(event.getSuggestedConfigurationFile());
//		config.load();
		
//		block_Q = new BlockQ(config.getBlock("block_Q", 5000).getInt(),0,Material.air);
//		block_crystal = new BlockCrystal(config.getBlock("block_crystal",5002).getInt(),17,Material.iron);
//		block_crystal_glass = new BlockCrystalGlass(config.getBlock("block_crystal_glass",5003).getInt(),18,Material.glass,false);
//		block_crystal_pane = new BlockCrystalPane(config.getBlock("block_crystal_glass",5004).getInt(),19,19,Material.glass,false); 
		
//		item_haMaker = new HaMaker(config.getItem("item_haMaker",10000).getInt());
//		item_crystal_piece = new CrystalPiece(config.getItem("item_crystal_piece",10001).getInt());
//		config.save();
//	}
	
	@Init
	public void init(FMLInitializationEvent event){
		proxy.init();
		

		ModLoader.registerBlock(blockQ);
		ModLoader.addName(blockQ, "I了个Q~");		
		GameRegistry.addRecipe(new ItemStack(blockQ,6),new Object[]{
			"a",
			"b",
			Character.valueOf('a'),ModQ.blockCrystalGlass,
			Character.valueOf('b'),ModQ.crystalPiece,
		} );

		ModLoader.registerBlock(blockCrystal);
		ModLoader.addName(blockCrystal, "水晶");
		MinecraftForge.setBlockHarvestLevel(blockCrystal, "pickaxe", 2);
		GameRegistry.addRecipe(new ItemStack(blockCrystal),new Object[]{
			"a",
			"a",
			"a",
			Character.valueOf('a'),ModQ.crystalPiece
		} );

		ModLoader.registerBlock(blockCrystalPane);
		ModLoader.addName(blockCrystalPane, "水晶玻璃片");
		GameRegistry.addRecipe(new ItemStack(blockCrystalPane,12), new Object[]{
			"aa",
			"aa",
			Character.valueOf('a'),ModQ.blockCrystalGlass
		} );
		
		ModLoader.registerBlock(blockCrystalGlass);
		ModLoader.addName(blockCrystalGlass, "水晶玻璃");
	
		ModLoader.addName(haMaker, "哈");
		GameRegistry.addRecipe(new ItemStack(haMaker),new Object[]{
			"a",
			"b",
			"c",
			Character.valueOf('a'),ModQ.blockCrystalGlass,
			Character.valueOf('b'),ModQ.crystalPiece,
			Character.valueOf('c'),Item.book
		} );
	
		ModLoader.addName(crystalPiece, "水晶碎片");

		
		
		GameRegistry.registerWorldGenerator(new GenerateCrystal());
		
	}

}
