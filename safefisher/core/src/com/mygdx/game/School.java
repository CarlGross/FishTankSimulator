package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class School extends ScreenAdapter{
      fisher game;
     float c = 10;
   static  int tries = 0;
 
     public static int booksize = 15;
      int blocksize = 30;
      
      Collisions kidrect;
      public static ArrayList<Collisions> slimecoll = new ArrayList<>();
     public static ArrayList<Collisions> blockcoll = new ArrayList<>();
   public static float x = 10,y = 10;
      School(fisher game){
    	  this.game = game;
    	  kidrect = new Collisions(100, 400, booksize, booksize);
    		for(int i = 0; i < 14; i++) {
    	    	blockcoll.add(new Collisions(i*40.6f, 310, blocksize, blocksize));
    	    	}
    		for(int i = 1; i < 15; i++) {
    			blockcoll.add(new Collisions(i*40.6f, 100, blocksize, blocksize));
    		}
    		for(int i = 130; i < 300; i+=30) {
        		slimecoll.add(new Collisions(100, i, blocksize, blocksize));
        	}
      }
      
      
      public void show() {
    	SchoolInputs inputprocessor = new SchoolInputs();
    	Gdx.input.setInputProcessor(inputprocessor);
    	x = 10; 
    	y = 10;
    	
    	
    
    	
      }
      public void render(float delta) {
    	game.batch.begin();
    	
    	game.batch.draw(game.floor, 0, 0);
    	for(int i = 0; i<14; i++) {
    		game.batch.draw(game.blocksp, i*40.6f, 310);
    	}
    	for(int i = 1; i <15;i++) {
    		game.batch.draw(game.blocksp, i*40.6f, 100);
    	}
    	for(int i = 130; i < 300; i+=30) {
    		game.batch.draw(game.slimesp, 100, i);
    	}
    	game.batch.draw(game.booksp, x, y);
    	game.batch.draw(game.fishsp, 100, 400);
    	
    	game.batch.end();
    	 SchoolInputs.move();
    	    	    	
    	 if(new Collisions(x, y, booksize, booksize).isColliding(kidrect)) {
    		 Tank.schoolstat += 50;
    		 Tank.levels += 1;
    		 if(tries > 1) {
    			game.setScreen(new Mocking(game)); 
    		 }
    		 else {
    		 game.setScreen(new Tank(game));
    		 }
    	 }
    	// timer
    	 if(c>0) {
    	 c -= (delta);
    	 Integer c2 = (int) c; 
    	 
    	game.batch.begin();
    	game.font.getData().setScale(2f);
    	 game.font.draw(game.batch, c2.toString(), 320, 450);
    	game.batch.end();
    	 }
    	 else {
    		 tries+=1;
    		 game.setScreen(new School(game));
    	 }
      }
      
      public void hide() {
    	  Gdx.input.setInputProcessor(null);
    	
      }
}
