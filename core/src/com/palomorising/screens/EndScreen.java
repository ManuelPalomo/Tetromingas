package com.palomorising.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.palomorising.TetroMingas;
import com.palomorising.utils.Constants;
import com.palomorising.utils.TextSize;

public class EndScreen extends ScreenAdapter {

    private TetroMingas game;
    private int score;
    private int lines;

    public EndScreen(TetroMingas game, int score, int lines) {
        this.game = game;
        this.score = score;
        this.lines = lines;

    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        TextSize textSize = new TextSize(game.font, "Score");
        game.batch.draw(game.assetManager.getTexture("gameOver"), 0, 0);
        game.font.draw(game.batch, "Score: " + score, Constants.WIDTH / 2 - textSize.getWidth() / 2, (Constants.HEIGHT / 2 - textSize.getHeight() / 2) - 20);
        game.font.draw(game.batch, "Lines Cleared: " + lines, Constants.WIDTH / 2 - textSize.getWidth() / 2, (Constants.HEIGHT / 2 - textSize.getHeight() / 2) - 40);
        game.font.draw(game.batch, "Record: " + getRecord(), Constants.WIDTH / 2 - textSize.getWidth() / 2, (Constants.HEIGHT / 2 - textSize.getHeight() / 2) - 60);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new MainMenu(game));
            this.dispose();
        }
    }

    private int getRecord() {
        Preferences prefs = Gdx.app.getPreferences("preferences");
        int previousHighScore = prefs.getInteger("highScore");
        if (score > previousHighScore) {
            prefs.putInteger("highScore", score);
            prefs.flush();
            return score;
        } else {
            return previousHighScore;
        }

    }

}
