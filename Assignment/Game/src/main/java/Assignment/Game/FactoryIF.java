package Assignment.Game;

public interface FactoryIF {
    
	/**
	 * 
	 * @param discrim
	 * @param game
	 * @param x
	 * @param y
	 * @param tileSize
	 * @return
	 * 
	 * Abstract method
	 * Concrete implementation is in the Factory.java class
	 */
    GameObject createProduct(String discrim, Game game, double x, double y, double tileSize);

}  
