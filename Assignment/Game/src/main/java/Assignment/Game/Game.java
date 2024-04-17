package Assignment.Game;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.Random;

public class Game extends Application {

    private static final int TILE_SIZE = 40;
    private static final int NUM_TILES_X = 20;
    private static final int NUM_TILES_Y = 15;
    private static final int NUM_NUM1_INSTANCES = 10;

<<<<<<< HEAD
    // Array holding the tiles
    // 0 is a path and 1 is a wall
    private static int[][] maze = new int[NUM_TILES_X][NUM_TILES_Y];

    //Root pane for the scene
    Pane root;
    //Scene for the game
    Scene scene;
    //Canvas for holding the game elements
    Canvas canvas;
    //Graphics context for drawing operations
    GraphicsContext gc;

    //The timer for the game loop
    AnimationTimer timer;
    //The factory for creating game objects
    Factory factory;
    //An ArrayList which holds Num1 instances
    ArrayList<Num1> num1List = new ArrayList<>();

    //The player object for the game
    Player player;

    
    //The main method which is used to start the application
=======
    private static int[][] maze = new int[NUM_TILES_X][NUM_TILES_Y];

    Pane root;
    Scene scene;
    Canvas canvas;
    GraphicsContext gc;

    AnimationTimer timer;
    Factory factory;
    ArrayList<Num1> num1List = new ArrayList<>();
    Player player;

>>>>>>> 0c4ace9accba5a3353c67874a9b44106006bee18
    public static void main(String[] args) {
        launch(args);
    }

<<<<<<< HEAD
    
