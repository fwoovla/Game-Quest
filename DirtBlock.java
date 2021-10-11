//dirt block


public class DirtBlock extends Tile {
	
	public DirtBlock(int id) {
		super(Assets.dirt_block_1, id);
	}
	
	public boolean isSolid() {
		return false;
	}
}
