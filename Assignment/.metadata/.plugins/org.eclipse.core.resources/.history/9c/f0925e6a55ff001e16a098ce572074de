package Assignment.Game;

import javafx.scene.canvas.GraphicsContext;

public class Factory implements FactoryIF{
	
	GraphicsContext gc;

		

	@Override
	public GameObject createProduct(String discrim, double x, double y, double tileSize) {
		// TODO Auto-generated method stub
		if(discrim.equals("num1"))
			return new Num1(x, y, tileSize, gc);
		else if(discrim.equals("num2"))
			return null;
		else if(discrim.equals("num4"))
			return null;
		else if(discrim.equals("num8"))
			return null;
		return null;
	}

	

	
	public Factory(GraphicsContext gc)  {
		super();
		this.gc = gc;
	}
}