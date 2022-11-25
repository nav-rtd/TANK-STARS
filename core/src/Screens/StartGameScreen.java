package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.TankWar;

public class StartGameScreen implements Screen {
    private Texture loadgame_active;
    private Texture newgame_active;
    private Texture loadgame_inactive;
    private Texture newgame_inactive;
    private Texture back_inactive;
    private Texture back_active;
    private Texture Andrew_Tate;
    private Texture Tank_load;
    TankWar game;
    public StartGameScreen(TankWar game){
        this.game=game;
        this.loadgame_active=new Texture("loadgame_active.png");
        this.loadgame_inactive=new Texture("loadgame_inactive.png");
        this.newgame_active=new Texture("newgame_active.png");
        this.newgame_inactive=new Texture("newgame_inactive.png");
        this.back_active=new Texture("back_active.png");
        this.back_inactive=new Texture("back_inactive.png");
        this.Tank_load=new Texture("tank_load_screen.jpg");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.5f,0.5f,0.5f,0);
        game.batch.begin();
        game.batch.draw(Tank_load,0,0,1600,900);
        game.batch.draw(back_inactive,(1600-150)/2,(900-450)/2,100,45);



        if(Gdx.input.getX()<(1600-150)/2+170&&Gdx.input.getX()>(1600-170)/2&&TankWar.y-Gdx.input.getY()<450+170&&TankWar.y-Gdx.input.getY()>450+100){
            game.batch.draw(newgame_active,(1600-150)/2,(900)/2,170,45);
            if(Gdx.input.isTouched()){
                game.setScreen(new BUFFERSCREEN(new SelectTankScreen(game),game));
            }
        }
        else{
            game.batch.draw(newgame_inactive,(1600-150)/2,(900)/2,170,45);

        }
        if(Gdx.input.getX()<(1600-150)/2+170&&Gdx.input.getX()>(1600-170)/2&&TankWar.y-Gdx.input.getY()<450+70&&TankWar.y-Gdx.input.getY()>450+20) {
            game.batch.draw(loadgame_active,(1600-150)/2,(900-200)/2,175,45);
        }
        else{
            game.batch.draw(loadgame_inactive,(1600-150)/2,(900-200)/2,175,45);
        }

        if(Gdx.input.getX()<(1600-150)/2+100&&Gdx.input.getX()>(1600-170)/2&&TankWar.y-Gdx.input.getY()<450-45&&TankWar.y-Gdx.input.getY()>450-115) {
            game.batch.draw(back_active,(1600-150)/2,(900-450)/2,100,45);
            if(Gdx.input.isTouched()){
                game.setScreen(new BUFFERSCREEN(new MainMenuScreen(game),game));
            }
        }
        else {
            game.batch.draw(back_inactive,(1600-150)/2,(900-450)/2,100,45);
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
