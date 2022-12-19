package Object;

import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.TankWar;

public class Tank {
    public final static int PPM=8;
    private Body body;
    private BodyDef bodyDef;
    private BodyDef head;
    public BULLETS bullets;
    private FixtureDef def;
    private Fixture fixture;

    public Tank(TankWar tankWar){
        def=new FixtureDef();
        bodyDef=new BodyDef();
        bodyDef.type=BodyDef.BodyType.DynamicBody;
        bodyDef.fixedRotation=false;
        bodyDef.position.set(600/4f,600/4f);
        body=tankWar.world.createBody(bodyDef);
        CircleShape shape=new CircleShape();
        def.shape=shape;
        def.density=1f;
        def.friction=0;
        shape.setRadius(8/4f);
        body.createFixture(def).setUserData(this);
        shape.dispose();

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
