package Assignment.Game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Player extends GameObject{
	
	
	
	private static Player instance;

	private Player(double x, double y, double width, double height, GraphicsContext gc) {
		super(x, y, width, height,  gc);
		this.name = "default";
		this.score = 0;
		// TODO Auto-generated constructor stub
		this.img = new Image(Player.class.getResource("iceT.png").toExternalForm());
		update();
	}
	
	public static synchronized Player getInstance(double x, double y, double width, double height, GraphicsContext gc)  {
		if (instance == null)  {
			instance = new Player(x, y, 40, 40, gc);
		}
		return instance;
	}
	
	private String name;
	private int score;
	
	//Getters and setters
	public String getName()  {
		return name;
	}
	
	public void setName(String name)  {
		this.name = name;
	}
	
	public int getScore()  {
		return score;
		
	}
	
	public void setScore(int score)  {
		this.score = score;
	}
	
	//Method to increment score
	public void incrementScore()  {
		score++;
	}
	
	//Method to reset the score
	public void resetScore()  {
		score = 0;
	}
	
	//Getters for player movement
		public double getX()  {
			return x;
		}
		
		public double getY()  {
			return y;
		}
		
		public double getSpeedX()  {
			return speedX;
		}
		
		public double getSpeedY()  {
			return speedY;
		}
	
	
	
	public void update() {
		double playerWidth = 30;
		double playerHeight = 40;
		
		if (img != null)
			gc.drawImage(img, x- width / 2, y - height /2, width, height);
	}
	


}
