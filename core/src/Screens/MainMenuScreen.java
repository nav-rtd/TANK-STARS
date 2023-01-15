package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.TankWar;

import javax.script.ScriptEngine;
import java.util.PropertyResourceBundle;

public class MainMenuScreen implements Screen {
    TankWar game;
    private Texture img;
    private Texture Playbutton_Active;
    private Texture Playbutton_Inactive;
    private Texture ExitButton_Active;
    private Texture ExitButton_Inactive;
    private Music music;
    private Sound sound;
    private static final int Play_Button_Width=125;
    private static final int Play_Button_Height=125;
    private static final int Exit_Button_Height=125;
    private static final int Exit_Button_Width=125;
    private static final int Play_Button_Y=500;
    private static final int Exit_Button_X=250;
    public MainMenuScreen(TankWar game){
        this.game=game;
        this.img = new Texture("Tank_Man.jpeg");
        this.Playbutton_Active=new Texture("play_button_active.png");
        this.Playbutton_Inactive=new Texture("play_button_inactive.png");
        this.ExitButton_Active=new Texture("exit_button_active.png");
        this.ExitButton_Inactive=new Texture("exit_button_inactive.png");
        this.music= Gdx.audio.newMusic(Gdx.files.internal("nsong.mp3"));
        this.sound=Gdx.audio.newSound(Gdx.files.internal("cr_suuu.wav"));
    }

    @Override
    public void show() {


    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 0, 0, 1);

        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            music.setLooping(true);
            music.play();
            music.setVolume(0.5f);

        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            music.stop();

        }
        game.batch.begin();
        int x=(TankWar.x-Play_Button_Width)/2;
        game.batch.draw(img, 0, 0,800,800);
        if(Gdx.input.getX()<(400+(100/2f))&&Gdx.input.getX()>(400-(100/2f))&&800-Gdx.input.getY()>(500-(100/2f))&&800-Gdx.input.getY()<500+(100/2f)){
            game.batch.draw(Playbutton_Active,(400-(100/2f)),(500-(100/2f)),100,100);
            if(Gdx.input.isTouched()){
                sound.play();
                game.setScreen(new BUFFERSCREEN(new StartGameScreen(game),game));

            }

        }
        else{
            game.batch.draw(Playbutton_Inactive,(400-(100/2f)),(500-(100/2f)),100,100);
        }
        if(Gdx.input.getX()<(400+(100/2f))&&Gdx.input.getX()>(400-(100/2f))&&800-Gdx.input.getY()<(300+(100/2f))&&800-Gdx.input.getY()>300-(100/2f)){
            game.batch.draw(ExitButton_Active,(400-(100/2f)),(300-(100/2f)),100,100);
            if(Gdx.input.isTouched()){
                Gdx.app.exit();
            }
        }
        else{
            game.batch.draw(ExitButton_Inactive,(400-(100/2f)),(300-(100/2f)),100,100);
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
