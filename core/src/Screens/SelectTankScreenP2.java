package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.TankWar;

public class SelectTankScreenP2 implements Screen {

    private Texture back_inactive;
    private Texture back_active;
    private Texture Select;
    private Texture tank1;
    private Texture tank2;
    private Texture tank3;
    private Texture Player2;
    private Sprite sprite;

    TankWar game;
    public SelectTankScreenP2(TankWar game){
        this.game=game;
        this.back_active=new Texture("back_active.png");
        this.back_inactive=new Texture("back_inactive.png");
        this.back_active=new Texture("back_active.png");
        this.Select=new Texture("SELECT_TANK.png");
        this.tank1=new Texture("Tank1_flip.png");
        this.tank2=new Texture("TANK2_flip.png");
        this.tank3=new Texture("Tank3_flip.png");
        this.Player2=new Texture("PLAYER_2.png");
        this.sprite=new Sprite(tank1);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0.1f,0);
        game.batch.begin();
        game.batch.draw(Select,(1600)/2-250,(900-170),400,55);
        game.batch.draw(Player2,(1600)/2-135,900-250,200,35);
        if(Gdx.input.getX()<(1600-150)/2+100&&Gdx.input.getX()>(1600-170)/2&&TankWar.y-Gdx.input.getY()<450-45-100-50&&TankWar.y-Gdx.input.getY()>450-115-100-50) {
            game.batch.draw(back_active,(1600-150)/2,65,100,45);
            if(Gdx.input.isTouched()){
                game.setScreen(new BUFFERSCREEN(new SelectTankScreen(game),game));

            }
        }

        else {
            game.batch.draw(back_inactive,(1600-150)/2,65,100,45);
        }
        if(Gdx.input.getX()<200+200&&Gdx.input.getX()>180&&TankWar.y-Gdx.input.getY()<400+250&&TankWar.y-Gdx.input.getY()>550){

            game.batch.draw(tank1,200,400,300,300);
            if(Gdx.input.isTouched()){
                this.game.setTank2(tank1);
                game.setScreen(new BUFFERSCREEN(new PLAYERVERSUSSCREEN(game),game));
            }
        }
        else{
            game.batch.draw(tank1,200,400,200,200);
        }
        if(Gdx.input.getX()<200+200+200+200&&Gdx.input.getX()>650&&TankWar.y-Gdx.input.getY()<400+250&&TankWar.y-Gdx.input.getY()>550){

            game.batch.draw(tank2,650,400,300,300);
            if(Gdx.input.isTouched()){
                this.game.setTank2(tank2);
                game.setScreen(new BUFFERSCREEN(new PLAYERVERSUSSCREEN(game),game));
            }
        }
        else{
            game.batch.draw(tank2,650,400,200,200);
        }
        if(Gdx.input.getX()<1150+300&&Gdx.input.getX()>1150&&TankWar.y-Gdx.input.getY()<400+250&&TankWar.y-Gdx.input.getY()>550){
            game.batch.draw(tank3,1100,450,300,200);
            if(Gdx.input.isTouched()){
                this.game.setTank2(tank3);
                game.setScreen(new BUFFERSCREEN(new PLAYERVERSUSSCREEN(game),game));
            }
        }
        else{
            game.batch.draw(tank3,1100,450,200,100);
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
