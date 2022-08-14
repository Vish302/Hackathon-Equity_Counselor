public class GameManager {
    public static void main(String[] args) {
        new GameManager();
    }

    public GameManager() {
        Game game = new Game(this);
    }
}
