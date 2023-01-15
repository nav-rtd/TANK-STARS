package com.mygdx.game;

import Helpers.Listner;
import Screens.Gamescreen;
import Screens.MainMenuScreen;
import Screens.inGameClass;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.security.Key;
import Object.*;
import com.sun.org.apache.xpath.internal.operations.Bool;

public class TankWar extends Game {
	public static final int x=1600;
	public static final int y=900;
	private Texture Tank1;

	private Texture Tank2;


	public SpriteBatch batch;
	public TiledMap tiledMap;
	public OrthogonalTiledMapRenderer tiledMapRenderer;
	public OrthographicCamera cam;
	public FitViewport fitViewport;
	public World world;
	public Box2DDebugRenderer box2DDebugRenderer;
	public Array<Fixture>destroy=new Array<Fixture>();
	public Array<Fixture>Bulletdestroy=new Array<Fixture>();
	public Boolean check1;
	public Boolean check2;
	public Boolean turn;
	public Tank current_tenk;




	@Override
	public void create () {
		turn=false;
		check1=false;
		check2=false;
		fitViewport=new FitViewport(800,800);
		batch = new SpriteBatch();
		world=new World(new Vector2(0,-30f*9.8f),false);
		box2DDebugRenderer=new Box2DDebugRenderer();
		this.setScreen(new MainMenuScreen(this));
		Tank1=new Texture("Tank1.png");
		Tank2=new Texture("TANK2_flip.png");
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
	public float getAngle(Tank p1){
		float angle= MathUtils.atan2(200-(Gdx.input.getY()/4f)-(p1.getPlayer().getPosition().y),(Gdx.input.getX()/4f)-p1.getPlayer().getPosition().x);
		if(p1.getName()=="P2"){
			if(angle<MathUtils.HALF_PI&&angle>0){
				System.out.println(angle);
				angle=MathUtils.PI/2f;

			}
			else if (angle>MathUtils.PI||angle<0) {
				angle = MathUtils.PI;
			}
			return angle;
		}
		else{
			if(angle>MathUtils.PI/2f){
				angle=MathUtils.PI/2f;
			}
			if(angle<0){
				angle=0;
			}
			return angle;
		}

//        System.out.println(200-(Gdx.input.getY()/4f)-(p1.getPlayer().getPosition().y));
//        System.out.println((Gdx.input.getX()/4f)-p1.getPlayer().getPosition().x);


	}

}
