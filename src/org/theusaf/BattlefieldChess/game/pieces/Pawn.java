package org.theusaf.BattlefieldChess.game.pieces;

import org.theusaf.BattlefieldChess.game.*;

/**
 * Represents a Piece that moves forwards slowly and attacks diagonally.
 */
public class Pawn extends Piece {

  private static final int BLACK_EN_PASSANT_ROW = 3;
  private static final int WHITE_EN_PASSANT_ROW = 6;
  private static final int BLACK_STARTING_ROW = 7;
  private static final int WHITE_STARTING_ROW = 2;

  private boolean hasMoved;

  /**
   * Constructs a Pawn (no position, default team WHITE)
   *
   * @param board The board the Pawn should be given a position on later
   */
  public Pawn(Board board) {
    this(board, null, GameTeam.WHITE);
  }

  /**
   * Constructs a Pawn and places it at the specified position on the specified team.
   * @see Piece#Piece(Board, Position, GameTeam)
   *
   * @param board The board the Pawn is placed on
   * @param position The Position the Pawn is located at
   * @param team The team the Pawn is on
   */
  public Pawn(Board board, Position position, GameTeam team) {
    super(board, position, team);
    hasMoved = false; // TODO: Verify that the piece is on the starting rank when setting this value
  }

  // TODO: Override the getPossiblePositions method

  /**
   * Moves the piece to another Position.
   *
   * @param position The Position to move the piece to
   */
  @Override
  public void moveTo(Position position) {
    super.moveTo(position);
    hasMoved = true;
  }

  /**
   * Gets the possible positions the pawn could move to.
   *
   * @return A list of positions the pawn could move to. Could contain null.
   */
  @Override
  public Position[] getPossiblePositions() {
    int currentX = position.getX();
    int currentY = position.getY();
    Position directFront = board.getPosition(currentX, currentY + frontDirectionMultiplier());
    Position frontTwoSteps = null;
    if (!hasMoved) {
      frontTwoSteps = board.getPosition(currentX, currentY + frontDirectionMultiplier(2));
    }
    Position diagonalLeft = board.getPosition(currentX - frontDirectionMultiplier(), currentY - frontDirectionMultiplier());
    Position diagonalRight = board.getPosition(currentX + frontDirectionMultiplier(), currentY + frontDirectionMultiplier());
    return new Position[]{directFront, frontTwoSteps, diagonalLeft, diagonalRight};
  }

  /**
   * Checks whether a position on the board can be moved to or attacked/captured.
   *
   * @param position The Position to check
   * @return Whether the specified Position can be moved to or attacked
   */
  @Override
  public boolean canMoveTo(Position position) {
    if (!isOnBoard()) {
      return false;
    }
    if (hasMoved) {
      // Check if the position is in front and is empty
      if (checkFront(position)) {
        return true;
      } else if (canDoEnPassant(position)) { // Check for en passant and if the position is a valid en passant position
        return true;
      }
    } else {
      // check if position is one or two squares ahead
      if (checkFront(position) || checkFrontTwoSteps(position)) {
        return true;
      }
    }
    return checkCapture(position);
  }

  /**
   * Checks whether the position is a position that can be captured.
   */
  private boolean checkCapture(Position position) {
    int expectedY = this.position.getY() + frontDirectionMultiplier();
    int currentX = this.position.getX();
    return !position.isEmpty()                                              // position is not empty
            && ((Integer) position.getY()).equals(expectedY)                // position is one row in front
            && ((Integer) Math.abs(position.getX() - currentX)).equals(1);  // position is offset to the side by 1
  }

  /**
   * Returns whether the position is two steps in front and there space directly in front is empty
   */
  private boolean checkFrontTwoSteps(Position position) {
    int currentY = this.position.getY();
    int expectedY = currentY + frontDirectionMultiplier(2);
    int currentX = this.position.getX();
    Position directFrontPosition = board.getPosition(currentX, currentY + frontDirectionMultiplier());

    return position.isEmpty()                                // target position is empty
            && directFrontPosition.isEmpty()                 // position 1 space ahead is empty
            && ((Integer) position.getY()).equals(expectedY) // target position is two rows ahead
            && ((Integer) position.getX()).equals(currentX); // target position is on the same column
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
    return ((Integer) expectedY).equals(position.getY()) && ((Integer) Math.abs(position.getX() - currentX)).equals(1);
  }

  /**
   * Returns whether the last move was a pawn moving twice.
   */
  private boolean opponentAdjacentPawnMovedTwice(Position position) {
    int expectedY = team == GameTeam.BLACK ? BLACK_EN_PASSANT_ROW : WHITE_EN_PASSANT_ROW;
    int expectedStartingY = team == GameTeam.BLACK ? BLACK_STARTING_ROW : WHITE_STARTING_ROW;
    int centerX = this.position.getX();
    Movement lastMove = board.getLastMove();

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
    return ((Integer) position.getX()).equals(this.position.getX()) && ((Integer) y).equals(position.getY()) && position.isEmpty();
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

  public boolean hasMoved() {
    return hasMoved;
  }

  public void setHasMoved(boolean hasMoved) {
    this.hasMoved = hasMoved;
  }
}
