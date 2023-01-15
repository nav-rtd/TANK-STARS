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
        if(fa.getUserData().toString()=="Ground"&&fb.getUserData().toString()=="Tank") {
                if(((Tank)fb.getUserData()).getName()=="P1") {
                    parent.check1 = true;
                    System.out.println(((Tank)fb.getUserData()).getName());
                    ((Tank) fb.getUserData()).getPlayer().setGravityScale(0f);
                }
                if(((Tank)fb.getUserData()).getName()=="P2") {
                    parent.check2 = true;
                    System.out.println(((Tank)fb.getUserData()).getName());
                    ((Tank) fb.getUserData()).getPlayer().setGravityScale(0f);
                }

        }
        if(fb.getUserData().toString()=="Ground"&&fa.getUserData().toString()=="Tank") {
            if(((Tank)fa.getUserData()).getName()=="P1") {
                parent.check1 = true;
                System.out.println(((Tank)fa.getUserData()).getName());
                ((Tank) fa.getUserData()).getPlayer().setGravityScale(0f);
            }
            if(((Tank)fa.getUserData()).getName()=="P2") {
                parent.check2 = true;
                System.out.println(((Tank)fa.getUserData()).getName());
                ((Tank) fa.getUserData()).getPlayer().setGravityScale(0f);
            }

        }
        if(fb.getUserData().toString()=="BULLET"&&fa.getUserData().toString()=="Tank"){
            ((Tank)fa.getUserData()).setHealth(((BULLETS)fb.getUserData()).Damage);
        }



    }

    @Override
    public void endContact(Contact contact) {
        Fixture fa=contact.getFixtureA();
        Fixture fb=contact.getFixtureB();
        try {
            if (fa.getUserData().toString() == "Tank") {
                if (((Tank) fa.getUserData()).getName() == "P1") {
                    parent.check1=false;
                    System.out.println(((Tank) fb.getUserData()).getName());
                    ((Tank) fa.getUserData()).getPlayer().setLinearVelocity(0, -9.8f);
                }
                if (((Tank) fb.getUserData()).getName() == "P2") {
                    parent.check2=false;
                    System.out.println(((Tank) fb.getUserData()).getName());
                    ((Tank) fb.getUserData()).getPlayer().setLinearVelocity(0, -9.8f);
                }
            }
            if (fb.getUserData().toString() == "Tank") {
                if (((Tank) fb.getUserData()).getName() == "P1") {
                    parent.check1=false;
                    System.out.println(((Tank) fb.getUserData()).getName());
                    ((Tank) fb.getUserData()).getPlayer().setLinearVelocity(0, -9.8f);
                }
                if (((Tank) fb.getUserData()).getName() == "P2") {
                    parent.check2=false;
                    System.out.println(((Tank) fb.getUserData()).getName());
                    ((Tank) fb.getUserData()).getPlayer().setLinearVelocity(0, -9.8f);
                }
            }
            if (fa.getUserData().toString() == "BULLET") {
                parent.destroy.add(fa);
            }
            if (fb.getUserData().toString() == "BULLET") {
                parent.destroy.add(fb);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
        Fixture fa=contact.getFixtureA();
        Fixture fb=contact.getFixtureB();
        if(fb.getUserData().toString()=="Tank") {
            if (((Tank) (fb.getUserData())).getName() == "P1") {
                parent.check1 = true;
            }
            else{
                parent.check2=true;
            }

        }
        if(fa.getUserData().toString()=="Tank"){
            if (((Tank) (fa.getUserData())).getName() == "P1"){
                parent.check1=true;

            }
            else{
                parent.check2=true;
            }

        }


    }
}
