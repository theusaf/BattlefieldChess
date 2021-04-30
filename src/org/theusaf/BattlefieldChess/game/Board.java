package org.theusaf.BattlefieldChess.game;

public class Board {

  private final Position[][] POSITIONS;

  public Board() {
    POSITIONS = new Position[16][16];
    initializePositions();
  }

  private void initializePositions() {
    for (int i = 0; i < POSITIONS.length; i++) {
      Position[] positionList = POSITIONS[i];
      for (int j = 0; j < positionList.length; j++) {
        positionList[i] = new Position(i, j);
      }
    }
  }

  public Position getPosition(int x, int y) {
    return POSITIONS[x][y];
  }

}
