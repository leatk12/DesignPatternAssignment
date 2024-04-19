package Assignment.Game;

import javafx.scene.canvas.GraphicsContext;

public interface Bullet {
	void shoot();
	
static Builder builder()  {
	return new BulletBuilder();
}

interface Builder {
	Builder setPosition(double x, double y);
	Builder setGraphicsContext(GraphicsContext gc);
	Bullet build();
}


class BulletBuilder implements Builder {
private double x;
private double y;
private GraphicsContext gc;
	
	
	@Override
	public Builder setPosition(double x, double y) {
		// TODO Auto-generated method stub
		this.x = x;
		this.y = y;
		return this;
	}

	@Override
	public Builder setGraphicsContext(GraphicsContext gc) {
		// TODO Auto-generated method stub
		this.gc = gc;
		return this;
	}

	@Override
	public Bullet build() {
		// TODO Auto-generated method stub
		return new Pow0Bullet(x, y, 20, 20, gc );
	}
	
}

}
