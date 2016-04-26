package com.palomorising.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.palomorising.TetroMingas;
import com.palomorising.board.Board;
import com.palomorising.input.GameInputHandler;
import com.palomorising.utils.Constants;


public class TetroMingasGame extends ScreenAdapter {
    final TetroMingas game;
    private OrthographicCamera camera;
    private Board board;
    private float updateTimer;
    private GameInputHandler inputHandler;

    public TetroMingasGame(TetroMingas game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Constants.WIDTH, Constants.HEIGHT);

        board = new Board();

        inputHandler = new GameInputHandler(board);
        Gdx.input.setInputProcessor(inputHandler);
    }



    @Override
    public void render(float delta) {
        updateTimer += delta;

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        if (updateTimer >= 0.5f) {
            board.update();
            updateTimer -= 0.5f;
        }

        board.render(game.batch);

    }


    @Override
    public void dispose() {
        board.dispose();

    }
}
