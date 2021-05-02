package org.theusaf.BattlefieldChess.game.piecefilters;

import org.theusaf.BattlefieldChess.game.Position;
import org.theusaf.BattlefieldChess.game.pieces.Pawn;

public class PawnMovementFilter implements PieceMovementFilter {

  private final Pawn piece;

  public PawnMovementFilter(Pawn piece) {
    this.piece = piece;
  }

  @Override
  public Position[] attackable() {
    return new Position[0];
  }

  @Override
  public Position[] movable() {
    return new Position[0];
  }

  @Override
  public Position[] theoretical() {
    return new Position[0];
  }
}
