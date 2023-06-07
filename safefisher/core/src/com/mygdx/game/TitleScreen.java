package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
public class TitleScreen extends ScreenAdapter {
 fisher game;
OrthographicCamera camera;
 String text;
 int temp = 0;
 

 public TitleScreen(fisher game) {
	 this.game = game;

	

 }
 public void show() {
	 MyInputProcessor inputProcessor = new MyInputProcessor();
	 Gdx.input.setInputProcessor(inputProcessor);
	 camera = new OrthographicCamera(640,480);
	 camera.translate(320, 240);
	 camera.update();
	 game.music.setLooping(true);
	 game.music.play();
	 game.batch.setProjectionMatrix(camera.combined);
	
	 
 }

 public void render(float delta) {
	 
	
	game.batch.begin();
	game.batch.draw(game.img, 0, 0);
	game.font.getData().setScale(2.6f);
	game.font.draw(game.batch, "Fishtank Simulator", 180, 400);
	game.font.getData().setScale(1.8f);
	game.font.draw(game.batch, MyInputProcessor.f, 290, 275);

	game.font.draw(game.batch, "Type Start to begin", 220, 360);
	game.batch.end();
	if (MyInputProcessor.c && MyInputProcessor.f.toUpperCase().equals("START")) {
		MyInputProcessor.resetf();
		game.setScreen(new Tank(game));
	}
	
 }
 public void hide() {
	
	 Gdx.input.setInputProcessor(null);
 }


}
