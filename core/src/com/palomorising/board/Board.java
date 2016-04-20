package com.palomorising.board;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.palomorising.TetroMingas;

public class Board {
    private int[][] grid;
    private Texture cell;

    public Board() {
        grid = new int[16][10];
        cell = new Texture("testCell.png");

    }

    public void render(SpriteBatch batch) {
        int cellHeight = TetroMingas.HEIGHT / 16;
        int cellWidth = TetroMingas.WIDTH / 10;

        int xPos = 0;
        int yPos = 0;

        batch.begin();
        for (int[] x : grid){
            for (int y : x) {
                batch.draw(cell,xPos,yPos);
                xPos+=cellWidth;
            }
            yPos+=cellHeight;
            xPos=0;
        }
        batch.end();


    }

    public void update(float deltaTime) {
    }


}
