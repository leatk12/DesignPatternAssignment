package Assignment.Game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Num4 extends Enemy {

    private static final int TILE_SIZE = 40;

    public Num4(Game game, double x, double y, double tileSize, GraphicsContext gc) {
        super(game, x, y, tileSize, tileSize, gc);
        img = new Image(Num1.class.getResource("num4.png").toExternalForm());
        speedX = 1 + Game.currentSpeedIncrement;
        speedY = 1 + Game.currentSpeedIncrement;
        System.out.println("Num4 created with speedX = " + speedX + " and speedY = " + speedY);
    }

    @Override
    protected void initialiseDirection() {
        int gridX = (int) (x / TILE_SIZE);
        int gridY = (int) (y / TILE_SIZE);

        if (hasConsecutivePathTiles(gridX, gridY, 0, 1)) {
            currentDirection = Direction.UP;
        } else if (hasConsecutivePathTiles(gridX, gridY, 0, -1)) {
            currentDirection = Direction.DOWN;
        } else if (hasConsecutivePathTiles(gridX, gridY, -1, 0)) {
            currentDirection = Direction.LEFT;
        } else if (hasConsecutivePathTiles(gridX, gridY, 1, 0)) {
            currentDirection = Direction.RIGHT;
        }

        if (currentDirection != Direction.NONE) {
            directionInitialized = true;
        }
    }

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}
}
