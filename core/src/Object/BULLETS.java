package Object;

import Screens.Gamescreen;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.mygdx.game.TankWar;

public class BULLETS extends Destructable_Objects {


    CircleShape shape;
    public Body bullet;
    public BodyDef bullet_def;
    TankWar game;
    public Boolean C=true;
    public BULLETS(TankWar tankWar,Tank p1){
        super(tankWar);
        this.game=tankWar;
        shape=new CircleShape();
        shape.setRadius(10f/4f);
        shape.setPosition(new Vector2(p1.getPlayer().getPosition().x+10,p1.getPlayer().getPosition().y+40/4f));
        bullet_def=new BodyDef();
        bullet_def.type=BodyDef.BodyType.DynamicBody;
        bullet=game.world.createBody(bullet_def);
        bullet.createFixture(shape,1f).setUserData(this);
        bullet.setLinearVelocity(100,100);
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
