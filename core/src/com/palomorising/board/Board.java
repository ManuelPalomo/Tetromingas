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
        empty = new Texture("emptyCell.png");


    }

    public void render(SpriteBatch batch) {
        batch.begin();
        renderBoard(batch);
        currentShape.renderShape(batch, cell);
        batch.end();

    }

    private void renderBoard(SpriteBatch batch) {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] == 1) {
                    batch.draw(cell, y * Constants.CELL_WIDTH, x* Constants.CELL_HEIGHT);
                } else {
                    batch.draw(empty, y * Constants.CELL_WIDTH, x * Constants.CELL_HEIGHT);
                }

            }


        }
    }

    public void update() {
        System.out.println(isGoingToCollide());
        if(!isGoingToCollide()) {
            currentShape.updateLeftCorner(currentShape.getUpperLeftCornerX(), currentShape.getUpperLeftCornerY() - 1);
        }else{
            addCurrentPieceToBoard();
            currentShape=shapeFactory.getShape();
        }
    }

    private boolean isGoingToCollide() {
        int nextUpperLeftCornerX = currentShape.getUpperLeftCornerX();
        int nextUpperLeftCornerY = currentShape.getUpperLeftCornerY() - 1;

        int[][] shape = currentShape.getShape();

        for (int x = 0; x < shape.length; x++) {
            for (int y = 0; y < shape[x].length; y++) {
                if (shape[x][y] == 1) {
                    if (nextUpperLeftCornerY-x<0 || grid[nextUpperLeftCornerY-x][nextUpperLeftCornerX+y]==1) {
                        return true;

                    }
                }
            }
        }
        return false;
    }

    private void addCurrentPieceToBoard(){
        int[][] shape = currentShape.getShape();

        for (int x = 0; x < shape.length; x++) {
            for (int y = 0; y < shape[x].length; y++) {
                if(shape[x][y]==1){
                    grid[currentShape.getUpperLeftCornerY()-x][currentShape.getUpperLeftCornerX()+y]=1;

                }
            }
        }
    }

    public void dispose() {
        cell.dispose();
        empty.dispose();
    }

}
