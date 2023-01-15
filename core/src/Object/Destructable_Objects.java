package Object;

import com.mygdx.game.TankWar;

public class Destructable_Objects {
    private Boolean check=true;
    private TankWar game;
    Destructable_Objects(TankWar tankWar){
        this.game=tankWar;
    }
    public Boolean getCheck(){
        return this.check;
    }

}
