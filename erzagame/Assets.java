package com.kainaat.erzagame;

import com.kainaat.framework.Image;
import com.kainaat.framework.Music;
import com.kainaat.framework.Sound;

public class Assets {
	
	public static Image menu, splash, background, character, character2, character3, heliboy, heliboy2, heliboy3, heliboy4, heliboy5;
	public static Image tiledirt, tilegrassTop, tilegrassBot, tilegrassLeft, tilegrassRight, characterJump, characterDown;
	public static Image coin,levelUp;
	public static Image coinLevel2,tileLevel2,heliboyLevel2;
	public static Image button;
	public static Sound click;
	public static Music theme;
	
	public static void load(SampleGame sampleGame) {
		// TODO Auto-generated method stub
		theme = sampleGame.getAudio().createMusic("menutheme.mp3");
		theme.setLooping(true);
		theme.setVolume(0.85f);
		theme.play();
	}
	
}
