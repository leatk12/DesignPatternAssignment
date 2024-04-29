 package Assignment.Game;
 
 
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameObject {
	
	//Variable which holds the image for game objects
    protected Image img;
    protected double x, y;
    //The x and y coordinates for game objects
    protected GraphicsContext gc;
    //The width of game objects
    protected double width;
    //The height of game objects
    protected double height;

    //The horizontal speed of game objects
    protected double speedX = 8;
    //The vertical speed of game objects
    protected double speedY = 8;
    
    //Pointer to the main Game object to allow access to the game-wide properties and methods
    protected Game game;

    //Pojnter to the gameObjectBehaviour object to allow access to its methods and variables
    protected GameObjectBehaviour behaviour;

    
    /**
     * 
     * @param game
     * @param x
     * @param y
     * @param width
     * @param height
     * @param gc
     * 
     * Constructor method for GameObject class
     */
    public GameObject(Game game, double x, double y, double width, double height, GraphicsContext gc) {
       //Set the game context
    	this.game = game;
    	//Set the x variable
    	this.x = x;
    	//Set the y variable
        this.y = y;
        //Set the width variable
        this.width = width;
        //Set the height variable
        this.height = height;
        //Set the graphics context
        this.gc = gc;
        //Initialise the default game object behaviour
        behaviour = new DefaultGameObjectBehaviour(); 
    }

    
    /**
     * Method to redrawn the game object and update its behaviour
     */
    public void update() {
    	//Check that there is an image available to draw
        if (img != null)
        	//drawn the image and centre it at x and y
            gc.drawImage(img, x - width / 2, y - height / 2, width, height);
     // Delegate behaviour
        behaviour.updateBehaviour(); 
    }

    

    
    

    
    

    
   


   
/**
 * Nested static class for default behaviour of the game object
 */
    private static class DefaultGameObjectBehaviour implements GameObjectBehaviour {
        /**
         * Abstract method to update the game objects behaviour
         */
    	@Override
        public void updateBehaviour() {
            // Default behaviour is to do nothing
        }

    	/**
    	 * Abstract method to define enemy movement
    	 */
		@Override
		public void enemyMovement() {
			// TODO Auto-generated method stub
			
		}
    }

    

	  /**
	   * Abstract method to render an object
	   */
	public void render() {
		// TODO Auto-generated method stub
		
	}

	
}