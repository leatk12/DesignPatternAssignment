package Assignment.Game;

public class GameContext {
    public static int TILE_SIZE = 40;
    public static int NUM_TILES_X = 20;
    public static int NUM_TILES_Y = 15;
    public static int[][] maze = new int[NUM_TILES_X][NUM_TILES_Y];

    public static boolean isWall(double x, double y) {
        int gridX = (int) x / TILE_SIZE;
        int gridY = (int) y / TILE_SIZE;
        if (gridX < 0 || gridX >= NUM_TILES_X || gridY < 0 || gridY >= NUM_TILES_Y) {
            return true; // Out of bounds
        }
        return maze[gridX][gridY] == 1; // 1 represents a wall
    }
}
