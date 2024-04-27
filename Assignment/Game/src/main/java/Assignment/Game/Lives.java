package Assignment.Game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Lives extends GameObject {
    //Private variable to keep track of the number of lives the player has
	private int count;

	/**
	 * 
	 * @param game
	 * @param x
	 * @param y
	 * @param count
	 * @param gc
	 * 
	 * Constructor for the lives class
	 */
    public Lives(Game game, double x, double y, int count, GraphicsContext gc) {
       //Calls the superclass GameObject.java and passes the dimensions 30x30 pixels
    	super(game, x, y, 30, 30, gc);  
        //Initialises the count variable with the provided value
    	this.count = count;
    	//Loads the image for the live from resources
        this.img = new Image(Lives.class.getResource("lives.png").toExternalForm());
    }

    /**
     * Method which overrides the update method from GameObject.java
     */
    @Override
    public void update() {
    	//Loop through each instance of the life object
        for (int i = 0; i < count; i++) {
        	//Calculate the offset for the life icons to be drawn with 30pixels space between each icon
            double offsetX = i * 30;  
            //Drawn the life icon at the specified position with the offset
            gc.drawImage(img, x + offsetX, y, width, height);
        }
    }

    /**
     * Method to decrement the players lives
     */
    public void decrement() {
    	//Only decrement the count variable if the count variable is greater than zero as the player cannot have negative lives
        if (count > 0) {
            count--;
        }
    }

    /**
     * 
     * @return
     * 
     * Getter method which returns the value of the count variable
     */
    public int getCount() {
        return count;
    }

    /**
     * 
     * @param count
     * 
     * Setter method which sets the count variable to the value provided in the parameter
     */
    public void setCount(int count) {
        this.count = count;
    }
}
