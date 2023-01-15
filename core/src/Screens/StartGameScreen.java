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
        game.batch.draw(Tank_load,0,0,800,800);
        game.batch.draw(back_inactive,400-(100/2f),(200-50/2f),100,50);
        if(Gdx.input.getX()<(400+(100/2f))&&Gdx.input.getX()>(400-(100/2f))&&800-Gdx.input.getY()<(200+(50/2f))&&800-Gdx.input.getY()>(200-(50/2f))) {
            game.batch.draw(back_active,400-(100/2f),(200-50/2f),100,50);
            if(Gdx.input.isTouched()){
                game.setScreen(new BUFFERSCREEN(new MainMenuScreen(game),game));
            }
        }


        if(Gdx.input.getX()<(400+(150/2f))&&Gdx.input.getX()>(400-(150/2f))&&800-Gdx.input.getY()<500+(70/2f)&&800-Gdx.input.getY()>(500-(70/2f))){
            game.batch.draw(newgame_active,400-(100/2f),500-(70/2f),150,60);
            if(Gdx.input.isTouched()){
                game.setScreen(new BUFFERSCREEN(new SelectTankScreen(game),game));
            }
        }
        else{
            game.batch.draw(newgame_inactive,400-(100/2f),500-(70/2f),150,60);

        }
        if(Gdx.input.getX()<(400+(150/2f))&&Gdx.input.getX()>(400-(150/2f))&&800-Gdx.input.getY()<350+(45/2f)&&800-Gdx.input.getY()>350-(45/2f)) {
            game.batch.draw(loadgame_active,400-(150/2f),(350-45/2f),150,45);
        }
        else{
            game.batch.draw(loadgame_inactive,400-(150/2f),(350-(45/2f)),150,45);
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
