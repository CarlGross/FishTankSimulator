package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;

public class Church extends ScreenAdapter{
   fisher game;
   ArrayList<Integer> player = new ArrayList<>();
  static ArrayList<Integer> deck = new ArrayList<>();
  Integer tot;
  Integer dtot;
  boolean st = false;
  boolean once = false;
   int dupli=0;	   
   int r;
   ArrayList<Integer> dealer = new ArrayList<>();
   boolean b = false;
 Church(fisher game) {
	   this.game = game;
   }
 public static void resetdeck() {
	 deck.clear();
	  for(Integer i = 1; i < 10; i++) {
		   for(int j = 0; j < 4; j++) {
			   deck.add(i);
		   }
	   }
	  for(int i = 0; i < 16; i++) {
		  deck.add(10);
	  }
	  
 }
 public Integer total(ArrayList<Integer> list) {
	 Integer tot = 0;
	 for(Integer i: list) {
		 tot+=i;
	 }
	 return tot;
			 
 }
 
 public void hit(ArrayList<Integer> list) {
     r = (int) (Math.random()*deck.size());
     if(deck.get(r) == 1) {
    	 if(total(list) < 11) {
    		 deck.set(r, 11);
    	 }
     }
      list.add(deck.get(r));
      deck.remove(r);
 }

  
   public void show() {
	   game.casmusic.setLooping(true);
	   game.casmusic.play();
	   MyInputProcessor inputprocessor = new MyInputProcessor();
	   Gdx.input.setInputProcessor(inputprocessor);
       Church.resetdeck();
       hit(player);
       hit(dealer);
       hit(player);
      
	   }
   
   public void render(float delta) {	 
	   dtot = total(dealer);
	   tot = total(player); 
	   game.batch.begin();
		game.batch.draw(game.cas, 0, 0);
		game.font.getData().setScale(1f);
		game.font.draw(game.batch, "Faith: "+Tank.churchstat.toString(), 545, 470);
		game.font.getData().setScale(1.8f);
		if (tot > 21) {
			
			game.font.draw(game.batch, "Sorry, you busted!\nType Hit to play again\nType Tank to go back", 240, 120);
			if(Tank.churchstat > 1 && once == false) {
				once = true;
				Tank.churchstat -= 10;
			
			}
		}
		if(st == true) {
		if (dtot > 21 || tot > dtot) {
			game.font.draw(game.batch, "You win!\nType Hit to play again\nType Tank to go back", 240, 120);
			if(Tank.churchstat < 100 && once == false) {
				once = true;
			Tank.churchstat += 10;
			}
		}
		else if(dtot > tot) {
			game.font.draw(game.batch, "Sorry, dealer wins!\nType Hit to play again\nType Tank to go back", 240, 120);
			if(Tank.churchstat > 1 && once == false) {
				once = true;
				Tank.churchstat -= 10;
			}
		}
		else if(dtot == tot) {
			game.font.draw(game.batch, "Push!\nType Hit to play again\nType Tank to go back", 240, 120);
		}
		}
		
		game.font.draw(game.batch, "Welcome to Church! Hit or Stay? (Dealer softs 17)", 20, 440);
		game.font.draw(game.batch, "Your cards: "+player.toString()+" Total: "+tot.toString()+"\nDealer's cards: "+dealer.toString()+" Total: "+dtot.toString(), 120, 340);
	   game.font.draw(game.batch, MyInputProcessor.f, 300, 240);
	   game.batch.end();
	   if (MyInputProcessor.c && MyInputProcessor.f.equals("TANK") && (st == true || tot > 21)) {
		   MyInputProcessor.resetf();
		   game.setScreen(new Tank(game));
	   }
	   if (MyInputProcessor.c && MyInputProcessor.f.equals("STAY") && st == false && tot < 22) {
		   st = true;
		   MyInputProcessor.resetf();
		   while (dtot < 17) {
			hit(dealer);
			dtot = total(dealer);
	   }
		   
		   }
	
	   if (MyInputProcessor.c && MyInputProcessor.f.equals("HIT")) {
		   MyInputProcessor.resetf();
		   if(st == true || tot > 21) {
			   st = false;
			   once = false;
			   player.clear();
			   dealer.clear();
			   Church.resetdeck();
			   hit(player);
			   hit(dealer);
			 
		   }
		   hit(player);
		  		
	   } 
   }
   public void hide() {
	   game.casmusic.stop();
	   Gdx.input.setInputProcessor(null);
   }
}
