package org.theusaf.BattlefieldChess.game.pieces;

import org.theusaf.BattlefieldChess.game.*;
import org.theusaf.BattlefieldChess.game.piecefilters.KingMovementFilter;

public class King extends Piece {

  public King(Board board) {
    this(board, null, GameTeam.WHITE);
  }

  public King(Board board, Position position, GameTeam team) {
    super(board, position, team);
    pieceMovementFilter = new KingMovementFilter(this);
  }

  @Override
  public String toString() {
    return "K";
  }
}
