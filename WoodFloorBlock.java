//wood floor tile


public class WoodFloorBlock extends Tile {
	
	public WoodFloorBlock(int id) {
		super(Assets.wood_floor, id);
	}
	
	public boolean isSolid() {
		return false;
	}
}
