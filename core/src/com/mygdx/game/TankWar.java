package com.mygdx.game;

import Screens.Gamescreen;
import Screens.MainMenuScreen;
import Screens.inGameClass;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.security.Key;

public class TankWar extends Game {
	public static final int x=1600;
	public static final int y=900;
	private Texture Tank1;
	private Texture Tank2;

	public SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new MainMenuScreen(this));


	}

	@Override
	public void render () {
		super.render();
	}
	@Override
	public void dispose () {
		batch.dispose();
	}

	public void setTank1(Texture tank1) {
		this.Tank1=tank1;
	}
	public void setTank2(Texture tank2){
		this.Tank2=tank2;

	}
	public Texture getTank1(){
		return Tank1;
	}
	public Texture getTank2(){
		return Tank2;
	}
}
