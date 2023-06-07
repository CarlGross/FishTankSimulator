package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;

public class Tank extends ScreenAdapter{
	 fisher game;
	
	 String text;
	 int temp = 0;
	 public static Integer schoolstat = 0;
	 public static Integer churchstat = 0;
	 public static Integer judgements = 0;
     public static Integer evil = 0;
     public static Integer levels = 0;
	 public Tank(fisher game) {
		 this.game = game;
		

	 }
	 public void show() {
		 MyInputProcessor inputProcessor = new MyInputProcessor();
		 Gdx.input.setInputProcessor(inputProcessor);
		 if (game.music.isPlaying() == false) {
			 game.music.play();
		 }
		if(schoolstat == 50 && churchstat == 10 && judgements == 3) {
			System.exit(0);
		}
	
		 
		
		 
	 }
	
	 public void render(float delta) {
		 
		
		game.batch.begin();
		game.batch.draw(game.img, 0, 0);
		game.font.getData().setScale(1.8f);
		game.font.draw(game.batch, MyInputProcessor.f, 150, 300);
		game.font.draw(game.batch, "Where do you want to visit?", 170, 400);
		game.font.getData().setScale(1);
		   game.font.draw(game.batch, "Knowledge: "+schoolstat.toString()+"/100", 120, 450);
		   game.font.draw(game.batch, "Faith: "+churchstat.toString()+"/100", 300, 450);
		   game.font.draw(game.batch, "Judgements: "+judgements.toString()+"/3",450, 450);
		game.batch.end();
		if (MyInputProcessor.c && MyInputProcessor.f.equals("SCHOOL OF FISH") && schoolstat.intValue() < 100) {
			MyInputProcessor.resetf();
			if(levels == 0) {
			game.setScreen(new School(game));
			}
			/* else {
				game.setScreen(new School2(game));
			} */
		}
		if (MyInputProcessor.c && MyInputProcessor.f.equals("CEMETERY") && judgements.intValue() < 3) {
			MyInputProcessor.resetf();
			game.setScreen(new Cemetary(game));
		}
		if (MyInputProcessor.c && MyInputProcessor.f.equals("CHURCH") && churchstat.intValue() < 100) {
			MyInputProcessor.resetf();
			game.setScreen(new Church(game));
		}
		
	 }
	 public void hide() {
		game.music.stop();
		 Gdx.input.setInputProcessor(null);
	 }


 
}
