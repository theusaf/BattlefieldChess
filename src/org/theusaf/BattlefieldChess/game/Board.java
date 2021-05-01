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
    return POSITIONS[x - 1][y - 1];
  }

}
