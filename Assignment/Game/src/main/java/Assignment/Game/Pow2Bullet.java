package Assignment.Game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Pow2Bullet extends GameObject implements Bullet {
	
	//Private string used to store the direction the bullet is moving
	private String direction;
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param gc
	 * 
	 * Constructor for Pow2Bullet class
	 */
	public Pow2Bullet(double x, double y, double width, double height, GraphicsContext gc) {
		//Call the superclass, GameObject, constructor.  Pass the Game game parameter as null as it is not needed
		super(null, x, y, width, height, gc);
		// Initialise the bullet image from resources
        this.img = new Image(Pow2Bullet.class.getResource("Pow2Bullet.png").toExternalForm());
}

	/**
	 * Setter method to set the direction of the bullet
	 */
	@Override
	public void setDirection(String direction)  {
		this.direction = direction;
	}

	
	
	/**
	 * Concrete implementation of the shoot method from the Bullet interface
	 */
	@Override
	public void shoot() {
		//Define the bullets behaviour based on the value in the direction variable
		//Switch statement based on the current direction
		switch (direction)  {
		//If the direction is LEFT
		case "LEFT":
			//Move the bullet to the right by reducing the x variable by the value of the speedX variable
			x -= speedX;
			break;
			//If the direction is RIGHT
		case "RIGHT":
			//Move the bullet to the right by increasing the x variable by the value of the speedX variable
			x += speedX;
			break;
			//If the direction is UP
		case "UP":
			//Move the bullet to the right by decreasing the y variable by the value of the speedY variable
			y -= speedY;
			break;
			//If the direction is DOWN
		case "DOWN":
			//Move the bullet to the right by increasing the y variable by the value of the speedY variable
			y += speedY;
			break;
			
		}
	}
	
	
	/**
	 * Method to render the bullet on the canvas
	 */
	public void render()  {
		//Check whether the bullet image has loaded
		if (img != null) {
			//Output the position the bullet was rendered at for debugging purposes
			System.out.println("Rendering bullet at " + x + ", " + y);
			//Draw the bullet image centres at (x,y)
			gc.drawImage(img,  x - width / 2,  y - height / 2, width, height);
	} else {
		//Log to the console if the image is not loaded
		System.out.println("Bullet image not loaded");
	}
}

	
	/**
	 * @return
	 * 
	 * Getter method to return the value of y
	 */
	public double getY() {
		
		return y;
	}

	
	/**
	 * @return
	 * 
	 * Getter method to return the value of x
	 */
	public double getX() {
		
		return x;
	}

	/**
	 * @return
	 * 
	 * Getter method which returns the value of width
	 */
	@Override
	public double getWidth() {
		
		return width;
	}

	
	/**
	 * @return
	 * 
	 * Getter method which returns that value of height
	 */
	@Override
	public double getHeight() {
		
		return height;
	}

	
}
