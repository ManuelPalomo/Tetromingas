package com.palomorising.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.palomorising.TetroMingas;
import com.palomorising.utils.Constants;

public class MainMenu extends ScreenAdapter {
    final TetroMingas game;
    private OrthographicCamera camera;
    private Texture splash = new Texture("splash.png");


    public MainMenu(TetroMingas game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Constants.WIDTH, Constants.HEIGHT);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(splash,0,0);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new TetroMingasGame(game));
            this.dispose();
        }

    }

    @Override
    public void dispose(){
        splash.dispose();
    }
}
