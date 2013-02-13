package core;

import blocks.*;
import generater.GenerateCrystal;
import items.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.MinecraftForge;
import proxy.Proxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid="ModQ",name="ModQ",version="0.0.6")
@NetworkMod(clientSideRequired=true,serverSideRequired=false)
public class ModQ {
	@Instance("ModQ")
	public static ModQ instance;
	
	@SidedProxy(clientSide="proxy.ClientProxy",serverSide="proxy.Proxy")
	public static Proxy proxy;
	
	final public static int ITEM_CRYSTAL_PIECE = 10001;
	
	public static Block block_Q=new BlockQ(500,0,Material.air);
	public static Block block_crystal=new BlockCrystal(502,17,Material.iron);
	
	public static Item item_haMaker=new HaMaker(10000);
	public static Item item_crystal_piece=new CrystalPiece(10001);
	
	@Init
	public void init(FMLInitializationEvent event){
		proxy.init();
		

		ModLoader.registerBlock(block_Q);
		ModLoader.addName(block_Q, "I了个Q~");
		

		ModLoader.registerBlock(block_crystal);
		ModLoader.addName(block_crystal, "水晶");
		MinecraftForge.setBlockHarvestLevel(block_crystal, "pickaxe", 2);
		ModLoader.addRecipe(new ItemStack(block_crystal),new Object[]{
			"a,a",
			"a,a",
			"",
			Character.valueOf('a'),
			item_crystal_piece,
		} );
		

		ModLoader.addName(item_haMaker, "哈");
		ModLoader.addRecipe(new ItemStack(item_haMaker),new Object[]{
			"a",
			"b",
			"c",
			Character.valueOf('a'),
			Item.appleGold,
			Character.valueOf('b'),
			Item.bone,
			Character.valueOf('c'),
			Item.book,
		} );
	
		ModLoader.addName(item_crystal_piece, "水晶碎片");

		
		
		GameRegistry.registerWorldGenerator(new GenerateCrystal());
		
	}

}
