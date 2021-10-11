//sand tile block
public class SandBlock extends Tile {
	
	public SandBlock(int id) {
		super(Assets.sand_block, id);
	}
	
	public boolean isSolid() {
		return false;
	}
}
