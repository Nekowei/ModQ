package items;

import core.ModQ;
import proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;


public class HaMaker extends Item{

	public HaMaker(int par1) {
		super(par1);
		
		setItemName("item_haMaker");
		setTextureFile(ClientProxy.ITEM_PATH);
		setIconCoord(0, 0);
		setCreativeTab(CreativeTabs.tabTools);
		
	}
    @Override
    public boolean onItemUse(ItemStack item_stack, EntityPlayer player,
        World world, int x, int y, int z, int side, float x_off,
        float y_off, float z_off) {
    	
    	// side 
    	// 0-下表面 1-上表面 
    	// 2-北表面 3-南表面 
    	// 4-西表面 5-东表面
    	// off 鼠标点击处 距离方块 东-南-上 角的位置
      
    	if (world.isRemote) return true;
  
		if (player.inventory.hasItem(Block.planks.blockID)&&
			player.inventory.hasItem(Block.fence.blockID)&&
			player.inventory.hasItem(Block.pumpkinLantern.blockID))
		{	
			for (int dy = 1; dy <= 4; dy++) {    
				int new_x1 = x;
				int new_y1 = y + dy;
				int new_z1 = z;		

				player.inventory.consumeInventoryItem(Block.planks.blockID);
				String bs1="planks";
				set_block(world, new_x1, new_y1, new_z1,bs1);

				if (dy==3)
					for (int dx = -3; dx <= 3; dx++) {
						if (dx!=0){
							int new_x2 = x + dx;
							int new_y2 = y + dy;
							int new_z2 = z; 
							String bs2="fence";
							set_block(world, new_x2, new_y2, new_z2,bs2);
						}
					}    		
			}
			
			int new_x3 = x;
			int new_y3 = y + 5;
			int new_z3 = z;		
			String bs3="pumpkinLantern";
			set_block(world, new_x3, new_y3, new_z3,bs3);

			StepSound sound = Block.soundWoodFootstep;
			world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D,
					sound.getStepSound(),
					(sound.getVolume() + 1.0F) / 2.0F,
					sound.getPitch() * 0.8F);
		}
		else 
		{
			String bs = "blockHa";
			set_block(world,x,y+1,z,bs);
		}
    	return true;
    }

	private void set_block(World world, int x, int y, int z,String blocksetter) {
		int block_id = world.getBlockId(x, y, z);

		if (block_id == 0)
		{

			int y1 = y;

			int bid = world.getBlockId(x, y1, z);

			if ( bid == 0 || bid == Block.tallGrass.blockID ) {

				if (blocksetter=="planks")
				world.setBlock(x, y1, z, Block.planks.blockID); // 如果符合要求，就设置为...
				if (blocksetter=="fence")
				world.setBlock(x, y1, z, Block.fence.blockID);
				if (blocksetter=="pumpkinLantern")
				world.setBlock(x, y1, z, Block.pumpkinLantern.blockID);				
				if (blocksetter=="blockHa")
					world.setBlock(x, y1, z, ModQ.blockQ.blockID);
			}
		}
	}		
}
