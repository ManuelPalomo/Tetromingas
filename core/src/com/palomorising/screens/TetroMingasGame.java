package com.palomorising.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.palomorising.TetroMingas;


public class TetroMingasGame implements Screen {
    final TetroMingas game;
    private OrthographicCamera camera;

    public TetroMingasGame(TetroMingas game){
        this.game=game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false,TetroMingas.WIDTH,TetroMingas.HEIGHT);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0.2f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

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
