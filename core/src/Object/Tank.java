package Object;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.TankWar;

public class Tank {
    public final static int MAX_FUEL=300;
    public final static int PPM=8;
    private Body body;
    private BodyDef bodyDef;
    private BodyDef head;
    public BULLETS bullets;
    private FixtureDef def;
    private Fixture fixture;
    public static final float MAX_ANGLE=MathUtils.PI/2f;
    public static final float MIN_ANGLE=0;
    private int Health;
    private String Name;
    private int Fuel;
    private TankWar game;
    private BULLETS x;
    private boolean delete_check=true;


    public Tank(TankWar tankWar,int x,int y,String n){
        this.game=tankWar;
        this.Health=100;
        this.Fuel=300;
        def=new FixtureDef();
        bodyDef=new BodyDef();
        bodyDef.type=BodyDef.BodyType.DynamicBody;
        bodyDef.fixedRotation=false;
        bodyDef.position.set(x/4f,y/4f);
        body=tankWar.world.createBody(bodyDef);
        CircleShape shape=new CircleShape();
        def.shape=shape;
        def.density=1f;
        def.friction=0;
        shape.setRadius(8/4f);
        body.createFixture(def).setUserData(this);
        shape.dispose();
        this.Name=n;

    }
    public Body getPlayer(){
        return body;
    }
    public Tank getTank(){
        return this;
    }
    public void SHOOT(){
        float time=Gdx.graphics.getDeltaTime();
        x = new BULLETS(game, this, game.getAngle(this), time, 0);
    }
    @Override
    public String toString() {

        return "Tank";
    }
    public void setHealth(int i){
        this.Health-=i;
    }

    public String getName() {
        return Name;
    }
    public void setFuel(){
        this.Fuel-=1;
    }
    public int getFuel(){
        return this.Fuel;
    }
    public int getHealth(){
        return this.Health;
    }
    public boolean getdelete_check(){
        return delete_check;
    }
}
