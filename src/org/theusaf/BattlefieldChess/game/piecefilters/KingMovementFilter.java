package org.theusaf.BattlefieldChess.game.piecefilters;

import org.theusaf.BattlefieldChess.game.Position;
import org.theusaf.BattlefieldChess.game.pieces.King;

public class KingMovementFilter implements PieceMovementFilter {

  private final King piece;

  public KingMovementFilter(King piece) {
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
