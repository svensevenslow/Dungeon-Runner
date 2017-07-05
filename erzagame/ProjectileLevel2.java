package com.kainaat.erzagame;

import android.graphics.Rect;

public class ProjectileLevel2 {

	private static Background bg1, bg2;
	private int x, y, speedX;
	private boolean visible;
	public int bonus = 0;
	

	private Rect r;

	public ProjectileLevel2(int startX, int startY) {
		x = startX;
		y = startY;
		speedX = 7;
		visible = true;
		
		bg1 = new Background(0, 0);
		bg2 = new Background(2160, 0);
		r = new Rect(0, 0, 0, 0);
	}

	public void update() {
		
		x += speedX;
		r.set(x, y, x + 10, y + 5);
		if (x > 800) {
			visible = false;
			r = null;
		}
		if (visible) {
			checkCollision();
		}
		if (!visible) {
			checkTime();
		}
		GameScreen2.getRobot().setBonus(bonus);
	}

	private void checkTime() {

		Thread timer = new Thread() {

			public void run() {
				try {
					sleep(3000);
					/** time in milli sec */
					visible = true;
					GameScreen2.hb.setCenterY(360);
					GameScreen2.hb2.setCenterY(360);
					GameScreen2.hb.setCenterX(bg2.getBgX() - 300);
					GameScreen2.hb2.setCenterX(bg2.getBgX() - 600);

				} catch (InterruptedException e) {
					e.printStackTrace();

				}

			}

		};
		timer.start();

	}

	private void checkCollision() {

		if (Rect.intersects(r, GameScreen2.hb.r)) {
			visible = false;

			if (GameScreen2.hb.health > 0) {
				GameScreen2.hb.health -= 1;

			}
			if (GameScreen2.hb.health == 0) {
				GameScreen2.hb.setCenterX(-360);
				bonus = GameScreen2.getRobot().getBonus() + 5;
				GameScreen2.hb.health = 5;

			}

		}
		if (Rect.intersects(r, GameScreen2.hb2.r)) {
			visible = false;

			if (GameScreen2.hb2.health > 0) {
				GameScreen2.hb2.health -= 1;
			}
			if (GameScreen2.hb2.health == 0) {
				GameScreen2.hb2.setCenterY(-360);
				bonus = GameScreen2.getRobot().getBonus() + 5;
				GameScreen2.hb2.health = 5;

			}

		}
		if ((GameScreen2.hb2.getCenterX() < GameScreen2.getRobot().getCenterX())
				&& GameScreen2.hb.getCenterX() < GameScreen2.getRobot().getCenterX()) {
			visible = false;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSpeedX() {
		return speedX;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

}
