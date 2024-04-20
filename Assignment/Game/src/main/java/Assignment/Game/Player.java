package Assignment.Game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Player extends GameObject implements GameObjectBehaviour{
private String lastDirection = "RIGHT";
	
	
    private static Player instance;

    private Player(Game game, double x, double y, double width, double height, GraphicsContext gc) {
        super(game, x, y, width, height,  gc);
        this.name = "default";
        this.score = 0;
        // TODO Auto-generated constructor stub
        this.img = new Image(Player.class.getResource("iceT.png").toExternalForm());
        update();
    }

    public static synchronized Player getInstance(Game game, GraphicsContext gc)  {
        if (instance == null)  {
            double x, y;
            int tileX, tileY;
            do {
                // Generate random coordinates
                x = Math.random() * Game.getNumTilesX() * Game.getTileSize();
                y = Math.random() * Game.getNumTilesY() * Game.getTileSize();
                // Convert coordinates to tile indices
                tileX = (int) (x / Game.getTileSize());
                tileY = (int) (y / Game.getTileSize());
            } while (!game.isValidSpawnPosition(x, y));

            // Set the position within the center of the path tile
            x = tileX * Game.getTileSize() + Game.getTileSize() / 2;
            y = tileY * Game.getTileSize() + Game.getTileSize() / 2;

            // Create the player instance
            instance = new Player(game, x, y, 40, 40, gc);
        }
        return instance;
    }

    
    
    

    private String name;
    private int score;

    //Getters and setters
    public String getLastDirection()  {
		return lastDirection;
	}
    
    
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
    
    
    
    @Override
    public void moveLeft()  {
    	super.moveLeft();
    	lastDirection ="LEFT";
    }
    
    @Override
    public void moveRight()  {
    	super.moveRight();
    	lastDirection = "RIGHT";
    }
    
    @Override
    public void moveUp()  {
    	super.moveUp();
    lastDirection = "UP";
    }
    
    @Override
    public void moveDown()  {
    	super.moveDown();
    	lastDirection = "DOWN";
    }
    
    

    public void update() {
        double playerWidth = 30;
        double playerHeight = 40;

        if (img != null)
            gc.drawImage(img, x- width / 2, y - height /2, width, height);
    }

	@Override
	public void updateBehaviour() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enemyMovement() {
		// TODO Auto-generated method stub
		
	}
	
	
}
