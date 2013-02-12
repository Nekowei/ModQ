package proxy;

import net.minecraftforge.client.*;

public class ClientProxy extends Proxy{
	
	public final static String BLOCK_PATH="/png/pic1.png";
	public final static String ITEM_PATH="/png/pic2item.png";
	
	@Override
	public void init(){
		MinecraftForgeClient.preloadTexture(BLOCK_PATH);
		MinecraftForgeClient.preloadTexture(ITEM_PATH);
	}

}
