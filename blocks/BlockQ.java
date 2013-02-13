package blocks;

import proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockQ extends Block{

	public BlockQ(int par1,int par2,Material material) {
		super(par1,par2,material);
		
		setBlockName("block_Q");
		setCreativeTab(CreativeTabs.tabBlock);
		setTextureFile(ClientProxy.BLOCK_PATH);
	}


}
