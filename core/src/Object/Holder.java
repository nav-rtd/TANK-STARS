package Object;

import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.game.TankWar;

public class Holder  extends Destructable_Objects{
    public Point p;
    public Body b;
    public boolean Check=true;

    Holder(Point p, Body b,TankWar tankWar) {
        super(tankWar);
        this.p = p;
        this.b = b;
    }

    @Override
    public String toString() {
        return "Ground";
    }

    @Override
    public Boolean getCheck() {
        return super.getCheck();
    }
}
