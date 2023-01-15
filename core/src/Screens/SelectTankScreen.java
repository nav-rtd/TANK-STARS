package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.TankWar;

public class SelectTankScreen implements Screen {

    private Texture back_inactive;
    private Texture back_active;
    private Texture Select;
    private Texture tank1;
    private Texture tank2;
    private Texture tank3;
    private Texture Player1;

    TankWar game;
    public SelectTankScreen(TankWar game){
        this.game=game;
        this.back_active=new Texture("back_active.png");
        this.back_inactive=new Texture("back_inactive.png");
        this.back_active=new Texture("back_active.png");
        this.Select=new Texture("SELECT_TANK.png");
        this.tank1=new Texture("Tank1.png");
        this.tank2=new Texture("TANK2.png");
        this.tank3=new Texture("Tank3.png");
        this.Player1=new Texture("PLAYER_1.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0.1f,0);
        game.batch.begin();
        game.batch.draw(Select,(400-200/2f),(700-28/2f),200,28);
        game.batch.draw(Player1,(400-(100/2f)),650-(20/2f),100,20);
        if(Gdx.input.getX()<(400+(50/2f))&&Gdx.input.getX()>(400-(50/2f))/2&&800-Gdx.input.getY()<(200+(25/2f))&&TankWar.y-Gdx.input.getY()>200-(25/2f)) {
            game.batch.draw(back_active,400-(50/2f),(200-25/2f),50,25);
            if(Gdx.input.isTouched()){
                game.setScreen(new BUFFERSCREEN(new StartGameScreen(game),game));
            }
        }

        else {
            game.batch.draw(back_inactive,400-(50/2f),(200-25/2f),50,25);;
        }
        if(Gdx.input.getX()<200+(100/2f)&&Gdx.input.getX()>(200-(100/2f))&&800-Gdx.input.getY()<400+(100/2f)&&800-Gdx.input.getY()>(400-(100/2f))){
            game.batch.draw(tank1,200-(100/2f),(400-(100/2f)),100,100);
            if(Gdx.input.isTouched()){
                this.game.setTank1(tank1);
                game.setScreen(new BUFFERSCREEN(new SelectTankScreenP2(game),game));
            }
        }
        else{
            game.batch.draw(tank1,200-(50/2f),400-(50/2f),50,50);
        }
        if(Gdx.input.getX()<(400+(50/2f))&&Gdx.input.getX()>400-(100/2f)&&800-Gdx.input.getY()<400+(50/2f)&&TankWar.y-Gdx.input.getY()>400-(50/2f)){
            game.batch.draw(tank2,400-(100/2f),400-(100/2f),100,100);
            if(Gdx.input.isTouched()){
                this.game.setTank1(tank2);
                game.setScreen(new BUFFERSCREEN(new SelectTankScreenP2(game),game));
            }
        }
        else{
            game.batch.draw(tank2,400-(50/2f),400-(50/2f),50,50);
        }
        if(Gdx.input.getX()<550+(50/2f)&&Gdx.input.getX()>550-(50/2f)&&800-Gdx.input.getY()<400+(25/2f)&&TankWar.y-Gdx.input.getY()>400-(25/2f)){

            game.batch.draw(tank3,550-(100/2f),400-(50/2f),100,50);

            if(Gdx.input.isTouched()){
                this.game.setTank1(tank3);
                game.setScreen(new BUFFERSCREEN(new SelectTankScreenP2(game),game));

            }

        }
        else{
            game.batch.draw(tank3,550-(50/2f),400-(25/2f),50,25);
        }










        game.batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
