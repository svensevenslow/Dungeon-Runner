package com.kainaat.erzagame;

import com.kainaat.framework.Game;
import com.kainaat.framework.Graphics;
import com.kainaat.framework.Screen;
import com.kainaat.framework.Graphics.ImageFormat;

public class LoadingScreen extends Screen {
	public LoadingScreen(Game game) {
		
		super(game);
	}

	@Override
	public void update(float deltaTime) {
		Graphics g = game.getGraphics();
		Assets.menu = g.newImage("menu.png", ImageFormat.RGB565);
		Assets.background = g.newImage("background.png", ImageFormat.RGB565);
		Assets.character = g.newImage("standing.png", ImageFormat.ARGB4444);
		Assets.character2 = g.newImage("standing.png", ImageFormat.ARGB4444);
		Assets.character3  = g.newImage("standing.png", ImageFormat.ARGB4444);
		Assets.characterJump = g.newImage("jumpp.png", ImageFormat.ARGB4444);
		Assets.characterDown = g.newImage("erzaStance.png", ImageFormat.ARGB4444);

		
		Assets.heliboy = g.newImage("heliboy.png", ImageFormat.ARGB4444);
		Assets.heliboy2 = g.newImage("heliboy2.png", ImageFormat.ARGB4444);
		Assets.heliboy3  = g.newImage("heliboy3.png", ImageFormat.ARGB4444);
		Assets.heliboy4  = g.newImage("heliboy4.png", ImageFormat.ARGB4444);
		Assets.heliboy5  = g.newImage("heliboy5.png", ImageFormat.ARGB4444);

		Assets.coin = g.newImage("coin.png", ImageFormat.RGB565);
		Assets.levelUp = g.newImage("levelUp.png", ImageFormat.ARGB4444);
		
		Assets.tiledirt = g.newImage("tiledirt.png", ImageFormat.RGB565);
		Assets.tilegrassTop = g.newImage("tilegrasstop.png", ImageFormat.RGB565);
		Assets.tilegrassBot = g.newImage("tilegrassbot.png", ImageFormat.RGB565);
		Assets.tilegrassLeft = g.newImage("tilegrassleft.png", ImageFormat.RGB565);
		Assets.tilegrassRight = g.newImage("tilegrassright.png", ImageFormat.RGB565);
		
		Assets.button = g.newImage("button.jpg", ImageFormat.RGB565);
		
		Assets.tileLevel2 = g.newImage("new_tile.png", ImageFormat.RGB565);
		Assets.heliboyLevel2 = g.newImage("heliboyLevel2.png", ImageFormat.ARGB4444);
		Assets.coinLevel2 = g.newImage("level2coin.png", ImageFormat.RGB565);

		//This is how you would load a sound if you had one.
		//Assets.click = game.getAudio().createSound("explode.ogg");

		
		game.setScreen(new MainMenuScreen(game));

	}

	@Override
	public void paint(float deltaTime) {
		Graphics g = game.getGraphics();
		g.drawImage(Assets.splash, 0, 0);
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}

	@Override
	public void backButton() {

	}
}