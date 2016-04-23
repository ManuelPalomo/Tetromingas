package com.palomorising.shapes;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.palomorising.utils.Constants;

import java.util.LinkedList;

public class Shape {
    private int upperLeftCornerX;
    private int upperLeftCornerY;
    private int[][] shape;
    private LinkedList<int[][]> turnShapes;
    private int actualTurnShape;

    public Shape(int upperLeftCornerX, int upperLeftCornerY, int[][] shape, LinkedList<int[][]> turnShapes) {
        this.upperLeftCornerX = upperLeftCornerX;
        this.upperLeftCornerY = upperLeftCornerY;
        this.shape = shape;
        this.turnShapes = turnShapes;
        this.actualTurnShape = 0;
    }

    public int[][] getNextTurnShape() {
        int nextShape=actualTurnShape+1;
        if (nextShape > turnShapes.size()-1) {
            nextShape = 0;
        }
        return turnShapes.get(nextShape);
    }

    public int getUpperLeftCornerX() {
        return upperLeftCornerX;
    }

    public int getUpperLeftCornerY() {
        return upperLeftCornerY;
    }

    public int[][] getShape() {
        return shape;
    }

    public void updateLeftCorner(int upperLeftCornerX, int upperLeftCornerY) {
        this.upperLeftCornerX = upperLeftCornerX;
        this.upperLeftCornerY = upperLeftCornerY;
    }

    public void renderShape(SpriteBatch batch, Texture cell) {
        int xPos = upperLeftCornerX * Constants.CELL_WIDTH;
        int yPos = upperLeftCornerY * Constants.CELL_HEIGHT;

        for (int x = 0; x < shape.length; x++) {
            for (int y = 0; y < shape[x].length; y++) {
                if (shape[x][y] == 1) {
                    batch.draw(cell, xPos, yPos);
                }
                xPos += Constants.CELL_WIDTH;
            }
            yPos -= Constants.CELL_HEIGHT;
            xPos = upperLeftCornerX * Constants.CELL_WIDTH;
        }
    }

    public void setNextShape() {
        actualTurnShape++;
        if (actualTurnShape > turnShapes.size()-1) {
            actualTurnShape = 0;
        }
        this.shape=turnShapes.get(actualTurnShape);
    }

}
