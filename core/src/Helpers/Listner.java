package Helpers;

import Screens.Gamescreen;
import com.badlogic.gdx.ai.steer.behaviors.Face;
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

    public Listner(TankWar game,Tank p1){
        this.parent= game;
        this.p1=p1;
        this.b=p1.bullets;
    }
    @Override
    public void beginContact(Contact contact) {
        Point p;
        Fixture fa=contact.getFixtureA();
        Fixture fb=contact.getFixtureB();
        if(fa.getUserData().toString()=="Tank"&&fb.getUserData().toString()=="Ground") {


        }




        try{
            System.out.println("ok");

        }
        catch (Exception e){
            System.out.println(e.getMessage()+"inside listner");
        }

    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
        Fixture fa=contact.getFixtureA();
        Fixture fb=contact.getFixtureB();
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
        int x=0;
        Fixture fa= contact.getFixtureA();
        Fixture fb=contact.getFixtureB();
        TiledMap tiledMap=parent.tiledMap;
        TiledMapTileLayer tileset=(TiledMapTileLayer)parent.tiledMap.getLayers().get("Ground");
        Point p;
        Holder h;
        try{
            if((fa.getUserData().toString()=="BULLET"&&fb.getUserData().toString()=="Ground")){
                parent.destroy.add(fa);
                parent.destroy.add(fb);
                try{
                    tileset.setCell(((Holder)fb.getUserData()).p.getX(), ((Holder)fb.getUserData()).p.getY(),null);
                }
                catch (Exception e){

                }
            }
            else if(fa.getUserData().toString()=="Ground"&&fb.getUserData().toString()=="BULLET"){
                parent.destroy.add(fa);
                parent.destroy.add(fb);

                try{
                    tileset.setCell(((Holder)fa.getUserData()).p.getX(), ((Holder)fa.getUserData()).p.getY(),null);
                }
                catch (Exception e){

                }
            }
            if(fa.getUserData().toString()=="Tank"&&fb.getUserData().toString()=="Ground"){
                ((Tank)fa.getUserData()).getPlayer().applyLinearImpulse(1000f,0,fa.getBody().getPosition().x*4,fa.getBody().getPosition().y*4,false);
            }




        }
        catch (Exception e) {
            System.out.println("lol");
        }

    }
}
