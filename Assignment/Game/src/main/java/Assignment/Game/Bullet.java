package Assignment.Game;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.NoSuchMethodException;
import java.lang.IllegalAccessException;
import java.lang.InstantiationException;

import javafx.scene.canvas.GraphicsContext;

public interface Bullet {
    void shoot();

    static Builder builder() {
        return new BulletBuilder();
    }

    interface Builder {
        Builder setPosition(double x, double y);
        Builder setGraphicsContext(GraphicsContext gc);
        Builder setBulletType(Class<? extends Bullet> bulletType);  // Method to specify the bullet type
        Bullet build();
    }

    class BulletBuilder implements Builder {
        private double x;
        private double y;
        private GraphicsContext gc;
        private Class<? extends Bullet> bulletType;  // Store the bullet type

        @Override
        public Builder setPosition(double x, double y) {
            this.x = x;
            this.y = y;
            return this;
        }

        @Override
        public Builder setGraphicsContext(GraphicsContext gc) {
            this.gc = gc;
            return this;
        }

        @Override
        public Builder setBulletType(Class<? extends Bullet> bulletType) {
            this.bulletType = bulletType;  // Set the bullet type dynamically
            return this;
        }

        @Override
        public Bullet build() {
            if (bulletType != null) {
                try {
                    Constructor<? extends Bullet> constructor = bulletType.getConstructor(double.class, double.class, double.class, double.class, GraphicsContext.class);
                    return constructor.newInstance(x, y, 20, 20, gc);
                } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    System.err.println("Error creating bullet: " + e);
                    return null;
                }
            } else {
                System.err.println("Bullet type not set.");
                return null;
            }
        }
}

	void render();

	double getX();

	double getY();

	double getWidth();

	double getHeight();
}
