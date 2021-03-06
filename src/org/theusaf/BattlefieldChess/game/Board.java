package org.theusaf.BattlefieldChess.game;

import org.theusaf.BattlefieldChess.util.Copyable;

import java.util.ArrayList;

public class Board extends Copyable<Board> {

  private final Position[][] POSITIONS;
  private final ArrayList<Movement> MOVEMENTS;

  public Board() {
    POSITIONS = new Position[16][16];
    MOVEMENTS = new ArrayList<>();
    initializePositions();
  }

  private void initializePositions() {
    for (int i = 0; i < POSITIONS.length; i++) {
      Position[] positionList = POSITIONS[i];
      for (int j = 0; j < positionList.length; j++) {
        positionList[i] = new Position(i + 1, j + 1);
      }
    }
  }

  public void addMoveToHistory(Movement move) {
    MOVEMENTS.add(move);
  }

  public Movement getLastMove() {
    try {
      return MOVEMENTS.get(MOVEMENTS.size() - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public Position getPosition(int x, int y) {
    try {
      return POSITIONS[x - 1][y - 1];
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public void setPosition(int x, int y, Position position) {
    POSITIONS[x - 1][y - 1] = position;
  }

  @Override
  public Board copySpecific() {
    Board board = new Board(); // creates a new board
    for (Position[] rows : POSITIONS) {
      for (Position position : rows) {
        Position clone = position.copy(board); // copies the position and piece
        board.setPosition(clone.getX(), clone.getY(), clone); // updates the position
      }
    }
    return board;
  }

  @Override
  public Board copySpecific(Object... args) {
    if (args[0] instanceof Piece) {
      args[0] = ((Piece) args[0]).getPosition();
    }
    if (args[0] instanceof Position) {
      Board board = new Board(); // creates a new board
      Position clonedPosition = (Position) args[0];
      for (Position[] rows : POSITIONS) {
        for (Position position : rows) {
          Position clone;
          if (position.equals(clonedPosition)) {
            clone = clonedPosition; // if using cloned position, assigns the cloned position rather than a new clone
          } else {
            clone = position.copy(board); // creates a new clone, sets piece to board
          }
          board.setPosition(clone.getX(), clone.getY(), clone); // updates position
        }
      }
      return board;
    } else {
      return copySpecific();
    }
  }

}
