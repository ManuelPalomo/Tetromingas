package com.palomorising.board;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.palomorising.screens.TetroMingasGame;
import com.palomorising.shapes.Shape;
import com.palomorising.shapes.ShapeFactory;
import com.palomorising.utils.Constants;

public class Board {
    private int[][] grid;

    private ShapeFactory shapeFactory;
    private Shape currentShape;

    private TetroMingasGame game;

    private Texture cell;
    private Texture empty;


    public Board(TetroMingasGame game) {
        grid = new int[16][10];

        shapeFactory = new ShapeFactory();
        currentShape = shapeFactory.getShape();

        this.game = game;

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
        if(!isGoingToCollide()) {
            currentShape.updateLeftCorner(currentShape.getUpperLeftCornerX(), currentShape.getUpperLeftCornerY() - 1);
        }else{
            addCurrentPieceToBoard();
            checkFilledLines();
            if(isGameLost()){
                game.endScreen();
                this.dispose();
            }
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

    private void checkFilledLines(){
        for(int x=0;x<grid.length;x++){
            boolean isFilled=true;
            for(int y=0;y<grid[x].length;y++){
                if(grid[x][y]==0){
                    isFilled=false;
                    break;
                }
            }

            if(isFilled){
                removeFilledLine(x);
                checkFilledLines();
            }
        }

    }

    private void removeFilledLine(int x){
        for(int lines=x;lines<grid.length-1;lines++){
            grid[lines]=grid[lines+1];
        }
        grid[grid.length-1] = new int[grid[x].length];

    }

    private boolean isGameLost(){
        for(int x=0; x<grid[15].length;x++){
            if(grid[15][x]==1){
                return true;
            }
        }
        return false;
    }

    private boolean isGoingToCollideMovement(int xIncrement) {
        int nextUpperLeftCornerX = currentShape.getUpperLeftCornerX()+xIncrement;
        int nextUpperLeftCornerY = currentShape.getUpperLeftCornerY();

        int[][] shape = currentShape.getShape();

        for (int x = 0; x < shape.length; x++) {
            for (int y = 0; y < shape[x].length; y++) {
                if (shape[x][y] == 1) {
                    if (nextUpperLeftCornerX+y<0 || nextUpperLeftCornerX+y>=grid[0].length || grid[nextUpperLeftCornerY-x][nextUpperLeftCornerX+y]==1) {
                        return true;

                    }
                }
            }
        }
        return false;
    }

    private boolean isGoingToCollideRotation(){
        int nextUpperLeftCornerX = currentShape.getUpperLeftCornerX();
        int nextUpperLeftCornerY = currentShape.getUpperLeftCornerY();

        int[][] shape = currentShape.getNextTurnShape();

        for (int x = 0; x < shape.length; x++) {
            for (int y = 0; y < shape[x].length; y++) {
                if (shape[x][y] == 1) {
                    if (nextUpperLeftCornerX + y < 0 || nextUpperLeftCornerX + y >= grid[0].length || grid[nextUpperLeftCornerY - x][nextUpperLeftCornerX + y] == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }



    public void moveRight(){
        if(!isGoingToCollideMovement(1)){
            currentShape.updateLeftCorner(currentShape.getUpperLeftCornerX()+1,currentShape.getUpperLeftCornerY());
        }
    }

    public void moveLeft(){
        if(!isGoingToCollideMovement(-1)){
            currentShape.updateLeftCorner(currentShape.getUpperLeftCornerX()-1,currentShape.getUpperLeftCornerY());
        }
    }

    public void moveDown(){
        if(!isGoingToCollide()){
            currentShape.updateLeftCorner(currentShape.getUpperLeftCornerX(),currentShape.getUpperLeftCornerY()-1);
        }
    }

    public void rotateShape(){
        if(!isGoingToCollideRotation()) {
            currentShape.setNextShape();
        }
    }

    public void dispose() {
        cell.dispose();
        empty.dispose();
    }

}
