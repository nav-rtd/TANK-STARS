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
    private Gamescreen gs;
    public inGameClass(TankWar game,Gamescreen current_gamescreen){
        this.Controls_active=new Texture("controls_active.png");
        this.Controls_inactive=new Texture("controls_inactive.png");
        this.MainMenu_active=new Texture("mainemenuactive.png");
        this.MainMenu_inactive=new Texture("mainemenu_inactive.png");
        this.resume_active=new Texture("resume_active.png");
        this.resume_inactive=new Texture("resume_inactive.png");
        this.Save_active=new Texture("Save_active.png");
        this.Save_inactive=new Texture("Save_inactive.png");
        this.gs=current_gamescreen;

        this.game=game;
    }
    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,0.1f);
        game.batch.begin();
        game.batch.draw(resume_inactive,(400-(90/2f)),(650-(15/2f)),90,15);
        game.batch.draw(Save_inactive,(400-(150/2f)),500-(30/2f),150,30);
        game.batch.draw(Controls_inactive,(400-(180/2f)),250-(35/2f),180,35);
        game.batch.draw(MainMenu_inactive,(400-(180/2f)),100-(40/2f),180,40);
        if(Gdx.input.getX()<(400+(150/2f))&&Gdx.input.getX()>(400-150/2f)&&800-Gdx.input.getY()<650+(15/2f)&&800-Gdx.input.getY()>650-(15/2f)){
            game.batch.draw(resume_active,(400-(90/2f)),(650-(15/2f)),90,15);
            if(Gdx.input.isTouched()){
                game.cam.setToOrtho(false,800/4f,800/4f);
                game.batch.setProjectionMatrix(game.cam.combined);
                game.setScreen(new BUFFERSCREEN(gs,game));
            }
        }
        if(Gdx.input.getX()<(400+(150/2f))&&Gdx.input.getX()>(400-(150/2f))&&800-Gdx.input.getY()<500+(30/2f)&&800-Gdx.input.getY()>500-(30/2f)){
            game.batch.draw(Save_active,(400-(150/2f)),500-(30/2f),150,30);
            if(Gdx.input.isTouched()){

            }
        }
        if(Gdx.input.getX()<(400+(180/2f))&&Gdx.input.getX()>(400-180/2f)&&800-Gdx.input.getY()<250+(35/2f)&&800-Gdx.input.getY()>250-(35/2f)){
            game.batch.draw(Controls_active,(400-(180/2f)),250-(35/2f),180,35);
            if(Gdx.input.isTouched()){

            }
        }
        if(Gdx.input.getX()<(400+(180/2f))&&Gdx.input.getX()>(400-180)&&800-Gdx.input.getY()<100+(40/2f)&800-Gdx.input.getY()>100-(40/2f)){
            game.batch.draw(MainMenu_active,(400-180/2f),100-(40/2f),180,40);
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
