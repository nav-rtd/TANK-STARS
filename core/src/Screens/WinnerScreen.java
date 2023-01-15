package Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.TankWar;
import Object.*;

import java.security.PrivateKey;

public class WinnerScreen implements Screen {
    TankWar game;
    private Texture exit_button_inactive;
    private Texture exit_button_active;
    private Texture texture;
    private Texture winner_Tank;
    public WinnerScreen(TankWar game,Tank Winner){
        this.game=game;
        if(Winner.getName()=="P1"){
            winner_Tank=game.getTank1();
        }
        else {
            winner_Tank=game.getTank2();
        }
        exit_button_active=new Texture("exit_button_inactive.png");
        exit_button_inactive=new Texture("exit_button_active.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,0);
        game.batch.begin();
        game.batch.draw(winner_Tank,(400-(200)/2f),(400-(200)/2f),200,200);
        game.batch.draw(exit_button_active,(400-100/2f),((200-100/2f)),100,100);
        if(Gdx.input.getX()>(400-(100)/2f)&&Gdx.input.getX()<(400+(100)/2f)&&(800-Gdx.input.getY())>(200-(100/2f))&&(800/4f-Gdx.input.getY())<((200+(100/2f)))){
            game.batch.draw(exit_button_inactive,(400-100/2f),((200-100/2f)),(100),(100));
            if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
                game.setScreen(new MainMenuScreen(game));
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
