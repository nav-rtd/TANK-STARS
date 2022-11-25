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
        if(Gdx.input.getX()<(1600-150)/2+100&&Gdx.input.getX()>(1600-170)/2&&TankWar.y-Gdx.input.getY()<200+25&&TankWar.y-Gdx.input.getY()>200-30) {
            game.batch.draw(back_active, (1600 - 150 - 50) / 2, 65, 100, 25);
            if(Gdx.input.isTouched()){
                game.setScreen(new SelectTankScreenP2(game));
            }
        }
        else{
            game.batch.draw(back_inactive, (1600 - 150 - 50) / 2, 65, 100, 25);
        }
        if(Gdx.input.getX()<(1600/2)+70&&Gdx.input.getX()>(1600/2)-(300/2)&&TankWar.y-Gdx.input.getY()<800+40&&TankWar.y-Gdx.input.getY()>800){
            game.batch.draw(Start_game_active,(1600/2)-(300/2),700,220,20);
            if(Gdx.input.isTouched()){
                game.setScreen(new Gamescreen(game));
            }

        }
        else{
            game.batch.draw(Start_game_inactive,(1600/2)-(300/2),700,220,20);
        }
        game.batch.draw(versus,(1600)/2-100,(900)/2,90,40);
        game.batch.draw(player_1,(1600)/2-400,400+200,200,35);
        game.batch.draw(player_2,(1600)/2+100,400+200,200,35);
        game.batch.draw(game.getTank1(),(1600/2)-400,400,200,200);
        game.batch.draw(game.getTank2(),(1600/2)+100,400,200,200);
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
