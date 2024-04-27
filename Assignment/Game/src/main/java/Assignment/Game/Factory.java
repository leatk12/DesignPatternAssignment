package Assignment.Game;

import javafx.scene.canvas.GraphicsContext;

public class Factory implements FactoryIF{
	
	//Variable to handle the rendering of game objects
	GraphicsContext gc;

	/**
	 * 
	 * @param gc
	 * 
	 * Constructor for the factory class which is initialised witha graphics context
	 */
	public Factory(GraphicsContext gc)  {
		//Call to the super class
		super();
		//Assign the graphics context to the class gc variable
		this.gc = gc;
	}
		

	/**
	 * 
	 * @param discrim
	 * @param game
	 * @param x
	 * @param y
	 * @param tileSize
	 * 
	 * @return
	 * 
	 * Concrete implementation of the createProduct method from the FactoryIF interface
	 */
	@Override
	public GameObject createProduct(String discrim, Game game, double x, double y, double tileSize) {
	    //Declare and initialise the product as null
		GameObject product = null;
		//Switch statement which determines the type of enemu instance to create based on the discriminant string
	    switch (discrim) {
	    //If the discriminant is "num1"
	        case "num1":
	        	//Create an instance of Num1
	            product = new Num1(game, x, y, tileSize, gc);
	            break;
	            //If discriminant is "num2"
	        case "num2":
	        	//Create an instance of Num2
	            product = new Num2(game, x, y, tileSize, gc);
	            break;
	            //If discriminant is "num4"
	        case "num4":
	        	//Create an instance of Num4
	            product = new Num4(game, x, y, tileSize, gc);
	            break;
	            //If discriminant is "num8"
	        case "num8":
	        	//Create and instance of Num8
	            product = new Num8(game, x, y, tileSize, gc);
	            break;
	    }
	    //After trying to create the product, check whether the prodict is still null
	    if (product == null) {
	    	//Print and error message if no product was created
	        System.out.println("Failed to create product for type: " + discrim);
	    } else {
	    	//Print a success message if the product was created
	        System.out.println("Successfully created product: " + discrim);
	    }
	    //Return the created product
	    return product;
	}


	

	
	
}