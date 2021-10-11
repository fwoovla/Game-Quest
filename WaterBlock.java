//water BLock tile

public class WaterBlock extends Tile {
	
	public WaterBlock(int id) {
		super(Assets.water_tile_1, id);
	}
	
	public boolean isSolid() {
		return true;
	}
}


