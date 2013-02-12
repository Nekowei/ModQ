package items;

import proxy.ClientProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;

public class CrystalPiece extends Item{
	public CrystalPiece(int par1) {
		super(par1);
		
		setItemName("item_crystal_piece");
		setTextureFile(ClientProxy.ITEM_PATH);
		setIconCoord(0, 1);
		setCreativeTab(CreativeTabs.tabRedstone);
	}

}
