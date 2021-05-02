package org.theusaf.BattlefieldChess.game.pieces;

import org.theusaf.BattlefieldChess.game.*;

public class King extends Piece {

  public King(Board board) {
    this(board, null, GameTeam.WHITE);
  }

  public King(Board board, Position position, GameTeam team) {
    super(board, position, team);
  }

  @Override
  public String toString() {
    return "K";
  }
}
