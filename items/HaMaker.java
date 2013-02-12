package items;

import proxy.ClientProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;

public class HaMaker extends Item{

	public HaMaker(int par1) {
		super(par1);
		
		setItemName("item_haMaker");
		setTextureFile(ClientProxy.ITEM_PATH);
		setIconCoord(0, 0);
		setCreativeTab(CreativeTabs.tabTools);
		


	}

}
