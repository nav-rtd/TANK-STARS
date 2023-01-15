package Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.TankWar;

import java.util.PriorityQueue;

public class PLAYERVERSUSSCREEN implements Screen {
    TankWar game;
    private Texture versus;
    private Texture back_active;
    private Texture back_inactive;
    private Texture Start_game_active;
    private Texture Start_game_inactive;
    private Texture player_1;
    private Texture player_2;
    public PLAYERVERSUSSCREEN(TankWar game){
        this.versus=new Texture("VS.png");
        this.back_inactive=new Texture("back_inactive.png");
        this.back_active=new Texture("back_active.png");
        this.player_1=new Texture("PLAYER_1.png");
        this.player_2=new Texture("PLAYER_2.png");
        this.Start_game_active=new Texture("start_game.png");
        this.Start_game_inactive=new Texture("start_game_inactive.png");
        this.game=game;

    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0.1f,0);
        game.batch.begin();
        if(Gdx.input.getX()<(400+(50/2f))&&Gdx.input.getX()>(400-(50/2f))/2&&800-Gdx.input.getY()<(200+(25/2f))&&TankWar.y-Gdx.input.getY()>200-(25/2f)) {
            game.batch.draw(back_active,400-(50/2f),(200-25/2f),50,25);
            if(Gdx.input.isTouched()){
                game.setScreen(new BUFFERSCREEN(new SelectTankScreenP2(game),game));
            }
        }

        else {
            game.batch.draw(back_inactive,400-(50/2f),(200-25/2f),50,25);;
        }
        if(Gdx.input.getX()<400+(100/2f)&&Gdx.input.getX()>((400-(100/2f)))&&800-Gdx.input.getY()<600+(50/2f)&&800-Gdx.input.getY()>600-(50/2f)){
            game.batch.draw(Start_game_active,400-(100/2f),600-(50/2f),100,50);
            if(Gdx.input.isTouched()){
                game.setScreen(new Gamescreen(game));
            }

        }
        else{
            game.batch.draw(Start_game_inactive,400-(100/2f),600-(50/2f),100,50);
        }
        game.batch.draw(versus,(400)-90/2f,(400-40/2f),90,40);
        game.batch.draw(player_1,(300-(100/2f)),400-(20/2f),100,20);
        game.batch.draw(player_2,(500-(100/2f)),400-(20/2f),100,20);
        game.batch.draw(game.getTank1(),(300-(100/2f)),(250-(100/2f)),100,100);
        game.batch.draw(game.getTank2(),(500-(100/2f)),(250-(100/2f)),100,100);
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
