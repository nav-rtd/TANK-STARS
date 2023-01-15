package Object;

import Screens.Gamescreen;
import Screens.StartGameScreen;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.mygdx.game.TankWar;

public class BULLETS extends Destructable_Objects {
    public static final int Damage=10;
     private CircleShape shape;
    private Body bullet;
    private BodyDef bullet_def;
    TankWar game;
    public Boolean C=true;
    private static final int Max_Power=10;
    private static final int MinPower=1;

    public BULLETS(TankWar tankWar,Tank p1,float Thetha,float delta,int Power){

        super(tankWar);
        if(Power>10){
            Power=Max_Power;
        }
        if(Power<1){
            Power=MinPower;
        }
        this.game=tankWar;
        shape=new CircleShape();
        shape.setRadius(10f/4f);
        shape.setPosition(new Vector2(p1.getPlayer().getPosition().x+10,p1.getPlayer().getPosition().y+40/4f));
        bullet_def=new BodyDef();
        bullet_def.type=BodyDef.BodyType.DynamicBody;
        bullet=game.world.createBody(bullet_def);
        bullet.createFixture(shape,1f).setUserData(this);
        bullet.setGravityScale(0.35f);
        bullet.setLinearVelocity(9f*55000000f*MathUtils.cos(Thetha),9f*55000000f*MathUtils.sin(Thetha)-5f*delta);
    }

    @Override
    public String toString() {
        return "BULLET";
    }

    @Override
    public Boolean getCheck() {
        return super.getCheck();
    }
}
