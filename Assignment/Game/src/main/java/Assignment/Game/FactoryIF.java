package Assignment.Game;

public interface FactoryIF {
	
	GameObject createProduct(String discrim, double x, double y, double tileSize);

}