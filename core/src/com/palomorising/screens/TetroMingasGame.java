package com.palomorising.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.palomorising.TetroMingas;
import com.palomorising.board.Board;
import com.palomorising.utils.Constants;


public class TetroMingasGame implements Screen {
    final TetroMingas game;
    private OrthographicCamera camera;
    private Board board;
    private float updateTimer;
    private float inputTimer;

    public TetroMingasGame(TetroMingas game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Constants.WIDTH, Constants.HEIGHT);

        board = new Board();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        updateTimer += delta;
        inputTimer += delta;

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        if(inputTimer >=0.1f){
            handleInput();
            inputTimer-=0.1f;
        }
        if (updateTimer >= 0.5f) {
            board.update();
            updateTimer -= 0.5f;
        }

        board.render(game.batch);

    }

    private void handleInput(){
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            board.moveRight();
        }

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            board.moveLeft();
        }

        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            board.moveDown();
        }

        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            board.rotateShape();
        }

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
        board.dispose();

    }
}
