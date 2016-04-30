package com.palomorising.utils;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;
import java.util.Map;

public class AssetManager {
    private HashMap<String, Texture> textures;
    private HashMap<String, Sound> sounds;

    public AssetManager() {
        textures = new HashMap<String, Texture>();
        sounds = new HashMap<String, Sound>();
        loadTextures();
        loadSounds();
    }

    private void loadTextures() {
        textures.put("1", new Texture("orangeCell.png"));
        textures.put("2", new Texture("redCell.png"));
        textures.put("3", new Texture("blueCell.png"));
        textures.put("4", new Texture("purpleCell.png"));
        textures.put("5", new Texture("greenCell.png"));
        textures.put("6", new Texture("yellowCell.png"));
        textures.put("7", new Texture("yellowCell.png"));
        textures.put("emptyCell", new Texture("emptyCell.png"));
        textures.put("splash", new Texture("splash.png"));
        textures.put("gameOver", new Texture("gameOver.png"));
    }

    private void loadSounds() {
        sounds.put("movement", Gdx.audio.newSound(Gdx.files.internal("movement.mp3")));
        sounds.put("removeLine", Gdx.audio.newSound(Gdx.files.internal("removeLine.mp3")));
    }

    public Texture getTexture(String key) {
        return textures.get(key);
    }

    public Sound getSound(String key) {
        return sounds.get(key);
    }

    public void dispose() {
        for (Map.Entry<String, Texture> entry : textures.entrySet()) {
            entry.getValue().dispose();
        }

        for (Map.Entry<String, Sound> entry : sounds.entrySet()) {
            entry.getValue().dispose();
        }

    }
}
