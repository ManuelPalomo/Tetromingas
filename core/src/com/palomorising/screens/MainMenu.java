package com.palomorising.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.palomorising.TetroMingas;
import com.palomorising.utils.Utils;

public class MainMenu implements Screen{
    final TetroMingas game;
    private OrthographicCamera camera;


    public MainMenu(TetroMingas game){
        this.game=game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, TetroMingas.WIDTH,TetroMingas.HEIGHT);

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

        game.batch.begin();

        float[] textSize = Utils.getTextSize(game.font,"TetroMingas");
        game.font.draw(game.batch,"TetroMingas",TetroMingas.WIDTH/2-textSize[0]/2,TetroMingas.HEIGHT/2-textSize[1]/2);
        textSize = Utils.getTextSize(game.font,"Pulsa para jugar");
        game.font.draw(game.batch,"Pulsa para jugar",TetroMingas.WIDTH/2-textSize[0]/2,TetroMingas.HEIGHT/2-textSize[1]/2-30);
        game.batch.end();

        if(Gdx.input.isTouched()){
            game.setScreen(new TetroMingasGame(game));
            dispose();
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



    }
}
