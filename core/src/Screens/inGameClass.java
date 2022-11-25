package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.TankWar;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.security.PrivateKey;
import java.util.PropertyResourceBundle;

public class inGameClass implements Screen {

    private Texture Controls_active;
    private Texture Controls_inactive;
    private Texture MainMenu_active;
    private Texture MainMenu_inactive;
    private Texture resume_inactive;
    private Texture resume_active;
    private Texture Save_inactive;
    private Texture Save_active;
    TankWar game;
    public inGameClass(TankWar game){

        this.Controls_active=new Texture("controls_active.png");
        this.Controls_inactive=new Texture("controls_inactive.png");
        this.MainMenu_active=new Texture("mainemenuactive.png");
        this.MainMenu_inactive=new Texture("mainemenu_inactive.png");
        this.resume_active=new Texture("resume_active.png");
        this.resume_inactive=new Texture("resume_inactive.png");
        this.Save_active=new Texture("Save_active.png");
        this.Save_inactive=new Texture("Save_inactive.png");

        this.game=game;
    }
    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,0.1f);
        game.batch.begin();
        game.batch.draw(resume_inactive,(1600/2-180),(650),180,30);
        game.batch.draw(Save_inactive,(1600/2-170),500,150,30);
        game.batch.draw(Controls_inactive,(1600/2-180),350,180,35);
        game.batch.draw(MainMenu_inactive,(1600/2-180),200,180,40);
        if(Gdx.input.getX()<(1600/2+20)&&Gdx.input.getX()>(1600/2-180)&&TankWar.y-Gdx.input.getY()<800&&TankWar.y-Gdx.input.getY()>765){
            game.batch.draw(resume_active,(1600/2-180),(650),180,30);
            if(Gdx.input.isTouched()){
                game.setScreen(new BUFFERSCREEN(new Gamescreen(game),game));
            }
        }
        if(Gdx.input.getX()<(1600/2+20)&&Gdx.input.getX()>(1600/2-180)&&TankWar.y-Gdx.input.getY()<650&&TankWar.y-Gdx.input.getY()>620){
            game.batch.draw(Save_active,(1600/2-170),500,150,30);
            if(Gdx.input.isTouched()){

            }
        }
        if(Gdx.input.getX()<(1600/2+20)&&Gdx.input.getX()>(1600/2-180)&&TankWar.y-Gdx.input.getY()<500&&TankWar.y-Gdx.input.getY()>465){
            game.batch.draw(Controls_active,(1600/2-180),350,180,35);
            if(Gdx.input.isTouched()){

            }
        }
        if(Gdx.input.getX()<(1600/2+40)&&Gdx.input.getX()>(1600/2-180)&&TankWar.y-Gdx.input.getY()<375&&TankWar.y-Gdx.input.getY()>300){
            game.batch.draw(MainMenu_active,(1600/2-180),200,180,40);
            if(Gdx.input.isTouched()){
                game.setScreen(new BUFFERSCREEN(new MainMenuScreen(game),game));
            }
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