    //The start method for the application
    @Override
    public void start(Stage primaryStage) throws Exception {
    	//Creating instances of the root pane, scene, canvas and graphics context
=======
    @Override
    public void start(Stage primaryStage) throws Exception {
>>>>>>> 0c4ace9accba5a3353c67874a9b44106006bee18
        root = new Pane();
        scene = new Scene(root, 800, 600);
        canvas = new Canvas(800, 600);
        gc = canvas.getGraphicsContext2D();
        primaryStage.setScene(scene);
        primaryStage.show();

<<<<<<< HEAD
        //Call to the generateMap() method to create the game map
        generateMap();

        //Initialising the object which will represent the player
        player = Player.getInstance(canvas.getWidth() / 2, canvas.getHeight() - 100, 30, 40, gc);
        
        //Adding the canvas to the root pane
        root.getChildren().add(canvas);
        
        //Fill the canvas with a black background
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        //Create an instance of the factory class used to create game objects
        factory = new Factory(gc);
        
        //Spawn instances on the Num1 class
        for (int i = 0; i < NUM_NUM1_INSTANCES; i++) {
            double posX, posY;
            do {
                // Generate random tile indices
                int randomX = (int) (Math.random() * NUM_TILES_X);
                int randomY = (int) (Math.random() * NUM_TILES_Y);
                // Calculate the position in the centre of the tile
                posX = randomX * TILE_SIZE + TILE_SIZE / 2;
                posY = randomY * TILE_SIZE + TILE_SIZE / 2;
            } while (!isValidSpawnPosition(posX, posY));

            // Spawn Num1 instance at the centre of the tile
            Num1 num1 = (Num1) factory.createProduct("num1", posX, posY, TILE_SIZE);
            num1List.add(num1);
        }
        	

        //Initialise and start the game loop timer
=======
        generateMap();

        player = Player.getInstance(canvas.getWidth() / 2, canvas.getHeight() - 100, 30, 40, gc);

        root.getChildren().add(canvas);

        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        factory = new Factory(gc);

        for (int i = 0; i < NUM_NUM1_INSTANCES; i++) {
            double posX, posY;
            int randomX, randomY; // Declaring variables outside the do-while loop

            do {
                randomX = (int) (Math.random() * NUM_TILES_X);
                randomY = (int) (Math.random() * NUM_TILES_Y);
                posX = randomX * TILE_SIZE + TILE_SIZE / 2;
                posY = randomY * TILE_SIZE + TILE_SIZE / 2;
            } while (!isValidSpawnPosition(posX, posY) || !isValidSpawnTile(randomX, randomY));

            Num1 num1 = (Num1) factory.createProduct("num1", posX, posY, TILE_SIZE);
            num1List.add(num1);
        }

>>>>>>> 0c4ace9accba5a3353c67874a9b44106006bee18
        timer = new AnimationTimer() {
            long lastSpawnTime = 0;

            @Override
            public void handle(long now) {
<<<<<<< HEAD
            	//Clear the canvas
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                
                //Update the Num1 instances
                for (int i = 0; i< num1List.size(); i++)  {
                	Num1 num1 = num1List.get(i);
                	num1.update();
                }
                         
                //Update the player instance
=======
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

                for (int i = 0; i < num1List.size(); i++) {
                    Num1 num1 = num1List.get(i);
                    num1.update();
                }

>>>>>>> 0c4ace9accba5a3353c67874a9b44106006bee18
                player.update();
            }
        };
        timer.start();

<<<<<<< HEAD

        //DEvent handler responsible for key presses
=======
>>>>>>> 0c4ace9accba5a3353c67874a9b44106006bee18
        scene.setOnKeyPressed((KeyEvent e) -> {
            switch (e.getCode()) {
                case LEFT:
                    player.moveLeft();
                    break;
                case RIGHT:
                    player.moveRight();
                    break;
                case UP:
                    player.moveUp();
                    break;
                case DOWN:
                    player.moveDown();
                    break;
                default:
                    break;

            }
        });
<<<<<<< HEAD
        }
    

    //A method which generates the game map
    private void generateMap() {
        // Initialise the maze grid with all walls
        for (int i = 0; i < NUM_TILES_X; i++) {
            for (int j = 0; j < NUM_TILES_Y; j++) {
            	// 1 indicates a wall
                maze[i][j] = 1;  
            }
        }

        // Random starting point for the maze generation
        Random rand = new Random();
        int startX = rand.nextInt(NUM_TILES_X);
        int startY = rand.nextInt(NUM_TILES_Y);
     // 0 indicates a path
        maze[startX][startY] = 0;  

        // Direction vectors for moving inside the grid (up, down, left, right)
        int[] dX = {-1, 1, 0, 0};
        int[] dY = {0, 0, -1, 1};

        // ArrayList to store the walls which are potential paths
        ArrayList<int[]> walls = new ArrayList<>();
        addWalls(startX, startY, walls, dX, dY);

        
        //Generate the maze using the depth-first search algorithm
=======
    }

    private void generateMap() {
        for (int i = 0; i < NUM_TILES_X; i++) {
            for (int j = 0; j < NUM_TILES_Y; j++) {
                maze[i][j] = 1;
            }
        }

        Random rand = new Random();
        int startX = rand.nextInt(NUM_TILES_X);
        int startY = rand.nextInt(NUM_TILES_Y);
        maze[startX][startY] = 0;

        int[] dX = {-1, 1, 0, 0};
        int[] dY = {0, 0, -1, 1};

        ArrayList<int[]> walls = new ArrayList<>();
        addWalls(startX, startY, walls, dX, dY);

>>>>>>> 0c4ace9accba5a3353c67874a9b44106006bee18
        while (!walls.isEmpty()) {
            int[] wall = walls.remove(rand.nextInt(walls.size()));
            int x = wall[0];
            int y = wall[1];

<<<<<<< HEAD
            // Test whether we can create a path by removing this wall
            int cellsWithPaths = 0;
         // To store the cell that has a path already
            int[] cell = {-1, -1}; 
            for (int k = 0; k < 4; k++) {
                int nx = x + dX[k];
                int ny = y + dY[k];
                // Ensure the cell is within bounds and check if it's already a path
=======
            int cellsWithPaths = 0;
            int[] cell = {-1, -1};
            for (int k = 0; k < 4; k++) {
                int nx = x + dX[k];
                int ny = y + dY[k];
>>>>>>> 0c4ace9accba5a3353c67874a9b44106006bee18
                if (nx >= 0 && nx < NUM_TILES_X && ny >= 0 && ny < NUM_TILES_Y && maze[nx][ny] == 0) {
                    cellsWithPaths++;
                    if (cellsWithPaths == 1) {
                        cell[0] = nx;
                        cell[1] = ny;
                    } else {
                        break;
                    }
                }
            }

<<<<<<< HEAD
         // Only one adjacent cell is a path
            if (cellsWithPaths == 1) {  
            	// Convert the wall to a path
                maze[x][y] = 0;  
=======
            if (cellsWithPaths == 1) {
                maze[x][y] = 0;
>>>>>>> 0c4ace9accba5a3353c67874a9b44106006bee18
                addWalls(x, y, walls, dX, dY);
            }
        }

<<<<<<< HEAD
        // Draw the generated maze
=======
>>>>>>> 0c4ace9accba5a3353c67874a9b44106006bee18
        for (int ix = 0; ix < NUM_TILES_X; ix++) {
            for (int jy = 0; jy < NUM_TILES_Y; jy++) {
                Rectangle tile = new Rectangle(ix * TILE_SIZE, jy * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                tile.setFill(maze[ix][jy] == 1 ? Color.DARKSLATEBLUE : Color.BLACK);
                root.getChildren().add(tile);
            }
        }
    }

<<<<<<< HEAD
    
    //A method which adds walls to the wall list
=======
>>>>>>> 0c4ace9accba5a3353c67874a9b44106006bee18
    private void addWalls(int x, int y, ArrayList<int[]> walls, int[] dX, int[] dY) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dX[i];
            int ny = y + dY[i];
            if (nx >= 0 && nx < NUM_TILES_X && ny >= 0 && ny < NUM_TILES_Y && maze[nx][ny] == 1) {
                walls.add(new int[]{nx, ny});
            }
        }
    }
<<<<<<< HEAD
    
    //Getter methods
=======
>>>>>>> 0c4ace9accba5a3353c67874a9b44106006bee18

    public static int getTileSize() {
        return TILE_SIZE;
    }

    public static int getNumTilesX() {
        return NUM_TILES_X;
    }

    public static int getNumTilesY() {
        return NUM_TILES_Y;
    }

    public static int[][] getMaze() {
        return maze;
    }
<<<<<<< HEAD
    
    
    //A method which checks whether a spawn point is valid
=======

>>>>>>> 0c4ace9accba5a3353c67874a9b44106006bee18
    private boolean isValidSpawnPosition(double posX, double posY) {
        int gridX = (int) (posX / TILE_SIZE);
        int gridY = (int) (posY / TILE_SIZE);

<<<<<<< HEAD
        // Check if the calculated indices are within bounds
        if (gridX < 0 || gridX >= NUM_TILES_X || gridY < 0 || gridY >= NUM_TILES_Y) {
            // Return false if out of bounds
            return false;
        }

        // Check if the tile is a wall or if it's already occupied by another Num1
=======
        if (gridX < 0 || gridX >= NUM_TILES_X || gridY < 0 || gridY >= NUM_TILES_Y) {
            return false;
        }

>>>>>>> 0c4ace9accba5a3353c67874a9b44106006bee18
        if (maze[gridX][gridY] == 1 || isOccupied(posX, posY)) {
            return false;
        }

        return true;
    }

<<<<<<< HEAD
    //A method which checks whether a position has already been occupied by a Num1 object
=======
    private boolean isValidSpawnTile(int x, int y) {
        int wallCount = 0;
        for (int i = x - 2; i <= x + 2; i++) {
            for (int j = y - 2; j <= y + 2; j++) {
                if (i >= 0 && i < NUM_TILES_X && j >= 0 && j < NUM_TILES_Y && maze[i][j] == 1) {
                    wallCount++;
                    if (wallCount >= 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

>>>>>>> 0c4ace9accba5a3353c67874a9b44106006bee18
    private boolean isOccupied(double posX, double posY) {
        for (Num1 num1 : num1List) {
            double distance = Math.sqrt(Math.pow((num1.getX() - posX), 2) + Math.pow((num1.getY() - posY), 2));
            if (distance < 3 * TILE_SIZE) {
                return true;
            }
        }
        return false;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 0c4ace9accba5a3353c67874a9b44106006bee18
