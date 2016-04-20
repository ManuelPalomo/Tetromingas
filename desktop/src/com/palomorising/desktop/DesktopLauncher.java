package com.palomorising.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.palomorising.TetroMingas;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title="TetroMingas";
        config.width=TetroMingas.WIDTH;
        config.height=TetroMingas.HEIGHT;
		new LwjglApplication(new TetroMingas(), config);
	}
}
