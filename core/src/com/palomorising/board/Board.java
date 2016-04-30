package com.palomorising.board;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.palomorising.TetroMingas;
import com.palomorising.screens.TetroMingasGame;
import com.palomorising.shapes.Shape;
import com.palomorising.shapes.ShapeFactory;
import com.palomorising.utils.Constants;

public class Board {
    private int[][] grid;

    private ShapeFactory shapeFactory;
    private Shape currentShape;

    private TetroMingasGame screen;
    private TetroMingas game;

    public int score;
    public int lines;


    public Board(TetroMingasGame screen, TetroMingas game) {
        grid = new int[16][10];

        shapeFactory = new ShapeFactory();
        currentShape = shapeFactory.getShape();

        this.screen = screen;
        this.game = game;

        score = 0;
        lines = 0;


    }

    public void render(SpriteBatch batch) {
        batch.begin();
        renderBoard(batch);
        currentShape.renderShape(batch, game.assetManager.getTexture("testCell"));
        game.font.draw(game.batch, "Score: " + score, Constants.WIDTH - 100, Constants.HEIGHT - 10);
        game.font.draw(game.batch, "Lines: " + lines, Constants.WIDTH - 100, Constants.HEIGHT - 30);

        batch.end();

    }

    private void renderBoard(SpriteBatch batch) {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] == 1) {
                    batch.draw(game.assetManager.getTexture("testCell"), y * Constants.CELL_WIDTH, x * Constants.CELL_HEIGHT);
                } else {
                    batch.draw(game.assetManager.getTexture("emptyCell"), y * Constants.CELL_WIDTH, x * Constants.CELL_HEIGHT);
                }

            }

        }
    }

    public void update() {
        if (!isGoingToCollide()) {
            currentShape.updateLeftCorner(currentShape.getUpperLeftCornerX(), currentShape.getUpperLeftCornerY() - 1);
            game.assetManager.getSound("movement").play();
        } else {
            addCurrentPieceToBoard();
            checkFilledLines();
            increaseLevel();
            if (isGameLost()) {
                screen.endScreen(score, lines);

            }
            currentShape = shapeFactory.getShape();
        }
    }

    private boolean isGoingToCollide() {
        int nextUpperLeftCornerX = currentShape.getUpperLeftCornerX();
        int nextUpperLeftCornerY = currentShape.getUpperLeftCornerY() - 1;

        int[][] shape = currentShape.getShape();

        for (int x = 0; x < shape.length; x++) {
            for (int y = 0; y < shape[x].length; y++) {
                if (shape[x][y] == 1) {
                    if (nextUpperLeftCornerY - x < 0 || grid[nextUpperLeftCornerY - x][nextUpperLeftCornerX + y] == 1) {
                        return true;

                    }
                }
            }
        }
        return false;
    }

    private void addCurrentPieceToBoard() {
        int[][] shape = currentShape.getShape();

        for (int x = 0; x < shape.length; x++) {
            for (int y = 0; y < shape[x].length; y++) {
                if (shape[x][y] == 1) {
                    grid[currentShape.getUpperLeftCornerY() - x][currentShape.getUpperLeftCornerX() + y] = 1;

                }
            }
        }
    }

    private void checkFilledLines() {
        for (int x = 0; x < grid.length; x++) {
            boolean isFilled = true;
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] == 0) {
                    isFilled = false;
                    break;
                }
            }

            if (isFilled) {
                removeFilledLine(x);
                checkFilledLines();
            }
        }

    }

    private void removeFilledLine(int x) {
        game.assetManager.getSound("removeLine").play();
        for (int lines = x; lines < grid.length - 1; lines++) {
            grid[lines] = grid[lines + 1];
        }
        grid[grid.length - 1] = new int[grid[x].length];
        score += 40;
        lines++;

    }

    private void increaseLevel() {

        if (score > 50 && score < 500) {
            screen.setUpdateTimerLimit(0.38f);
        }
        if (score > 500 && score < 5000) {
            screen.setUpdateTimerLimit(0.3f);
        }
        if (score > 5000) {
            screen.setUpdateTimerLimit(0.22f);
        }

    }

    private boolean isGameLost() {
        for (int x = 0; x < grid[15].length; x++) {
            if (grid[15][x] == 1) {
                return true;
            }
        }
        return false;
    }

    private boolean isGoingToCollideMovement(int xIncrement) {
        int nextUpperLeftCornerX = currentShape.getUpperLeftCornerX() + xIncrement;
        int nextUpperLeftCornerY = currentShape.getUpperLeftCornerY();

        int[][] shape = currentShape.getShape();

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

    private boolean isGoingToCollideRotation() {
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


    public void moveRight() {
        if (!isGoingToCollideMovement(1)) {
            currentShape.updateLeftCorner(currentShape.getUpperLeftCornerX() + 1, currentShape.getUpperLeftCornerY());
            game.assetManager.getSound("movement").play();
        }
    }

    public void moveLeft() {
        if (!isGoingToCollideMovement(-1)) {
            currentShape.updateLeftCorner(currentShape.getUpperLeftCornerX() - 1, currentShape.getUpperLeftCornerY());
            game.assetManager.getSound("movement").play();
        }
    }

    public void moveDown() {
        if (!isGoingToCollide()) {
            currentShape.updateLeftCorner(currentShape.getUpperLeftCornerX(), currentShape.getUpperLeftCornerY() - 1);
            game.assetManager.getSound("movement").play();
            score++;
        }
    }

    public void rotateShape() {
        if (!isGoingToCollideRotation()) {
            game.assetManager.getSound("movement").play();
            currentShape.setNextShape();
        }
    }


}
