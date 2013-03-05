package generater;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;
import core.ModQ;

public class GenerateCrystal implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
			break;
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
			break;
		}
	}

	private void generateSurface(World world, Random rand, int block_x, int block_z) {

		if (rand.nextInt(2) != 0) return; 

		int x = block_x + rand.nextInt(16);
		int z = block_z + rand.nextInt(16);
		int y = rand.nextInt(128);

		for (int i = 0; i < 16; ++i) { 
			int set_x = x + rand.nextInt(8) - rand.nextInt(8);
			int set_y = y + rand.nextInt(4) - rand.nextInt(4);
			int set_z = z + rand.nextInt(8) - rand.nextInt(8);

			if (world.isAirBlock(set_x, set_y, set_z)
					&& ModQ.block_crystal.canBlockStay(world, set_x, set_y, set_z)) { 
				world.setBlock(set_x, set_y, set_z, ModQ.block_crystal.blockID);
			}
		}
	}

	@SuppressWarnings("unused")
	private void generateNether(World world, Random rand, int block_x, int block_z) {
		
	}
}