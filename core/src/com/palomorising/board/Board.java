package com.palomorising.board;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.palomorising.shapes.Shape;
import com.palomorising.shapes.ShapeFactory;
import com.palomorising.utils.Constants;

public class Board {
    private int[][] grid;

    private ShapeFactory shapeFactory;
    private Shape currentShape;

    private Texture cell;
    private Texture empty;


    public Board() {
        grid = new int[16][10];

        shapeFactory = new ShapeFactory();
        currentShape = shapeFactory.getShape();

        cell = new Texture("testCell.png");
        empty= new Texture("emptyCell.png");


    }

    public void render(SpriteBatch batch) {
        int xPos = 0;
        int yPos = 0;

        batch.begin();
        for (int[] x : grid){
            for (int y : x) {
                if(y==1) {
                    batch.draw(cell, xPos, yPos);
                }else{
                    batch.draw(empty,xPos,yPos);
                }
                xPos+=Constants.CELL_WIDTH;
            }
            yPos+=Constants.CELL_HEIGHT;
            xPos=0;
        }
        renderShape(batch);
        batch.end();

    }
    private void renderShape(SpriteBatch batch){
        int xPos = currentShape.getUpperLeftCornerX()*Constants.CELL_WIDTH;
        int yPos= Constants.HEIGHT-(currentShape.getUpperLeftCornerY()*Constants.CELL_HEIGHT);

        for (int[] x : currentShape.getShape()) {
            for (int y : x) {
                if (y == 1) {
                    batch.draw(cell, xPos, yPos);
                }
                xPos += Constants.CELL_WIDTH;
            }
            yPos-=Constants.CELL_HEIGHT;
            xPos=currentShape.getUpperLeftCornerX()*Constants.CELL_WIDTH;;

        }
    }

    public void update(float deltaTime) {
    }

    public void dispose(){
        cell.dispose();
        empty.dispose();
    }

}
