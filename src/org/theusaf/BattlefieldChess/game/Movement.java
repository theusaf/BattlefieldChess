package org.theusaf.BattlefieldChess.game;

public class Movement {

  private final Piece ORIGINAL_PIECE;
  private final Piece NEW_PIECE;
  private final Position ORIGINAL_POSITION;
  private final Position NEW_POSITION_BEFORE;
  private final Position NEW_POSITION_AFTER;

  public Movement(Piece originalPiece, Piece newPiece, Position originalTargetPosition) {
    ORIGINAL_PIECE = originalPiece.copy();
    NEW_PIECE = newPiece.copy();
    ORIGINAL_POSITION = originalPiece.getPosition(); // These two should already be copies
    NEW_POSITION_AFTER = originalPiece.getPosition();
    NEW_POSITION_BEFORE = originalTargetPosition.copy();
  }

  @Override
  public String toString() {
    String actionChar = " ";
    if (!NEW_POSITION_BEFORE.isEmpty()) {
      actionChar = "x";
    }
    return String.format("%s%s%s%s", ORIGINAL_PIECE, ORIGINAL_POSITION, actionChar, NEW_POSITION_AFTER);
  }

  public Piece getOriginalPiece() {
    return ORIGINAL_PIECE;
  }

  public Piece getNewPiece() {
    return NEW_PIECE;
  }

  public Position getOriginalPosition() {
    return ORIGINAL_POSITION;
  }

  public Position getNewPositionBefore() {
    return NEW_POSITION_BEFORE;
  }

  public Position getNewPositionAfter() {
    return NEW_POSITION_AFTER;
  }
}
