package com.endgame.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.endgame.game.MarioBros;
import com.endgame.game.Scenes.Hud;

public class PlayScreen implements Screen {
    private MarioBros game;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Hud hud;

    private TmxMapLoader maploader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    //Box2d
    private World world;
    private Box2DDebugRenderer b2dr;


    public PlayScreen(MarioBros game){
        this.game = game;
        camera = new OrthographicCamera();
        viewport = new FitViewport(MarioBros.V_WIDTH,MarioBros.V_HEIGHT,camera);
        hud = new Hud(game.batch);
        maploader = new TmxMapLoader();
        map = maploader.load("files/map.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        // initially set camera to be centered
        camera.position.set(viewport.getWorldWidth()/2,viewport.getWorldHeight()/2,0);
        world = new World(new Vector2(0,0),true);
        b2dr = new Box2DDebugRenderer();

        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        for(MapObject object : map.getLayers().get(2).getObjects());
    }
    public  void handleInput(float dt){
        if(Gdx.input.isTouched()) camera.position.y += 100*dt;
    }
    public  void update(float dt){
        handleInput(dt);
        camera.update();
        renderer.setView(camera);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.render();

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height);
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
