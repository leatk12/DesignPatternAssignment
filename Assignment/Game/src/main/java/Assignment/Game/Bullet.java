package Assignment.Game;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.NoSuchMethodException;
import java.lang.IllegalAccessException;
import java.lang.InstantiationException;

import javafx.scene.canvas.GraphicsContext;

//Defining the class as an interface
public interface Bullet {
   //Method that defines shooting behaviour
	void shoot();
	void setDirection(String direction);

	
	
    /**
     * 
     * @return
     * 
     * A static method which creates a builder instance
     */
	static Builder builder() {
        return new BulletBuilder();
    }

    /**
     * A nested interface which defines the Builder design pattern for bullet objects
     */
    interface Builder {
    	//A method which defines the position of a bullet
        Builder setPosition(double x, double y);
        //A method which sets the graphics context for drawing the bullet
        Builder setGraphicsContext(GraphicsContext gc);
        //A method which specifies the class type of the bullet
        Builder setBulletType(Class<? extends Bullet> bulletType);  // Method to specify the bullet type
       //A method which finalises the constgruction of the bullet and returns the constgructed bullet
        Bullet build();
    }

    //The implementation of the Builder interface
    class BulletBuilder implements Builder {
        //Variable which holds the x coordinate of the bullet
    	private double x;
    	//Variable which holds the y coordinate of the bullet
        private double y;
        //Graphics context for rendering the bullet
        private GraphicsContext gc;
        //Class type for creating specific bullet instances
        private Class<? extends Bullet> bulletType;  // Store the bullet type

        /**
         * 
         * @param x
         * @param y
         * @return
         * Method which sets the position of the bullet
         */
        @Override
        public Builder setPosition(double x, double y) {
            this.x = x;
            this.y = y;
            //Return the current builder instance
            return this;
        }

        
        /**
         * @param gc
         * @return
         * 
         * Method which sets the graphics context
         */
        @Override
         public Builder setGraphicsContext(GraphicsContext gc) {
            this.gc = gc;
            //return the current builder instance
            return this;
        }

        
        /**
         * @param bulletType
         * @return
         * 
         * Method used to set the bullets type
         */
        @Override
        public Builder setBulletType(Class<? extends Bullet> bulletType) {
            this.bulletType = bulletType;  // Set the bullet type dynamically
           //Return the current builder instance
            return this;
        }

        /**
         * @return
         * 
         * Method used to construct the bullet using reflection
         */
        @Override
        public Bullet build() {
            if (bulletType != null) {
                try {
                	//Attemot to get a constructor from the bullet class and build an instance of that bullet
                    Constructor<? extends Bullet> constructor = bulletType.getConstructor(double.class, double.class, double.class, double.class, GraphicsContext.class);
                   // Create a new instance with the specified parameters
                    return constructor.newInstance(x, y, 20, 20, gc);
                } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                	//Catch and log any exceptions related to reflection and object creation
                    System.err.println("Error creating bullet: " + e);
                    return null;
                }
            } else {
            	//Display an error message if no bullet type was specified
                System.err.println("Bullet type not set.");
                return null;
            }
        }
}

    /**
     * Abstract method to define how the bullet is rendered
     */
	void render();

	/**
	 * 
	 * @return
	 * 
	 * Abstract method for returning the x coordinates
	 */
	double getX();

	/**
	 * 
	 * @return
	 * 
	 * Abstract method for returning the y coordinates
	 */
	double getY();

	/**
	 * 
	 * @return
	 * 
	 * Abstract method for returning he width of the bullet
	 */
	double getWidth();

	/**
	 * Abstract method for returning the height of the bullet
	 * @return
	 */
	double getHeight();
}
