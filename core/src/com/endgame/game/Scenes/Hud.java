package com.endgame.game.Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.endgame.game.MarioBros;

import java.awt.*;
import java.util.logging.Level;


public class Hud {
    public Stage stage;
    private Viewport viewport;

    private  Integer worldTimer;
    private float timecount;
    private Integer score;

    Label countdownLabel;
    Label scoreLabel;
    Label timeLabel;
    Label levelLabel;
    Label worldLable;
    Label marioLable;

    public Hud(SpriteBatch sb){
        worldTimer = 300;
        timecount =0;
        score = 0;

        viewport = new FitViewport(MarioBros.V_WIDTH,MarioBros.V_HEIGHT,new OrthographicCamera());
        stage = new Stage(viewport,sb);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        countdownLabel = new Label(String.format("%03d",worldTimer),new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreLabel = new Label(String.format("%06d",score),new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        timeLabel = new Label("TIME",new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        levelLabel = new Label("1-1",new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        worldLable = new Label("WORLD",new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        marioLable = new Label("MARIO",new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(marioLable).expandX().padTop(10);
        table.add(worldLable).expandX().padTop(10);
        table.add(timeLabel).expandX().padTop(10);
        table.row();
        table.add(scoreLabel).expandX();
        table.add(levelLabel).expandX();
        table.add(countdownLabel).expandX();

        stage.addActor(table);


    }
}

