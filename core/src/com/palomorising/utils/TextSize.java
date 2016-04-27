package com.palomorising.utils;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class TextSize {
    private GlyphLayout layout;

    public TextSize(BitmapFont font, String text) {
        this.layout = new GlyphLayout();
        layout.setText(font, text);
    }

    public float getHeight() {

        return layout.height;
    }

    public float getWidth() {
        return layout.width;
    }
}
