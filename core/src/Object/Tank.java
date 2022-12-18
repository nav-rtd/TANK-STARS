package Object;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.mygdx.game.TankWar;

public class Tank {
    public final static int PPM=8;
    private Body body;
    private BodyDef bodyDef;
    private BodyDef head;
    public BULLETS bullets;

    public Tank(TankWar tankWar){
        bodyDef=new BodyDef();
        bodyDef.type=BodyDef.BodyType.DynamicBody;
        bodyDef.fixedRotation=true;
        bodyDef.position.set(500/4f,500/4f);

        body=tankWar.world.createBody(bodyDef);
        PolygonShape shape=new PolygonShape();
        shape.setAsBox(8/4f,8/4f);
        body.createFixture(shape,1f).setUserData(this);
    }
    public Body getPlayer(){
        return body;
    }
    public Tank getTank(){
        return this;
    }

    @Override
    public String toString() {
        return "Tank";
    }


}
