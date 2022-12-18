package Screens;


import Helpers.Listner;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntMap;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.TankWar;
import Object.Tank;
import Object.*;

public class Gamescreen implements Screen {
    public TankWar game;
    private Texture GAMEBACKGROUND;
    private Music music;
    private Texture Player1_health;
    private Texture Player2_health;
    private Texture Player1_fuel;
    private Texture Player2_fuel;
    private Tank p1;
    private Tank p2;
    boolean chance=false;
    public static final float Max_Strength=15;
    public static final float Max_Distance=800;
    public static final float Max_Height=800;
    public static final float UPPER_ANGLE=3* MathUtils.PI/2f;
    public static final float LOWER_ANGLE=MathUtils.PI/2f;
    public final Vector2 firing_position;
    public final Vector2 anchor;
    public float distance;
    public float angle;
    public Destructable_Objects ok;
    Fixture f;
    public Gamescreen(TankWar tank) {
        this.game=tank;
        p1=new Tank(this.game);
        anchor=new Vector2(p1.getPlayer().getPosition().x,p1.getPlayer().getPosition().y);
        firing_position=anchor.cpy();
        this.GAMEBACKGROUND= new Texture("Asset_4_2.png");
        this.music= Gdx.audio.newMusic(Gdx.files.internal( "nsong.mp3"));
        this.Player1_health=new Texture("Health_Bar.png");
        this.Player2_health=new Texture("Health_Bar.png");
        this.Player1_fuel=new Texture("Fuel.png");
        this.Player2_fuel=new Texture("Fuel.png");
        game.tiledMap=new TmxMapLoader().load("map.tmx");
        game.tiledMapRenderer=new OrthogonalTiledMapRenderer(tank.tiledMap,1/4f);
        game.cam=new OrthographicCamera();
        game.cam.setToOrtho(false,800/4f,800/4f);

    }
    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        update(Gdx.graphics.getDeltaTime());
        ScreenUtils.clear(0, 0, 0, 0);
        game.tiledMapRenderer.setView(game.cam);
        game.cam.update();
        game.tiledMapRenderer.render();
        game.batch.begin();
        game.batch.draw(game.getTank1(),p1.getPlayer().getPosition().x-(8/2f),p1.getPlayer().getPosition().y-(8/2f),8,8);
        game.batch.end();
//        ScreenUtils.clear(0, 0, 0, 0.5f);
//        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
//            music.play();
//            music.setVolume(0.5f);
//
//        }
//        if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
//            music.stop();
//
//        }
//        game.batch.begin();
//        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
//            game.setScreen(new BUFFERSCREEN(new inGameClass(game),game));
//        }
//        game.batch.draw(GAMEBACKGROUND, 0,0,1600,900);
//        game.batch.draw(game.getTank1(),0,(305),100,100);
//        game.batch.draw(game.getTank2(),990,350,100,100);
//        game.batch.draw(Player1_health,0,770,200,30);
//        game.batch.draw(Player1_fuel,0,750,100,20);
//        game.batch.draw(Player2_fuel,1340,750,100,20);
//        game.batch.draw(Player2_health,1250,770,200,30);
//        game.batch.end();

//     try{
//         for(Fixture fixture:game.Bulletdestroy){
//             if(((BULLETS)fixture.getUserData()).C){
//                 game.world.destroyBody(fixture.getBody());
//                 game.Bulletdestroy.removeValue(fixture,true);
//             }
//         }
//     }
//     catch (Exception e){
//         System.out.println(e);
//     }


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
    public void update(float delta){
        game.world.step(1/60f,6,2);
        game.batch.setProjectionMatrix(game.cam.combined);

    }
    public void input_update(float delta,boolean chance,Tank p1){

        Tank current=p1;
//        if(!chance){
//            current=p1;
//            chance=!chance;
//        }
//        else{
//            current=p2;
//            chance=!chance;
//        }
        int vertical_force=0;
        int horizontal_force=0;
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            horizontal_force-=1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            horizontal_force+=1;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            vertical_force+=1;
        }
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            BULLETS x=new BULLETS(game,p1);
        }
        current.getPlayer().setLinearVelocity(horizontal_force*100,vertical_force*50);


    }

    public Tank getP1() {
        return p1;
    }

    public Tank getP2() {
        return p2;
    }
    private float anglebetweentwopoints(){
        float angle=MathUtils.atan2(anchor.y-firing_position.y,anchor.x-firing_position.x);
        angle%=2*MathUtils.PI;
        if(angle<0)angle+=2*MathUtils.PI2;
        return angle;

    }
    private float distancebetweentwopoints(){
        return(float) Math.sqrt((anchor.x-firing_position.x)*(anchor.x-firing_position.x)+(anchor.y-firing_position.y)*(anchor.y-firing_position.y));

    }
    private void CalculateAngleANDdistanceforbullet(int x,int y){
        firing_position.set(x,y);
        distance=distancebetweentwopoints();
        angle=anglebetweentwopoints();
        if(distance>Max_Distance){
            distance=Max_Distance;
        }
        if(angle>LOWER_ANGLE){
            if(angle>UPPER_ANGLE){
                angle=0;
            }
            else{
                angle=LOWER_ANGLE;
            }
        }
        firing_position.set(anchor.x+(distance*-MathUtils.cos(angle)),anchor.y+(distance*-MathUtils.sin(angle)));
    }
    public void destroy(){

    }
}
