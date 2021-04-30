package org.theusaf.BattlefieldChess.game.pieces;

import org.theusaf.BattlefieldChess.game.*;

public class Pawn extends Piece {

  private static final int BLACK_EN_PASSANT_ROW = 3;
  private static final int WHITE_EN_PASSANT_ROW = 6;
  private static final int BLACK_STARTING_ROW = 7;
  private static final int WHITE_STARTING_ROW = 2;

  private boolean hasMoved;

  public Pawn(Board board) {
    this(board, null, GameTeam.WHITE);
  }

  public Pawn(Board board, Position position, GameTeam team) {
    super(board, position, team);
    hasMoved = false;
  }

  @Override
  public void moveTo(Position position) {
    super.moveTo(position);
    hasMoved = true;
  }

  @Override
  public boolean canMoveTo(Position position) {
    if (!isOnBoard()) {
      return false;
    }
    if (hasMoved) {
      // Check if the position is in front and is empty
      if (checkFront(position)) {
        return true;
      } else { // Check for en passant and if the position is a valid en passant position
        return canDoEnPassant(position);
      }
    } else {
      // check if position is one or two squares ahead
      return checkFront(position) || checkFrontTwoSteps(position);
    }
  }

  /**
   * Returns whether the position is two steps in front and there space directly in front is empty
   */
  private boolean checkFrontTwoSteps(Position position) {
    int currentY = this.position.getY();
    int expectedY = currentY + frontDirectionMultiplier(2);
    int currentX = this.position.getX();
    Position directFrontPosition = BOARD.getPosition(currentX, currentY + frontDirectionMultiplier());

    return position.isEmpty()                 // target position is empty
            && directFrontPosition.isEmpty()  // position 1 space ahead is empty
            && position.getY() == expectedY   // target position is two rows ahead
            && position.getX() == currentX;   // target position is on the same column
  }

  /**
   * Returns if the Pawn can do en passant.
   */
  private boolean canDoEnPassant(Position position) {
    return inPositionToDoEnPassant() && opponentAdjacentPawnMovedTwice(position) && positionIsEnPassantPosition(position);
  }

  /**
   * Returns if the position is a position of en passant.
   */
  private boolean positionIsEnPassantPosition(Position position) {
    int currentX = this.position.getX();
    int expectedY = team == GameTeam.BLACK ? BLACK_STARTING_ROW : WHITE_STARTING_ROW;
    return expectedY == position.getY() && ((Integer) (position.getX() - currentX)).equals(1);
  }

  /**
   * Returns whether the last move was a pawn moving twice.
   */
  private boolean opponentAdjacentPawnMovedTwice(Position position) {
    int expectedY = team == GameTeam.BLACK ? BLACK_EN_PASSANT_ROW : WHITE_EN_PASSANT_ROW;
    int expectedStartingY = team == GameTeam.BLACK ? BLACK_STARTING_ROW : WHITE_STARTING_ROW;
    int centerX = this.position.getX();
    Movement lastMove = BOARD.getLastMove();

    if (lastMove == null                                                     // no moves yet
            || !(lastMove.getOriginalPiece() instanceof Pawn)                // piece that moved was not a pawn
            || lastMove.getNewPositionAfter().getY() != expectedY            // pawn did not move to expected y position
            || lastMove.getOriginalPosition().getY() != expectedStartingY) { // pawn originated from unexpected y position
      return false;
    }
    return ((Integer) Math.abs(lastMove.getNewPositionAfter().getX() - centerX)).equals(1);
  }

  /**
   * Returns whether the Pawn is in the correct row to do en passant.
   */
  private boolean inPositionToDoEnPassant() {
    switch (team) {
      case BLACK:
        return position.getY() == BLACK_EN_PASSANT_ROW;
      case WHITE:
        return position.getY() == WHITE_EN_PASSANT_ROW;
      default:
        return false;
    }
  }

  /**
   * Returns whether the given position is directly in front and if the location is valid.
   */
  private boolean checkFront(Position position) {
    int y = frontDirectionMultiplier() + this.position.getY();
    return position.getX() == this.position.getX() && y == position.getY() && position.isEmpty();
  }

  /**
   * Returns the character for the piece.
   *
   * @return 'P' for 'Pawn'
   */
  @Override
  public String toString() {
    return "P";
  }

}
