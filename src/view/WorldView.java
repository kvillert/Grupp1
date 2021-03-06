package view;

import java.util.ArrayList;
import java.util.List;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

import model.FixedPosition;
import utils.WorldBodyFactory;
import utils.WorldUtils;
/**
 * 
 * @author Josefin, Martin, Sara, Kino
 *
 */
public class WorldView {
	public static final float NORMAL_FRICTION = 0.7f;
	public static final float ICE_FRICTION = 0f;
	public static final float NO_BOUNCE_RESTITUTION = 0f;
	public static final float BOUNCE_RESTITUTION = 1f;
	
	final private model.World world;
	final private Vec2 gravity;
	final boolean doSleep;
	final private World jBox2DWorld;
	private Body groundBody;
	final private BlockMapView blockMapView;
	final private List<ItemView> itemViewList;
	final private List<CandyMonsterView> candyMonsterViewList;
	final private float worldWidthMeter;
	final private float worldHeightMeter;
	final public CharacterView characterView;
	
	public WorldView(final model.World world, final CharacterView characterView, final BlockMapView blockMapView, 
			final List<ItemView> itemViewList, 
			final List<CandyMonsterView> candyMonsterViewList) {
		this.world = world;
		this.characterView = characterView;
		worldWidthMeter = WorldUtils.pixel2Meter(world.getWorldWidthPx());
		worldHeightMeter = WorldUtils.pixel2Meter(world.getWorldHeightPx());
		this.blockMapView = blockMapView;
		this.itemViewList = itemViewList;
		this.candyMonsterViewList = candyMonsterViewList;
		gravity = new Vec2(0.0f, 9.82f);
		doSleep = true;
		jBox2DWorld = new World(gravity, doSleep);

		//ground of window
		WorldBodyFactory.addSolidGround(new Vec2(0, worldHeightMeter), new Vec2(worldWidthMeter, WorldUtils.pixel2Meter(2)),
				NORMAL_FRICTION, NO_BOUNCE_RESTITUTION, jBox2DWorld); //(x, y, width, height)
		//left wall of window
		WorldBodyFactory.addSolidGround(new Vec2(0, 0), new Vec2(WorldUtils.pixel2Meter(2), worldHeightMeter),
				NORMAL_FRICTION, NO_BOUNCE_RESTITUTION, jBox2DWorld);
		//right wall of window
		WorldBodyFactory.addSolidGround(new Vec2(worldWidthMeter, 0), new Vec2(WorldUtils.pixel2Meter(2), worldHeightMeter),
				NORMAL_FRICTION, NO_BOUNCE_RESTITUTION, jBox2DWorld);
		//roof of window
		WorldBodyFactory.addSolidGround(new Vec2(0, 0), new Vec2(worldWidthMeter, WorldUtils.pixel2Meter(2)),
				NORMAL_FRICTION, NO_BOUNCE_RESTITUTION, jBox2DWorld);

		//Create normal ground
		addIterativeSolids(this.blockMapView.getSolidGroundMap().getBlockList(), NORMAL_FRICTION, NO_BOUNCE_RESTITUTION);		
		
		//Create ice
		addIterativeSolids(this.blockMapView.getIceMap().getBlockList(), ICE_FRICTION, NO_BOUNCE_RESTITUTION);		
		
		//Create springs
		addIterativeSolids(this.blockMapView.getSpringMap().getBlockList(), NORMAL_FRICTION, BOUNCE_RESTITUTION);
		
		//Create clouds
		addIterativeSolids(this.blockMapView.getIceSpringMap().getBlockList(), ICE_FRICTION, BOUNCE_RESTITUTION);
	}
	
	public model.World getWorld() {
		return world;
	}

	public CharacterView getCharacterView() {
		return characterView;
	}

	public World getjBox2DWorld() {
		return jBox2DWorld;
	}

	public BlockMapView getBlockMapView() {
		return blockMapView;
	}

	public List<ItemView> getItemViewList() {
		return itemViewList;
	}

	public List<CandyMonsterView> getCandyMonsterViewList() {
		return candyMonsterViewList;
	}

	public Body getGroundBody() {
		return groundBody;
	}	
	
	private void addIterativeSolids(ArrayList<FixedPosition> blockList, final float friction, final float restitution) {
		for (FixedPosition block : blockList) {
			WorldBodyFactory.addSolidGround(new Vec2(WorldUtils.pixel2Meter(block.getPosX() + this.blockMapView.getTiledMap().getTileWidth()/2),
					WorldUtils.pixel2Meter(block.getPosY() + this.blockMapView.getTiledMap().getTileWidth()/2)),
					new Vec2(WorldUtils.pixel2Meter(this.blockMapView.getTiledMap().getTileWidth()/2),
							WorldUtils.pixel2Meter(this.blockMapView.getTiledMap().getTileHeight()/2)),
							friction, restitution, jBox2DWorld);
		}
	}
}
