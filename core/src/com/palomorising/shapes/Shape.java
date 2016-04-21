package com.palomorising.shapes;


import java.util.LinkedList;

public class Shape {
    private int upperLeftCornerX;
    private int upperLeftCornerY;
    private int[][] shape;
    private LinkedList<int[][]> turnShapes;
    private int actualTurnShape;

    public Shape(int upperLeftCornerX,int upperLeftCornerY,int[][] shape,LinkedList<int[][]> turnShapes){
        this.upperLeftCornerX=upperLeftCornerX;
        this.upperLeftCornerY=upperLeftCornerY;
        this.shape=shape;
        this.turnShapes=turnShapes;
        this.actualTurnShape=0;
    }

    public int[][] getNextTurnShape(){
        if(actualTurnShape+1>turnShapes.size()){
            actualTurnShape=0;
        }
        return turnShapes.get(actualTurnShape);
    }

    public int getUpperLeftCornerX(){
        return upperLeftCornerX;
    }

    public int getUpperLeftCornerY(){
        return upperLeftCornerY;
    }

    public int[][] getShape(){
        return shape;
    }
    public void updateLeftCorner(int upperLeftCornerX,int upperLeftCornerY){
        this.upperLeftCornerX=upperLeftCornerX;
        this.upperLeftCornerY=upperLeftCornerY;
    }

}
