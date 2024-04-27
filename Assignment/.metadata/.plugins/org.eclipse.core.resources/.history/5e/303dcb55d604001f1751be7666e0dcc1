package Assignment.Game;

import javafx.scene.canvas.GraphicsContext;

public class Factory implements FactoryIF{
	
	GraphicsContext gc;

		

	@Override
	public GameObject createProduct(String discrim, Game game, double x, double y, double tileSize) {
	    GameObject product = null;
	    switch (discrim) {
	        case "num1":
	            product = new Num1(game, x, y, tileSize, gc);
	            break;
	        case "num2":
	            product = new Num2(game, x, y, tileSize, gc);
	            break;
	        case "num4":
	            product = new Num4(game, x, y, tileSize, gc);
	            break;
	        case "num8":
	            product = new Num8(game, x, y, tileSize, gc);
	            break;
	    }
	    if (product == null) {
	        System.out.println("Failed to create product for type: " + discrim);
	    } else {
	        System.out.println("Successfully created product: " + discrim);
	    }
	    return product;
	}


	

	
	public Factory(GraphicsContext gc)  {
		super();
		this.gc = gc;
	}
}