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
        return new Shape(4,15, shapes.get(randomIndex),turnShapes.get(randomIndex));
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
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        shapes.add(lPiece);
        lPieceRotations.add(lPiece);

        int[][] lPieceRotationOne ={
                {0,1,0},
                {0,1,0},
                {0,1,1}
        };
        lPieceRotations.add(lPieceRotationOne);
        int[][] lPieceRotationTwo ={
                {0,0,0},
                {1,1,1},
                {1,0,0}
        };
        lPieceRotations.add(lPieceRotationTwo);
        int[][] lPieceRotationThree ={
                {1,1,0},
                {0,1,0},
                {0,1,0}
        };
        lPieceRotations.add(lPieceRotationThree);
        turnShapes.add(lPieceRotations);


        LinkedList<int[][]> jPieceRotations = new LinkedList<int[][]>();
        int[][] jPiece={
                {1,0,0},
                {1,1,1},
                {0,0,0}
        };
        shapes.add(jPiece);
        jPieceRotations.add(jPiece);

        int[][] jPieceRotationOne={
                {0,1,1},
                {0,1,0},
                {0,1,0}
        };
        jPieceRotations.add(jPieceRotationOne);
        int[][] jPieceRotationTwo={
                {0,0,0},
                {1,1,1},
                {0,0,1}
        };
        jPieceRotations.add(jPieceRotationTwo);
        int[][] jPieceRotationThree={
                {0,1,0},
                {0,1,0},
                {1,1,0}
        };
        jPieceRotations.add(jPieceRotationThree);
        turnShapes.add(jPieceRotations);


        LinkedList<int[][]> squarePieceRotations = new LinkedList<int[][]>();
        int[][] squarePiece={
                {1,1},
                {1,1},
        };
        shapes.add(squarePiece);
        squarePieceRotations.add(squarePiece);
        turnShapes.add(squarePieceRotations);

        LinkedList<int[][]> sPieceRotations = new LinkedList<int[][]>();

        int[][] sPiece={
                {0,1,1},
                {1,1,0},
                {0,0,0}
        };
        shapes.add(sPiece);
        sPieceRotations.add(sPiece);
        int[][] sPieceRotationOne={
                {0,1,0},
                {0,1,1},
                {0,0,1}
        };
        sPieceRotations.add(sPieceRotationOne);
        int[][] sPieceRotationTwo={
                {0,0,0},
                {0,1,1},
                {1,1,0}
        };
        sPieceRotations.add(sPieceRotationTwo);
        int[][] sPieceRotationThree={
                {1,0,0},
                {1,1,0},
                {0,1,0}
        };
        sPieceRotations.add(sPieceRotationThree);
        turnShapes.add(sPieceRotations);


        LinkedList<int[][]> tPieceRotations = new LinkedList<int[][]>();
        int[][] tPiece={
                {0,1,0},
                {1,1,1},
                {0,0,0}
        };
        shapes.add(tPiece);
        tPieceRotations.add(tPiece);

        int[][] tPieceRotationOne={
                {0,1,0},
                {0,1,1},
                {0,1,0}
        };
        tPieceRotations.add(tPieceRotationOne);
        int[][] tPieceRotationTwo={
                {0,0,0},
                {1,1,1},
                {0,1,0}
        };
        tPieceRotations.add(tPieceRotationTwo);
        int[][] tPieceRotationThree={
                {0,1,0},
                {1,1,0},
                {0,1,0}
        };
        tPieceRotations.add(tPieceRotationThree);
        turnShapes.add((tPieceRotations));

        LinkedList<int[][]> zPieceRotations = new LinkedList<int[][]>();
        int[][] zPiece={
                {1,1,0},
                {0,1,1},
                {0,0,0}
        };
        shapes.add(zPiece);
        zPieceRotations.add(zPiece);

        int[][] zPieceRotationOne={
                {0,0,1},
                {0,1,1},
                {0,1,0}
        };
        zPieceRotations.add(zPieceRotationOne);

        int[][] zPieceRotationTwo={
                {0,0,0},
                {0,1,1},
                {1,1,0}
        };
        zPieceRotations.add(zPieceRotationTwo);
        int[][] zPieceRotationThree={
                {0,1,0},
                {1,1,0},
                {1,0,0}
        };
        zPieceRotations.add(zPieceRotationThree);
        turnShapes.add(zPieceRotations);
    }
}
