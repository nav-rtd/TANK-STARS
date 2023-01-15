package Screens;


import Helpers.Listner;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
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
    private Array<Tank> delete_tenk=new Array<Tank>();
    boolean chance=false;
    public static final float Max_Strength=15;
    public static final float Max_Distance=800;
    public static final float Max_Height=800;
    public static final float UPPER_ANGLE=3* MathUtils.PI/2f;
    public static final float LOWER_ANGLE=MathUtils.PI/2f;
//    public final Vector2 firing_position;
//    public final Vector2 anchor;
    public float distance;
    public float angle;
    public Destructable_Objects ok;
    private Tank delete_tank;
    Fixture f;
    ContactListener cListner;
    Tank current;
    public Gamescreen(TankWar tank) {
        this.game=tank;
        p1=new Tank(this.game,300,500,"P1");
        p2=new Tank(this.game,600,600,"P2");
//        p2=new Tank2(this.game,400,500,"P2");
//        anchor=new Vector2(p1.getPlayer().getPosition().x,p1.getPlayer().getPosition().y);
//        firing_position=anchor.cpy();
        this.GAMEBACKGROUND= new Texture("Asset_4_2.png");
        this.music= Gdx.audio.newMusic(Gdx.files.internal( "nsong.mp3"));
        this.Player1_health=new Texture("Health_Bar.png");
        this.Player2_health=new Texture("Health_Bar.png");
        this.Player1_fuel=new Texture("Fuel.png");
        this.Player2_fuel=new Texture("Fuel.png");
        game.tiledMap=new TmxMapLoader().load("untitled.tmx");
        game.tiledMapRenderer=new OrthogonalTiledMapRenderer(tank.tiledMap,1/4f);
        game.cam=new OrthographicCamera();
        game.world.setContactListener(new Listner(this.game));
        game.cam.setToOrtho(false,800/4f,800/4f);
//        Terrain ter=new Terrain(game.tiledMap,game.world,this.game);
        PolylineObjects polylineObjects=new PolylineObjects(this.game);
        polylineObjects.makeobject();


    }
    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        update(Gdx.graphics.getDeltaTime());
        game.tiledMapRenderer.setView(game.cam);
        ScreenUtils.clear(0, 0, 0, 0);
        game.cam.update();
        input_update(delta);
        game.tiledMapRenderer.render();
        game.box2DDebugRenderer.render(game.world,game.cam.combined);
        game.batch.begin();
        if(this.p1.getHealth()<=0){

            game.cam.setToOrtho(false,800,800);
            game.batch.setProjectionMatrix(game.cam.combined);
//
            delete_tenk.add(p1);
            delete_tenk.add(p2);
            game.setScreen(new WinnerScreen(game,p2));
        }
        else if(this.p2.getHealth()<=0){
            game.cam.setToOrtho(false,800,800);
            game.batch.setProjectionMatrix(game.cam.combined);
            delete_tenk.add(p1);
            delete_tenk.add(p2);
            game.setScreen(new WinnerScreen(game,p1));
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            game.cam.setToOrtho(false,800,800);
            game.batch.setProjectionMatrix(game.cam.combined);
            game.setScreen(new inGameClass(game,this));
        }
        game.batch.draw(game.getTank1(),p1.getPlayer().getPosition().x-(8/2f),p1.getPlayer().getPosition().y-(8/2f),8,8);
        game.batch.draw(game.getTank2(),p2.getPlayer().getPosition().x-(8/2f),p2.getPlayer().getPosition().y-(8/2f),8,8);
        game.batch.draw(Player1_health,0,198,30*(((float)p1.getHealth()/(float) 100f)),5/4f);
        game.batch.draw(Player1_fuel,0,196.5f,10*((float)p1.getFuel()/(float) Tank.MAX_FUEL),5/4f);
        game.batch.draw(Player2_fuel,200,196.5f,-10*((float)p2.getFuel()/(float) Tank.MAX_FUEL),5/4f);
        game.batch.draw(Player2_health,200,198,-30*(((float)p2.getHealth()/(float) 100f)),5/4f);
//        game.batch.draw(Player2_health,200-30,198,30);
        game.batch.end();
//        input_update(delta,true,p1);
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

//        game.batch.draw(Player2_fuel,1340,750,100,20);
//        game.batch.draw(Player2_health,1250,770,200,30);
//        game.batch.end();

     try{
         for(Fixture fixture:game.destroy){
             f=fixture;
             if(((Destructable_Objects)fixture.getUserData()).getCheck()){
                 game.world.destroyBody(fixture.getBody());
                 game.destroy.removeValue(fixture,true);
             }
         }
     }
     catch (Exception e){

         game.destroy.removeValue(f,true);
         System.out.println(e);
     }
     delete_tenk();


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
    public void input_update(float delta){
        int i=1;
        if(game.turn) {
            int vertical_force = 0;
            int horizontal_force = 0;
            if(game.check1) {
                if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && p1.getFuel() > 0) {
                    horizontal_force -= 1;
                    p1.setFuel();
                    vertical_force += 1;
                }
                if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && p1.getFuel() > 0) {
                    horizontal_force += 1;
                    p1.setFuel();
                }

                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    System.out.println(i);
                    p1.SHOOT();
                    System.out.println(game.turn);
                    game.turn=false;
                }
                p1.getPlayer().setLinearVelocity(horizontal_force * 30, 0);
                p2.getPlayer().setLinearVelocity(0,0);
            }

        }
        else if(!game.turn){
            int vertical_force = 0;
            int horizontal_force = 0;
            if(game.check2) {
                if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && p2.getFuel() > 0) {
                    horizontal_force -= 1;
                    this.p2.getFuel();
                    vertical_force += 1;
                }
                if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && p2.getFuel() > 0) {
                    horizontal_force += 1;
                    this.p2.getFuel();
                    vertical_force += 1;
                }

                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    System.out.println(i);
                    this.p2.SHOOT();
                    game.turn = true;
                    System.out.println(game.turn);
                }
                p2.getPlayer().setLinearVelocity(horizontal_force * 30, 0);
                p1.getPlayer().setLinearVelocity(0,0);
            }

        }


    }

    public Tank getP1() {
        return p1;
    }

    public Tank getP2() {
        return p2;
    }

    public void destroy(){

    }
    public void delete_tenk(){
        try{
            for(Tank f:delete_tenk){
                delete_tank=f;
                if(f.getdelete_check()){
                    game.world.destroyBody(f.getPlayer());
                }
            }
        }
        catch(Exception e){
            delete_tenk.removeValue(delete_tank,true);
        }
    }

}