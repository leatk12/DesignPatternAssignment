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

    protected GameObjectBehaviour behaviour;

    public GameObject(double x, double y, double width, double height, GraphicsContext gc) {
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
        double newX = x - Game.getTileSize(); // Move left by one tile size
        if (!isWall(newX, y)) {
            x = newX;
        }
    }

    public void moveRight() {
        double newX = x + Game.getTileSize(); // Move right by one tile size
        if (!isWall(newX, y)) {
            x = newX;
        }
    }

    public void moveUp() {
        double newY = y - Game.getTileSize(); // Move up by one tile size
        if (!isWall(x, newY)) {
            y = newY;
        }
    }

    public void moveDown() {
        double newY = y + Game.getTileSize(); // Move down by one tile size
        if (!isWall(x, newY)) {
            y = newY;
        }
    }

    protected boolean isWall(double newX, double newY) {
        // Calculate the boundaries of the canvas
        double canvasWidth = gc.getCanvas().getWidth();
        double canvasHeight = gc.getCanvas().getHeight();

        // Check if the new position is within the canvas boundaries
        if (newX < 0 || newX >= canvasWidth || newY < 0 || newY >= canvasHeight) {
            return true; // If out of bounds, consider it as a wall
        }

        // Check if the new position collides with any walls in the maze
        int gridX = (int) (newX / Game.getTileSize());
        int gridY = (int) (newY / Game.getTileSize());

        if (gridX < 0 || gridX >= Game.getNumTilesX() || gridY < 0 || gridY >= Game.getNumTilesY()) {
            return true; // If out of bounds, consider it as a wall
        }

        return Game.getMaze()[gridX][gridY] == 1;
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
}