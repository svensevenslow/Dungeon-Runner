package com.kainaat.erzagame;

import android.graphics.Rect;

public class Enemy1 {

	
	private int power, centerX, speedX, centerY;
	private Background bg = GameScreen.getBg1();
	private Robot robot = GameScreen.getRobot();
	private boolean visible = true;
	public Rect r = new Rect(0, 0, 0, 0);
	public int collection = 0;

	private int movementSpeed;

	
	// Behavioral Methods
	public void update() {

		centerX += speedX;
		speedX = bg.getSpeedX() * 5 + movementSpeed;
		r.set(centerX - 25, centerY - 25, centerX + 25, centerY + 35);
		if (visible == true) {
			if (Rect.intersects(r, Robot.yellowRed)) {
				checkCollision();
			} 
		}else {
				checkTime();
			}

		GameScreen.getRobot().setScore(collection);
	}

	private void checkTime() {
		Thread timer = new Thread() {

			public void run() {
				try {
					sleep(200);
					/** time in milli sec */
					visible = true;
					GameScreen.c1.setCenterY(360);
					GameScreen.c1.setCenterX(GameScreen.getBg2().getBgX() - 1200);
					
				} catch (InterruptedException e) {
					e.printStackTrace();

				}

			}

		};
		timer.start();

	}

	private void checkCollision() {
		if (Rect.intersects(r, Robot.rect) || Rect.intersects(r, Robot.rect2)
				|| Rect.intersects(r, Robot.rect3)
				|| Rect.intersects(r, Robot.rect4)) {
			GameScreen.c1.setCenterY(-360);
			visible = false;
			collection = GameScreen.getRobot().getScore() + 1;
			
		}
	}

	public void die() {

	}

	public void attack() {

	}

	public int getPower() {
		return power;
	}

	public int getSpeedX() {
		return speedX;
	}

	public int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public Background getBg() {
		return bg;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public void setBg(Background bg) {
		this.bg = bg;
	}

}
