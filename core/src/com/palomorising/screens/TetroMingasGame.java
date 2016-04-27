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
    private float updateTimerLimit;

    private GameInputHandler inputHandler;

    public TetroMingasGame(TetroMingas game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Constants.WIDTH, Constants.HEIGHT);

        board = new Board(this, game);

        updateTimerLimit=0.5f;

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

        if (updateTimer >= updateTimerLimit) {
            board.update();
            updateTimer -= updateTimerLimit;
        }

        board.render(game.batch);

    }

    public void endScreen(int score,int lines) {
        game.setScreen(new EndScreen(game,score,lines));
        this.dispose();
    }

    @Override
    public void dispose() {
        board.dispose();

    }

    public void setUpdateTimerLimit(float updateTimerLimit){
        this.updateTimerLimit=updateTimerLimit;
    }
}
