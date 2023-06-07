package com.mygdx.game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;


public class MyInputProcessor implements InputProcessor {
	
	public static String f = "";

	public static boolean c = false;
	
	   public boolean keyDown (int keycode) {
		
		   Sound sound = Gdx.audio.newSound(Gdx.files.internal("type1.mp3"));
		   sound.play();
		 if (keycode != Keys.BACKSPACE && keycode != Keys.SPACE && keycode != Keys.ENTER) {
			 f += Keys.toString(keycode);
		 }
		  if(keycode == Keys.BACKSPACE && f.length() > 0) {
			  f = f.substring(0, f.length()-1);
		  }
		  if(keycode == Keys.SPACE) {
			  f += " ";
		  }
		  if(keycode == Keys.ENTER) {
			  c = true;
		  }
		 
		 
	      return false;
	   }
	
	   public static void resetf() {
		   f = "";
	   }

	   public boolean keyUp (int keycode) {
		   c = false;
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
