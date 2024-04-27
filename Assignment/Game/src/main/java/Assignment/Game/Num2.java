package Assignment.Game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Num2 extends Enemy {

	//Defining a constant to hold the tile size which is used for positioning and movement calculations
    private static final int TILE_SIZE = 40;

    /**
     * 
     * @param game
     * @param x
     * @param y
     * @param tileSize
     * @param gc
     * 
     * Constructor for Num2 class
     */
    public Num2(Game game, double x, double y, double tileSize, GraphicsContext gc) {
    	//Call the superclass constructor with the provided parameters
    	super(game, x, y, tileSize, tileSize, gc);
    	//Load the image used to represent this enemy type from resources
        img = new Image(Num1.class.getResource("num2.png").toExternalForm());
      //Set the horizontal speed. 
        //Accounts for speed increments upon the player killing all enemies and new enemies spawning
        speedX = 1 + Game.currentSpeedIncrement;
      //Set the vertical speed. 
        //Accounts for speed increments upon the player killing all enemies and new enemies spawning
        speedY = 1 + Game.currentSpeedIncrement;
      //Print the speeds to console for debugging purposes
        System.out.println("Num2 created with speedX = " + speedX + " and speedY = " + speedY);
    }

    /**
     * A method which provides a concrete implementation of the abstract initialiseDirection method from the enemy class
     */
    @Override
    protected void initialiseDirection() {
    	//Calculate the grid x coordinate using the current x coordinate and the tile size
    	int gridX = (int) (x / TILE_SIZE);
    	//Calculate the grid y coordinate using the current y coordinate and the tile size
    	int gridY = (int) (y / TILE_SIZE);

    	//Determine the initial movement direction dependent on the available path tiles in the immediate vicinity
        if (hasConsecutivePathTiles(gridX, gridY, 0, 1)) {
        	//Set the currentDirection variable to up if there is a valid path above
        	currentDirection = Direction.UP;
        } else if (hasConsecutivePathTiles(gridX, gridY, 0, -1)) {
        	//Set the currentDirection variable down up if there is a valid path below
        	currentDirection = Direction.DOWN;
        } else if (hasConsecutivePathTiles(gridX, gridY, -1, 0)) {
        	//Set the currentDirection variable to left if there is a valid path to the left
        	currentDirection = Direction.LEFT;
        } else if (hasConsecutivePathTiles(gridX, gridY, 1, 0)) {
        	//Set the currentDirection variable to right if there is a valid path to the right
        	currentDirection = Direction.RIGHT;
        }
      //Check that the currentDirection variable has been initialised
        if (currentDirection != Direction.NONE) {
        	//Set the flag to true if the currentDirection variable has been initialised
            directionInitialized = true;
        }
    }

    
    /**
     * @return
     * 
     * Getter method which overrides the getX method in the enemy class
     */
	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}

	
	/**
	 * @return
	 * 
	 * Getter method which overrides the getY method in the enemy class
	 */
	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}
}
