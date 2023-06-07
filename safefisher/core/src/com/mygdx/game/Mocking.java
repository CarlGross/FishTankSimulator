package com.mygdx.game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

public class Mocking extends ScreenAdapter{
fisher game;
public Mocking(fisher game) {
	this.game = game;
}
public void show() {
MyInputProcessor inputprocessor = new MyInputProcessor();
Gdx.input.setInputProcessor(inputprocessor);
}
public void render(float delta) {
	Gdx.gl.glClearColor(0, 0, 0, 0);
	Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
	game.batch.begin();
	game.font.draw(game.batch, "Took you long enough!\nType \"I am ashamed\" to proceed", 100, 400);
	game.font.draw(game.batch, MyInputProcessor.f, 100, 200);
	game.batch.end();
	if(MyInputProcessor.f.equals("I AM ASHAMED") && MyInputProcessor.c) {
		game.setScreen(new Tank(game));
	}
}

public void hide() {
	MyInputProcessor.f = "";
	Gdx.input.setInputProcessor(null);
}
}
