package Helpers;

import Screens.Gamescreen;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.TankWar;
import Object.*;
import Screens.Gamescreen;

import java.util.HashMap;

public class Listner implements ContactListener{
    private TankWar  parent;
    private Tank p1;
    private BULLETS b;
    public HashMap<Fixture,Integer>destroy=new HashMap<Fixture, Integer>();


    public Listner(TankWar game){
        this.parent= game;
    }
    @Override
    public void beginContact(Contact contact) {
        Fixture fa=contact.getFixtureA();
        Fixture fb=contact.getFixtureB();
        if(fa.getUserData().toString()=="Ground"&&fb.getUserData().toString()=="Tank"){
            parent.check=true;
            System.out.println(fb.getUserData());

            ((Tank)fb.getUserData()).getPlayer().setGravityScale(0f);
        }


    }

    @Override
    public void endContact(Contact contact) {
        parent.check=false;
        Fixture fa=contact.getFixtureA();
        Fixture fb=contact.getFixtureB();
        if(fa.getUserData().toString()=="Tank"){
            ((Tank)fa.getUserData()).getPlayer().setLinearVelocity(0,-9.8f);
        }
        if(fb.getUserData().toString()=="Tank"){
            ((Tank)fb.getUserData()).getPlayer().setLinearVelocity(0,-9.8f);
        }
        if(fa.getUserData().toString()=="BULLET"){
            parent.destroy.add(fa);
        }
        if(fb.getUserData().toString()=="BULLET"){
            parent.destroy.add(fb);
        }

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
        Fixture fa=contact.getFixtureA();
        Fixture fb=contact.getFixtureB();
        if(fa.getUserData().toString()=="Tank"){
            parent.check=true;
        }
        if(fb.getUserData().toString()=="Tank"){
            parent.check=true;
        }


    }
}
