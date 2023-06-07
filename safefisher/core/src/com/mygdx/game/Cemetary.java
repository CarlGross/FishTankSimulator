package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;

public class Cemetary extends ScreenAdapter{
    fisher game;
    
    Cemetary(fisher game){
  	  this.game = game;
  	 
    }
    
    
    public void show() {
  	 MyInputProcessor inputprocessor = new MyInputProcessor();
  	 Gdx.input.setInputProcessor(inputprocessor);
    }
    public void render(float delta) {
    	game.batch.begin();
		game.batch.draw(game.cemetery, 0, 0);
		game.font.getData().setScale(1.8f);
		game.font.draw(game.batch, MyInputProcessor.f, 190, 200);
		game.font.getData().setScale(0.8f);
	
		game.font.draw(game.batch, "Heaven of Hell? You decide", 200, 450);
		if (Tank.judgements == 0) {
		game.font.draw(game.batch, "R.I.P. Ron\nSo-fish-ticated\nDied of a heart attack at Steak Escape\nNever missed an opper-tuna-ty to help a friend", 165, 290);
		}
		if (Tank.judgements == 1) {
		game.font.draw(game.batch, "R.I.P Ford\nConsistantly fishy\nDied in a head on collision with a family of 4\nNever fin-ished his pizza crust", 165, 290);
		}
		
		if (Tank.judgements == 2) {
			game.font.draw(game.batch, "R.I.P Hendren\nHat lover\nTinkerer\nMan out of time", 165, 290);
		}
		game.batch.end();
    if (MyInputProcessor.c && (MyInputProcessor.f.equals("HELL") || MyInputProcessor.f.equals("HEAVEN"))) {	
    	 Tank.judgements += 1;
    	 if(Tank.judgements == 1 && MyInputProcessor.f.equals("HELL")) {
    		 Tank.evil +=1;
    	 }
    	 if(Tank.judgements == 2 && MyInputProcessor.f.equals("HEAVEN")) {
    		 Tank.evil +=1;
    	 }
    	 if(Tank.judgements == 3 && MyInputProcessor.f.equals("HELL")) {
    		 Tank.evil +=1;
    	 }
    MyInputProcessor.f = "";	 
  	  game.setScreen(new Tank(game));
    }
    }
    public void hide() {
  	  Gdx.input.setInputProcessor(null);
    }
}
