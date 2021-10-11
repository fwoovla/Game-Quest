//Grass block



public class GrassBlock extends Tile {
	
	public GrassBlock(int id) {
		super(Assets.grass_block_1, id);
	}
	
	public boolean isSolid() {
		return false;
	}
}
