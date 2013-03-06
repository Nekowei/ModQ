package blocks;

import proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockCrystalPane extends BlockPane{

	public BlockCrystalPane(int par1, int par2, int par3,
			Material par4Material, boolean par5) {
		super(par1, par2, par3, par4Material, par5);

		setBlockName("block_crystal_pane");
		setCreativeTab(CreativeTabs.tabBlock);
		setLightValue(1.0F);
		setTextureFile(ClientProxy.BLOCK_PATH);
		setStepSound(Block.soundGlassFootstep); 
	}

}
