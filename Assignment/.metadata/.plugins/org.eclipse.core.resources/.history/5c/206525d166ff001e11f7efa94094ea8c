package Assignment.Game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Pow1Bullet extends GameObject implements Bullet {
	
	private String direction;
	
	
	public Pow1Bullet( double x, double y, double width, double height, GraphicsContext gc) {
        super(null, x, y, width, height, gc);
        this.img = new Image(Pow1Bullet.class.getResource("Pow1Bullet.png").toExternalForm());

}
	
	public void setDirection(String direction)  {
		this.direction = direction;
	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		switch (direction)  {
		case "LEFT":
			x -= speedX;
			break;
		case "RIGHT":
			x += speedX;
			break;
		case "UP":
			y -= speedY;
			break;
		case "DOWN":
			y += speedY;
			break;
			
		}
	}
	
	public void render()  {
		if (img != null) {
			System.out.println("Rendering bullet at " + x + ", " + y);
			gc.drawImage(img,  x - width / 2,  y - height / 2, width, height);
	} else {
		System.out.println("Bullet image not loaded");
	}
}

	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}

	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}
	
}
