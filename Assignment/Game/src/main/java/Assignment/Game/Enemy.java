package Assignment.Game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Enemy extends GameObject {

    public enum Direction {
        LEFT, RIGHT, UP, DOWN, NONE
    }

    protected Direction currentDirection = Direction.NONE;
    protected boolean directionInitialized = false;

    public Enemy(double x, double y, double width, double height, GraphicsContext gc) {
        super(x, y, width, height, gc);
    }

    @Override
    public void update() {
        if (!directionInitialized) {
            initialiseDirection();
        } else {
            enemyMovement();
        }
        super.update();
    }

    protected abstract void initialiseDirection();

    @Override
    public void moveDown() {
        double newY = y + speedY;
        if (!isWall(x, newY)) {
            y = newY;
        }
    }

    @Override
    public void moveUp() {
        double newY = y - speedY;
        if (!isWall(x, newY)) {
            y = newY;
        }
    }

    @Override
    public void moveLeft() {
        double newX = x - speedX;
        if (!isWall(newX, y)) {
            x = newX;
        }
    }

    @Override
    public void moveRight() {
        double newX = x + speedX;
        if (!isWall(newX, y)) {
            x = newX;
        }
    }

    public void enemyMovement() {
        switch (currentDirection) {
            case DOWN:
                if (isWall(x, y + speedY)) {
                    currentDirection = Direction.UP;
                } else {
                    moveDown();
                }
                break;
            case UP:
                if (isWall(x, y - speedY)) {
                    currentDirection = Direction.DOWN;
                } else {
                    moveUp();
                }
                break;
            case LEFT:
                if (isWall(x - speedX, y)) {
                    currentDirection = Direction.RIGHT;
                } else {
                    moveLeft();
                }
                break;
            case RIGHT:
                if (isWall(x + speedX, y)) {
                    currentDirection = Direction.LEFT;
                } else {
                    moveRight();
                }
                break;
            default:
                break;
        }
    }

    protected boolean hasConsecutivePathTiles(int gridX, int gridY, int offsetX, int offsetY) {
        int nextGridX = gridX + offsetX;
        int nextGridY = gridY + offsetY;
        int nextNextGridX = nextGridX + offsetX;
        int nextNextGridY = nextGridY + offsetY;
        return isPath(nextGridX, nextGridY) && isPath(nextNextGridX, nextNextGridY);
    }

    protected boolean isPath(int gridX, int gridY) {
        if (gridX < 0 || gridX >= Game.getNumTilesX() || gridY < 0 || gridY >= Game.getNumTilesY()) {
            return false; // Out of bounds
        }
        return Game.getMaze()[gridX][gridY] == 0; // 0 represents a path
    }

	protected abstract double getX();

	protected abstract double getY();
}
