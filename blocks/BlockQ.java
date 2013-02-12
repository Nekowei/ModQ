package blocks;

import proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockQ extends Block{

	public BlockQ(int par1) {
		super(par1,Material.glass);
		
		setBlockName("block_Q");
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureFile(ClientProxy.BLOCK_PATH);
	}


}
