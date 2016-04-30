package com.palomorising.shapes;

import com.badlogic.gdx.math.MathUtils;

import java.util.ArrayList;
import java.util.LinkedList;

public class ShapeFactory {
    private ArrayList<int[][]> shapes;
    private LinkedList<LinkedList<int[][]>> turnShapes;

    public ShapeFactory() {
        this.shapes=new ArrayList<int[][]>();
        this.turnShapes=new LinkedList<LinkedList<int[][]>>();
        fillShapes();
    }

    public Shape getShape(){
        int randomIndex=MathUtils.random(0,shapes.size()-1);
        return new Shape(4,15, shapes.get(randomIndex),turnShapes.get(randomIndex),randomIndex+1);
    }

    private void fillShapes() {
        LinkedList<int[][]> lineRotations = new LinkedList<int[][]>();
        int[][] line = {
                {0,0,0,0},
                {1,1,1,1},
                {0,0,0,0},
                {0,0,0,0}
        };
        shapes.add(line);
        lineRotations.add(line);

        int[][] lineRotated= {
                {0,1,0,0},
                {0,1,0,0},
                {0,1,0,0},
                {0,1,0,0}
        };
        lineRotations.add(lineRotated);
        turnShapes.add(lineRotations);


        LinkedList<int[][]> lPieceRotations = new LinkedList<int[][]>();
        int[][] lPiece ={
                {0,0,2},
                {2,2,2},
                {0,0,0}
        };
        shapes.add(lPiece);
        lPieceRotations.add(lPiece);

        int[][] lPieceRotationOne ={
                {0,2,0},
                {0,2,0},
                {0,2,2}
        };
        lPieceRotations.add(lPieceRotationOne);
        int[][] lPieceRotationTwo ={
                {0,0,0},
                {2,2,2},
                {2,0,0}
        };
        lPieceRotations.add(lPieceRotationTwo);
        int[][] lPieceRotationThree ={
                {2,2,0},
                {0,2,0},
                {0,2,0}
        };
        lPieceRotations.add(lPieceRotationThree);
        turnShapes.add(lPieceRotations);


        LinkedList<int[][]> jPieceRotations = new LinkedList<int[][]>();
        int[][] jPiece={
                {3,0,0},
                {3,3,3},
                {0,0,0}
        };
        shapes.add(jPiece);
        jPieceRotations.add(jPiece);

        int[][] jPieceRotationOne={
                {0,3,3},
                {0,3,0},
                {0,3,0}
        };
        jPieceRotations.add(jPieceRotationOne);
        int[][] jPieceRotationTwo={
                {0,0,0},
                {3,3,3},
                {0,0,3}
        };
        jPieceRotations.add(jPieceRotationTwo);
        int[][] jPieceRotationThree={
                {0,3,0},
                {0,3,0},
                {3,3,0}
        };
        jPieceRotations.add(jPieceRotationThree);
        turnShapes.add(jPieceRotations);


        LinkedList<int[][]> squarePieceRotations = new LinkedList<int[][]>();
        int[][] squarePiece={
                {4,4},
                {4,4},
        };
        shapes.add(squarePiece);
        squarePieceRotations.add(squarePiece);
        turnShapes.add(squarePieceRotations);

        LinkedList<int[][]> sPieceRotations = new LinkedList<int[][]>();

        int[][] sPiece={
                {0,5,5},
                {5,5,0},
                {0,0,0}
        };
        shapes.add(sPiece);
        sPieceRotations.add(sPiece);
        int[][] sPieceRotationOne={
                {0,5,0},
                {0,5,5},
                {0,0,5}
        };
        sPieceRotations.add(sPieceRotationOne);
        int[][] sPieceRotationTwo={
                {0,0,0},
                {0,5,5},
                {5,5,0}
        };
        sPieceRotations.add(sPieceRotationTwo);
        int[][] sPieceRotationThree={
                {5,0,0},
                {5,5,0},
                {0,5,0}
        };
        sPieceRotations.add(sPieceRotationThree);
        turnShapes.add(sPieceRotations);


        LinkedList<int[][]> tPieceRotations = new LinkedList<int[][]>();
        int[][] tPiece={
                {0,6,0},
                {6,6,6},
                {0,0,0}
        };
        shapes.add(tPiece);
        tPieceRotations.add(tPiece);

        int[][] tPieceRotationOne={
                {0,6,0},
                {0,6,6},
                {0,6,0}
        };
        tPieceRotations.add(tPieceRotationOne);
        int[][] tPieceRotationTwo={
                {0,0,0},
                {6,6,6},
                {0,6,0}
        };
        tPieceRotations.add(tPieceRotationTwo);
        int[][] tPieceRotationThree={
                {0,6,0},
                {6,6,0},
                {0,6,0}
        };
        tPieceRotations.add(tPieceRotationThree);
        turnShapes.add((tPieceRotations));

        LinkedList<int[][]> zPieceRotations = new LinkedList<int[][]>();
        int[][] zPiece={
                {7,7,0},
                {0,7,7},
                {0,0,0}
        };
        shapes.add(zPiece);
        zPieceRotations.add(zPiece);

        int[][] zPieceRotationOne={
                {0,0,7},
                {0,7,7},
                {0,7,0}
        };
        zPieceRotations.add(zPieceRotationOne);

        int[][] zPieceRotationTwo={
                {0,0,0},
                {0,7,7},
                {7,7,0}
        };
        zPieceRotations.add(zPieceRotationTwo);
        int[][] zPieceRotationThree={
                {0,7,0},
                {7,7,0},
                {7,0,0}
        };
        zPieceRotations.add(zPieceRotationThree);
        turnShapes.add(zPieceRotations);
    }
}
