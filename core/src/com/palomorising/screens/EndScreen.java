package com.palomorising.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.palomorising.TetroMingas;
import com.palomorising.utils.Constants;
import com.palomorising.utils.TextSize;

public class EndScreen extends ScreenAdapter {

    private TetroMingas game;

    public EndScreen(TetroMingas game) {
        this.game = game;

    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();

        TextSize textSize = new TextSize(game.font,"You just lost the game");
        game.font.draw(game.batch,"You just lost the game", Constants.WIDTH/2-textSize.getWidth()/2,Constants.HEIGHT/2-textSize.getHeight()/2);

        game.batch.end();
    }
}
