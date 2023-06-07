package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
public class fisher extends Game {
	SpriteBatch batch;
	BitmapFont font;
	Texture img;
	Texture fishsp;
	Texture booksp;
	Texture slimesp;
	Texture floor;
	Texture blocksp;
	Texture cas;
	Texture cemetery;
	Music music;
	Music casmusic;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
	    font = new BitmapFont();
	    music = Gdx.audio.newMusic(Gdx.files.internal("tankmusic.mp3"));
	    casmusic = Gdx.audio.newMusic(Gdx.files.internal("aintmisbehavin.mp3"));
	   setScreen(new TitleScreen(this));
	   cemetery = new Texture(Gdx.files.internal("cemeteru.png"));
       img = new Texture(Gdx.files.internal("tankpng.png"));
       fishsp = new Texture(Gdx.files.internal("fishsprite.png"));
       booksp = new Texture(Gdx.files.internal("booksprite.png"));
       slimesp = new Texture(Gdx.files.internal("slimesprite.png"));
       floor = new Texture(Gdx.files.internal("schoolfloor.png"));
       blocksp = new Texture(Gdx.files.internal("blocksprite.png"));
	cas = new Texture(Gdx.files.internal("fishsino.png"));
	}


	
	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
		music.dispose();
		casmusic.dispose();
		
	}
}
