//fountain tile

public class FountainBlock extends Tile {
	
	public FountainBlock(int id) {
		super(Assets.fountain, id);
	}
	
	public boolean isSolid() {
		return false;
	}
}
