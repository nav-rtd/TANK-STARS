package Object;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.TankWar;

import java.util.LinkedList;
import java.util.Map;

public class Terrain {
    Body body;
    BodyDef bodyDef;
    FixtureDef fixtureDef;
    PolygonShape shape;
    TiledMapTileLayer  tileset;
    boolean check;
    Point p_t;
    Holder holder;
    public LinkedList<Holder>linkedList=new LinkedList<Holder>();
    TankWar game;

    public Terrain(TiledMap Map, World world, TankWar Game) {
        tileset=(TiledMapTileLayer)Map.getLayers().get(0);
        fixtureDef = new FixtureDef();
        bodyDef = new BodyDef();
        shape = new PolygonShape();
        this.game=Game;

        for(int i=0;i<tileset.getWidth();i++){
            for(int j=0;j<tileset.getHeight();j++){
                try {
                    check=true;
                    Object property = tileset.getCell(i, j).getTile().getProperties().get("Ground");
                }
                catch (Exception e){
                    System.out.println("LOL");
                    int k=0;
                    check=false;
                }
                finally {
                    if(check) {
                        bodyDef.type = BodyDef.BodyType.StaticBody;
                        bodyDef.position.set(i, j);
                        p_t=new Point(i,j);
                        body = world.createBody(bodyDef);
                        shape.setAsBox(1,1);
                        Holder x=new Holder(p_t, body,game);
                        body.createFixture(shape, 1.0f).setUserData(x);
                        linkedList.add(x);
                    }
                }
            }
        }
    }
}
