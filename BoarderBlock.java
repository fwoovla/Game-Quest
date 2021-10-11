//Boarder tile block


public class BoarderBlock extends Tile {
	
	public BoarderBlock(int id) {
		super(Assets.boarder, id);
	}
	
	public boolean isSolid() {
		return true;
	}
}
