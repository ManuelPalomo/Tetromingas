package com.palomorising.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.palomorising.TetroMingas;
import com.palomorising.utils.Constants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title="TetroMingas";
        config.width= Constants.WIDTH;
        config.height=Constants.HEIGHT;
		new LwjglApplication(new TetroMingas(), config);
	}
}
