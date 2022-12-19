package Object;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.TankWar;

import java.util.Objects;

public class PolylineObjects {
    TankWar game;
    Body body;
    TiledMap map;
    World world;
    MapObjects o;
    public PolylineObjects(TankWar game){
        this.game=game;
        map=game.tiledMap;
        world=game.world;
        o=map.getLayers().get(1).getObjects();
    }
    public void makeobject(){
        for(MapObject object:o){
            Shape shape;
            if(object instanceof PolylineMapObject){
                shape=make_shape((PolylineMapObject) object);
            }
            else{
                continue;
            }
            Body body1;
            BodyDef bodyDef=new BodyDef();
            bodyDef.type=BodyDef.BodyType.StaticBody;
            body1= world.createBody(bodyDef);
            body1.createFixture(shape,1f).setUserData(this);
            shape.dispose();
        }
    }
    public ChainShape make_shape(PolylineMapObject Object){
        float[] vertices=Object.getPolyline().getTransformedVertices();
        Vector2[] vertex=new Vector2[vertices.length/2];
        for(int i=0;i<vertex.length;i++){
            vertex[i]=new Vector2(vertices[i*2]/4f,vertices[i*2+1]/4f);

        }
        ChainShape s=new ChainShape();
        s.createChain(vertex);
        return s;



    }

    @Override
    public String toString() {
        return "Ground";
    }
}
