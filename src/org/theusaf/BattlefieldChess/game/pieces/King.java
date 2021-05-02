package org.theusaf.BattlefieldChess.game.pieces;

import org.theusaf.BattlefieldChess.game.*;

public class King extends Piece {

  private boolean hasMoved;

  public King(Board board) {
    this(board, null, GameTeam.WHITE);
  }

  public King(Board board, Position position, GameTeam team) {
    super(board, position, team);
    hasMoved = false;
  }

  @Override
  public Position[] getPossiblePositions() {
    return super.getPossiblePositions();
  }

  @Override
  public boolean canMoveTo(Position position) {
    return super.canMoveTo(position);
  }

  @Override
  public String toString() {
    return "K";
  }
}
