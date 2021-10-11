//Launcher
//launches the game


public class Launcher {
	
	public static void main(String[] args) {
		System.out.println("GameQuest loading........");
		Game game = new Game("GameQuest - The quest for game", 800, 600);
		game.start();
		
	}
}

