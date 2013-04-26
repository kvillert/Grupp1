package view;

import java.io.InputStream;

import model.Block;
import model.BlockMap;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class BlockMapView {
	private BlockMap solidGroundMap;
	private BlockMap candyMonsterMap;
	private BlockMap spikesMap;
	private BlockMap itemMap;
	private TiledMap tiledMap;
	
	public BlockMapView(BlockMap solidGroundMap, BlockMap candyMonsterMap, BlockMap spikesMap, BlockMap itemMap, TiledMap tiledMap) {
		this.solidGroundMap = solidGroundMap;
		this.candyMonsterMap = candyMonsterMap;
		this.spikesMap = spikesMap;
		this.itemMap = itemMap;
		this.tiledMap = tiledMap;

		//loop through map and place out Blocks
		for (int x = 0; x < tiledMap.getWidth(); x++) {
			for (int y = 0; y < tiledMap.getHeight(); y++) {
			int firstgid = tiledMap.getTileId(x, y, tiledMap.getLayerIndex("layer"));
				String tileProperty = tiledMap.getTileProperty(firstgid, "property", "nothing"); //If there were no value it would return false
				if (tileProperty.equals("solidGround")) { //if the tile is solid ground, then add its properties to a Block-list
					solidGroundMap.getBlockList().add(new Block(x * tiledMap.getTileWidth(),
							y * tiledMap.getTileHeight()));
				} else if (tileProperty.equals("candyMonster")) {
					candyMonsterMap.getBlockList().add(new Block(x * tiledMap.getTileWidth(),
							y * tiledMap.getTileHeight()));
				} else if (tileProperty.equals("spikes")) {
					spikesMap.getBlockList().add(new Block(x * tiledMap.getTileWidth(),
							y * tiledMap.getTileHeight()));
				} else if (tileProperty.equals("item")) {
					itemMap.getBlockList().add(new Block(x * tiledMap.getTileWidth(),
							y * tiledMap.getTileHeight()));
				}
				
			}
		}
	}

	public BlockMap getSolidGroundMap() {
		return solidGroundMap;
	}

	public BlockMap getCandyMonsterMap() {
		return candyMonsterMap;
	}

	public BlockMap getSpikesMap() {
		return spikesMap;
	}

	public BlockMap getItemMap() {
		return itemMap;
	}

	public TiledMap getTiledMap() {
		return tiledMap;
	}
}