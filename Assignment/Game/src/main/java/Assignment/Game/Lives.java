package Assignment.Game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Lives extends GameObject {
    private int count;

    public Lives(Game game, double x, double y, int count, GraphicsContext gc) {
        super(game, x, y, 30, 30, gc);  //  Assuming each life icon is 20x20 pixels
        this.count = count;
        this.img = new Image(Lives.class.getResource("lives.png").toExternalForm());
    }

    @Override
    public void update() {
        for (int i = 0; i < count; i++) {
            double offsetX = i * 30;  // 30 pixels apart from each life image
            gc.drawImage(img, x + offsetX, y, width, height);
        }
    }

    public void decrement() {
        if (count > 0) {
            count--;
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
