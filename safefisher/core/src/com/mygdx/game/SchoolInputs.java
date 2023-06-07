package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;

public class SchoolInputs implements InputProcessor {
   public static float speed = 2f;
    static boolean bol = false;
     static boolean W = false, S = false, A = false, D = false;
	  public boolean keyDown (int keycode) {
			if(keycode == Keys.W) {
				
				W = true;
			}
			if(keycode == Keys.S) {
				S = true;
			}
			if(keycode == Keys.A) {
				A = true;
			}
			if(keycode == Keys.D) {
				D = true;
			}
	
	
		 
		 
	      return false;
	   }
	  public static void move() {
		  for(Collisions slime: School.slimecoll) {
		  if(new Collisions(School.x, School.y, School.booksize, School.booksize).isColliding(slime)) {
			  speed = 0.5f;
		  }
		  }
		  
		  
		  if(W == true) {
			  for(Collisions coll: School.blockcoll) {
			  if(new Collisions(School.x, School.y + speed, School.booksize, School.booksize).isColliding(coll)) {
			  bol = true;
			  }
		  }
			  if(bol == false) {
				  School.y += speed;
			  }
			  bol = false;
		  }
		  if(S == true) {
			  for(Collisions coll: School.blockcoll) {
			  if(new Collisions(School.x, School.y - speed, School.booksize, School.booksize).isColliding(coll)) {
			  bol = true;
			  }
		  } 
			  if(bol == false) {
				  School.y -= speed;
			  }
			  bol = false;
			  
		  }
		  if(A == true) {
			  for(Collisions coll: School.blockcoll) {
		  
			  if(new Collisions(School.x - speed, School.y , School.booksize, School.booksize).isColliding(coll)) {
			 bol = true;
			  }
		  }
			  if(bol == false) {
				  School.x -= speed;
			  }
			  bol = false;
		  }
		  if(D == true) {
			  for(Collisions coll: School.blockcoll) {
		  
			  if(new Collisions(School.x+speed, School.y , School.booksize, School.booksize).isColliding(coll)) {
			 bol = true;
			  }
		  }
			  if(bol == false) {
				  School.x += speed;
			  }
			  bol = false;
	  }
		  speed = 2f;
	  }
	
	

	   public boolean keyUp (int keycode) {
		   if(keycode == Keys.W) {
				
				W = false;
			}
			if(keycode == Keys.S) {
				S = false;
			}
			if(keycode == Keys.A) {
				A = false;
			}
			if(keycode == Keys.D) {
				D = false;
			}
		
	      return false;
	   }

	   public boolean keyTyped (char character) {
	      return false;
	   }

	   public boolean touchDown (int x, int y, int pointer, int button) {
	      return false;
	   }

	   public boolean touchUp (int x, int y, int pointer, int button) {
	      return false;
	   }

	   public boolean touchDragged (int x, int y, int pointer) {
	      return false;
	   }

	   public boolean mouseMoved (int x, int y) {
	      return false;
	   }

	   public boolean scrolled (float amountX, float amountY) {
	      return false;
	   }
	}


