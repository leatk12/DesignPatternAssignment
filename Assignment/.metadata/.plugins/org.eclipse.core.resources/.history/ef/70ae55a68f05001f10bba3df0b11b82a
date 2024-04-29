package Assignment.Game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Enemy extends GameObject {

	/**
	 * Method of the type enumeration whcih defines possible movement directions
	 */
    public enum Direction {
        LEFT, RIGHT, UP, DOWN, NONE
    }

    //Variable of type Direction which stores the current direction of the enemy object.  Sets it as NONE by default
    protected Direction currentDirection = Direction.NONE;
    //A flag used to determine if the intial enemy direction has been set
    protected boolean directionInitialized = false;

    /**
     * 
     * @param game
     * @param x
     * @param y
     * @param width
     * @param height
     * @param gc
     * 
     * Constructor for the enemy class
     */
    public Enemy(Game game, double x, double y, double width, double height, GraphicsContext gc) {
        //Call the superclass constructor with the provided values
    	super(game, x, y, width, height, gc);
    }

    /**
     * Method which intialises the enemies direction
     * Continues with regular movement if the direction has already been initialised
     * Call the update method from the superclass
     */
    @Override
    public void update() {
        if (!directionInitialized) {
            initialiseDirection();
        } else {
            enemyMovement();
        }
        super.update();
    }

    
    /**
     * Abstract method to initialise the enemy objects direction
     * Concrete implementation is in the super class
     */
    protected abstract void initialiseDirection();

    /**
     * Method which allows enemy objects to move downwards if the direction is not a wall tile
     */
    @Override
    public void moveDown() {
    	// Calculate the new Y for moving down
        double newY = y + speedY;
        //Check that the new position is not blocked by a wall
        if (!game.isWall(x, newY)) {
        	//Update the Y position is there is no wall detected
            y = newY;
        }
    }

    /**
     * Method which allows enemy objects to move upwards if the direction is not a wall tile
     */
    @Override
    public void moveUp() {
    	//Calculate the new Y position for moving up
        double newY = y - speedY;
        //Check that the new position is not blocked by a wall
        if (!game.isWall(x, newY)) {
        	//Update the Y position if there is no wall on this tile
            y = newY;
        }
    }

    
    /**
     * Method which allows enemy objects to move left if the direction is not a wall tile
     */
    @Override
    public void moveLeft() {
    	//Calculate the new X position for moving left
        double newX = x - speedX;
        //Check that the new position is not blocked by a wall tile
        if (!game.isWall(newX, y)) {
        	//Update the X position if there is no wall on this tile
            x = newX;
        }
    }

    /**
     * Method which allows enemy objects to move right if the direction is not a wall tile
     */
    @Override
    public void moveRight() {
    	//Calculate the new X position for moving right
        double newX = x + speedX;
        //Check that the new position is not blocked by a wall tile
        if (!game.isWall(newX, y)) {
        	//Update the X position if there is no wall on this tile
            x = newX;
        }
    }

    /**
     * Method which handles enemy-specific movement
     * Movement is based on the currentDirection variable and checking for walls
     */
    public void enemyMovement() {
        switch (currentDirection) {
            case DOWN:
            	//If moving down leads to a wall change direction to up
                if (game.isWall(x, y + speedY)) {
                    currentDirection = Direction.UP;
                } else {
                	//otherwise keep moving down
                    moveDown();
                }
                break;
            case UP:
            	//If moving up leads to a wall change direction to down
                if (game.isWall(x, y - speedY)) {
                    currentDirection = Direction.DOWN;
                } else {
                	//otherwise keep moving up
                    moveUp();
                }
                break;
            case LEFT:
            	//If moving right leads to a wall change direction to left
                if (game.isWall(x - speedX, y)) {
                    currentDirection = Direction.RIGHT;
                } else {
                	//Otherwise keep moving left
                    moveLeft();
                }
                break;
            case RIGHT:
            	//If moving left leads to a wall change direction to right
                if (game.isWall(x + speedX, y)) {
                    currentDirection = Direction.LEFT;
                } else {
                	//Otherwise keep moving right
                    moveRight();
                }
                break;
            default:
            	//No movement if direction has not been defined
                break;
        }
    }

    
    /**
     * 
     * @param gridX
     * @param gridY
     * @param offsetX
     * @param offsetY
     * @return
     * 
     * A method used to identify whether two consecutive tiles in the specified direction are paths
     * Purpose is to assist in enemy pathing 
     */
    protected boolean hasConsecutivePathTiles(int gridX, int gridY, int offsetX, int offsetY) {
        int nextGridX = gridX + offsetX;
        int nextGridY = gridY + offsetY;
        int nextNextGridX = nextGridX + offsetX;
        int nextNextGridY = nextGridY + offsetY;
        //Check whether both of the tiles re paths
        return isPath(nextGridX, nextGridY) && isPath(nextNextGridX, nextNextGridY);
    }

    /**
     * 
     * @param gridX
     * @param gridY
     * @return
     * 
     * A method used to determine whether a specific tile o=is a path
     * paths are attributed the value 0
     */
    protected boolean isPath(int gridX, int gridY) {
        if (gridX < 0 || gridX >= Game.getNumTilesX() || gridY < 0 || gridY >= Game.getNumTilesY()) {
            //Returns false if the position is out of bounds
        	return false; 
        }
        //Return true if the tile at this position is a path
        return Game.getMaze()[gridX][gridY] == 0; // 0 represents a path
    }

    /**
     * @return
     * 
     * getter method which returns the value of x
     */
	public double getX()  {
		return x;
	}

	/**
	 * @return
	 * 
	 * getter method which returns the value of y
	 */
	public double getY()  {
		return y;
	}

	/**
	 * @return
	 * 
	 * getter method which returns the value of width
	 */
	public double getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	/**
	 * @return
	 * Getter method which returns the value of height
	 */
	public double getHeight() {
		// TODO Auto-generated method stub
		return height;
	}
	
	/**
	 * 
	 * @param increment
	 * 
	 * Setter method used to increment enemy speeds in both x and y axis
	 */
	public void incrementSpeed(double increment) {
        speedX += increment;
        speedY += increment;
    }
	
}
