package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.TankWar;

public class BUFFERSCREEN implements Screen {
    TankWar game;
    private Screen screen;
    public BUFFERSCREEN(Screen screen,TankWar game){
        this.screen=screen;
        this.game=game;
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.5f,0.5f,0.5f,0);
        if(Gdx.input.isTouched()){
            for(int i=0;i<1000;i++){
                for(int j=0;j<1000;j++);
            }
        }
        game.setScreen(screen);

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
