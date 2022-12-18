package Object;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.mygdx.game.TankWar;

public class Tank {
    public enum state{STANDING,MOVING,FALLING,CLIMBING};
    state Current;
    state Previous;
    public final static int PPM=8;
    private Body body;
    private BodyDef bodyDef;
    private BodyDef head;
    public BULLETS bullets;
    public boolean Moving;

    public Tank(TankWar tankWar){
        bodyDef=new BodyDef();
        bodyDef.type=BodyDef.BodyType.DynamicBody;
        bodyDef.fixedRotation=true;
        bodyDef.position.set(400/4f,300/4f);
        Current=state.STANDING;
        Previous=state.STANDING;
        Moving=true;

        body=tankWar.world.createBody(bodyDef);
        PolygonShape shape=new PolygonShape();
        shape.setAsBox(8/4f,8/4f);
        body.createFixture(shape,0.01f).setUserData(this);
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
    public state getState(){
        if(body.getLinearVelocity().y<0){
            return state.FALLING;
        }
        else if(body.getLinearVelocity().x!=0){
            return state.MOVING;
        }
        else if(body.getLinearVelocity().y>0){
            return state.CLIMBING;
        }
        else{
            return state.STANDING;
        }
    }


}
