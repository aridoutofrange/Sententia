package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

public class SententiaGame extends ApplicationAdapter {
	public static int WIDTH;
	public static int HEIGHT;
	
	@Override
	public void create () {
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 1, 1);

	}
	
	
}
