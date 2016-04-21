package com.palomorising;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.palomorising.screens.MainMenu;

public class TetroMingas extends Game {
    public SpriteBatch batch;
    public BitmapFont font;

	@Override
	public void create () {
		batch = new SpriteBatch();
        font = new BitmapFont();
        this.setScreen(new MainMenu(this));
	}

    @Override
    public void dispose(){
        batch.dispose();
        font.dispose();
    }
}
