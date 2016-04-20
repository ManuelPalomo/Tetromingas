package com.palomorising.utils;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class Utils {

    public static float[] getTextSize(BitmapFont font,String text){
        GlyphLayout layout = new GlyphLayout();
        layout.setText(font,text);
        return new float[]{layout.width,layout.height};
    }
}
