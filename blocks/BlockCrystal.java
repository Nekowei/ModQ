package blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import core.ModQ;
import proxy.ClientProxy;

public class BlockCrystal extends BlockFlower {
	public BlockCrystal(int par1, int par2,Material material) {
		super(par1, par2,material); // 左边第二个参数是图标的序号 

		setBlockName("block_crystal");
		setTextureFile(ClientProxy.BLOCK_PATH);
		setCreativeTab(CreativeTabs.tabBlock);
		setStepSound(Block.soundGlassFootstep); // <---- 设置摆放时的音效
		setHardness(15.0F);
		setResistance(100.0F);
		setLightValue(1.0F);
	
	}

	@Override
	protected boolean canThisPlantGrowOnThisBlockID(int block_id) {

		return block_id == Block.grass.blockID || 
				block_id == Block.dirt.blockID || 
				block_id == Block.stone.blockID ||
				block_id == Block.sand.blockID;
	}
	
    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        return MathHelper.clamp_int(this.quantityDropped(par2Random) + par2Random.nextInt(par1 + 1), 1, 4);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 2 + par1Random.nextInt(3);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return ModQ.crystalPiece.itemID;
    }

}