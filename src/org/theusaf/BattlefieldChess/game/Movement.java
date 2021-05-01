package org.theusaf.BattlefieldChess.game;

/**
 * Represents a move in the game.
 */
public class Movement {

  private final Piece ORIGINAL_PIECE;
  private final Piece NEW_PIECE;
  private final Position ORIGINAL_POSITION;
  private final Position NEW_POSITION_BEFORE;
  private final Position NEW_POSITION_AFTER;

  /**
   * Constructs a move.
   * <br>
   * This creates copies of the pieces passed in.
   *
   * @param originalPiece           The original piece (attacker before moving)
   * @param newPiece                The new piece (attacker after moving)
   * @param originalTargetPosition  The original target position (target position before piece moved to that square)
   */
  public Movement(Piece originalPiece, Piece newPiece, Position originalTargetPosition) {
    ORIGINAL_PIECE = originalPiece.copy();
    NEW_PIECE = newPiece.copy();
    ORIGINAL_POSITION = originalPiece.getPosition(); // These two should already be copies
    NEW_POSITION_AFTER = newPiece.getPosition();
    NEW_POSITION_BEFORE = originalTargetPosition.copy();
  }

  /**
   * Formats string into a chess movement format.
   * TODO: Remove this or replace this with something better. Maybe create a new class.
   *
   * @return The formatted string
   */
  @Override
  public String toString() {
    String actionChar = " ";
    if (!NEW_POSITION_BEFORE.isEmpty()) {
      actionChar = "x";
    }
    return String.format("%s%s%s%s", ORIGINAL_PIECE, ORIGINAL_POSITION, actionChar, NEW_POSITION_AFTER);
  }

  /**
   * Gets this move's original piece.
   *
   * @return The original piece
   */
  public Piece getOriginalPiece() {
    return ORIGINAL_PIECE;
  }

  /**
   * Gets this move's new piece.
   *
   * @return The new piece
   */
  public Piece getNewPiece() {
    return NEW_PIECE;
  }

  /**
   * Gets this move's original position.
   *
   * @return The original position before moving
   */
  public Position getOriginalPosition() {
    return ORIGINAL_POSITION;
  }

  /**
   * Gets this move's target position (before moving).
   * <br>
   * This position may or may not be the actual position the piece was moving to.
   * To see where the piece actually ends up, use {@link #getNewPositionAfter()}.
   *
   * @return The new position before moving to this position
   */
  public Position getNewPositionBefore() {
    return NEW_POSITION_BEFORE;
  }

  /**
   * Gets this move's new position (after moving).
   *
   * @return The new position after moving to this position
   */
  public Position getNewPositionAfter() {
    return NEW_POSITION_AFTER;
  }
}
