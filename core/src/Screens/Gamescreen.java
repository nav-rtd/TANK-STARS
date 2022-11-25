package Screens;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.TankWar;

public class Gamescreen implements Screen {
    public TankWar game;
    private Texture GAMEBACKGROUND;
    private Music music;
    private Texture Player1_health;
    private Texture Player2_health;
    private Texture Player1_fuel;
    private Texture Player2_fuel;
    public Gamescreen(TankWar tank) {
        this.game=tank;
        this.GAMEBACKGROUND= new Texture("Asset_4_2.png");
        this.music= Gdx.audio.newMusic(Gdx.files.internal("nsong.mp3"));
        this.Player1_health=new Texture("Health_Bar.png");
        this.Player2_health=new Texture("Health_Bar.png");
        this.Player1_fuel=new Texture("Fuel.png");
        this.Player2_fuel=new Texture("Fuel.png");
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 0.5f);
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            music.play();
            music.setVolume(0.5f);

        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            music.stop();

        }
        game.batch.begin();
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            game.setScreen(new BUFFERSCREEN(new inGameClass(game),game));
        }
        game.batch.draw(GAMEBACKGROUND, 0,0,1600,900);
        game.batch.draw(game.getTank1(),0,(305),100,100);
        game.batch.draw(game.getTank2(),990,350,100,100);
        game.batch.draw(Player1_health,0,770,200,30);
        game.batch.draw(Player1_fuel,0,750,100,20);
        game.batch.draw(Player2_fuel,1340,750,100,20);
        game.batch.draw(Player2_health,1250,770,200,30);
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
