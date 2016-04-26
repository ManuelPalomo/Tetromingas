package com.palomorising.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.palomorising.board.Board;

public class GameInputHandler extends InputAdapter {
    private Board board;

    public GameInputHandler(Board board){
        super();
        this.board=board;
    }

    @Override
    public boolean keyDown(int keycode){
        switch (keycode){
            case Input.Keys.RIGHT:
                board.moveRight();
                break;

            case Input.Keys.LEFT:
                board.moveLeft();
                break;

            case Input.Keys.DOWN:
                board.moveDown();
                break;

            case Input.Keys.UP:
                board.rotateShape();
        }
        return true;
    }

}
