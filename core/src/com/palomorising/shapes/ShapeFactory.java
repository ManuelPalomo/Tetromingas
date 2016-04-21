package com.palomorising.shapes;

import com.badlogic.gdx.math.MathUtils;

import java.util.ArrayList;
import java.util.LinkedList;

public class ShapeFactory {
    private ArrayList<int[][]> shapes;
    private LinkedList<LinkedList<int[][]>> turnShapes;

    public ShapeFactory() {
        this.shapes=fillShapes();
        this.turnShapes=new LinkedList<LinkedList<int[][]>>();
    }

    public Shape getShape(){
        return new Shape(1,1, shapes.get(MathUtils.random(0,shapes.size()-1)),null);
    }

    private ArrayList<int[][]> fillShapes() {
        ArrayList<int[][]> shapes = new ArrayList<int[][]>();
        int[][] line = {
                {0,0,0,0},
                {1,1,1,1},
                {0,0,0,0},
                {0,0,0,0}
        };
        shapes.add(line);

        int[][] lPiece ={
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        shapes.add(lPiece);

        int[][] jPiece={
                {1,0,0},
                {1,1,1},
                {0,0,0}
        };
        shapes.add(jPiece);

        int[][] squarePiece={
                {1,1},
                {1,1},
        };
        shapes.add(squarePiece);

        int[][] sPiece={
                {0,1,1},
                {1,1,0},
                {0,0,0}
        };
        shapes.add(sPiece);

        int[][] tPiece={
                {0,1,0},
                {1,1,1},
                {0,0,0}
        };
        shapes.add(tPiece);

        int[][] zPiece={
                {1,1,0},
                {0,1,1},
                {0,0,0}
        };
        shapes.add(zPiece);

        return shapes;
    }
}
