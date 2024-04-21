 package Assignment.Game;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameObject {
    protected Image img;
    protected double x, y;
    protected GraphicsContext gc;
    protected double width;
    protected double height;

    protected double speedX = 8;
    protected double speedY = 8;
    
    protected Game game;

    protected GameObjectBehaviour behaviour;

    public GameObject(Game game, double x, double y, double width, double height, GraphicsContext gc) {
       this.game = game;
    	this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.gc = gc;
        behaviour = new DefaultGameObjectBehaviour(); // Initialise with default behaviour
    }

    public void update() {
        if (img != null)
            gc.drawImage(img, x - width / 2, y - height / 2, width, height);
        behaviour.updateBehaviour(); // Delegate behaviour
    }

    public void moveLeft() {
        double newX = x - Game.getTileSize();
        if (!game.isWall(newX, y)) {
            x = newX;
        }
    }

    public void moveRight() {
        double newX = x + Game.getTileSize();
        if (!game.isWall(newX, y)) {
            x = newX;
        }
    }

    public void moveUp() {
        double newY = y - Game.getTileSize();
        if (!game.isWall(x, newY)) {
            y = newY;
        }
    }

    public void moveDown() {
        double newY = y + Game.getTileSize();
        if (!game.isWall(x, newY)) {
            y = newY;
        }
    }


   

    private static class DefaultGameObjectBehaviour implements GameObjectBehaviour {
        @Override
        public void updateBehaviour() {
            // Default behaviour is to do nothing
        }

		@Override
		public void enemyMovement() {
			// TODO Auto-generated method stub
			
		}
    }

	  void setDirection(String lastDirection) {
		// TODO Auto-generated method stub
		
	}

	public void render() {
		// TODO Auto-generated method stub
		
	}

	public double getX() {
		
		return x;
	}

	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}

	public double getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	public double getWidth() {
		// TODO Auto-generated method stub
		return width;
	}
}