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
      } else { // Check for en passant
        return canDoEnPassant(position);
      }
    } else {
      // check if position is one or two squares ahead
      return checkFront(position) || checkFrontTwoSteps(position);
    }
  }

  private boolean checkFrontTwoSteps(Position position) {
    int currentY = this.position.getY();
    int currentX = this.position.getX();
  }

  private boolean canDoEnPassant(Position position) {
    return inPositionToDoEnPassant() && opponentAdjacentPawnMovedTwice(position) && positionIsEnPassantPosition(position);
  }

  private boolean positionIsEnPassantPosition(Position position) {
  }

  private boolean opponentAdjacentPawnMovedTwice(Position position) {
    int expectedY = team == GameTeam.BLACK ? BLACK_EN_PASSANT_ROW : WHITE_EN_PASSANT_ROW;
    int expectedStartingY = team == GameTeam.BLACK ? BLACK_STARTING_ROW : WHITE_STARTING_ROW;
    int centerX = this.position.getX();
    Movement lastMove = BOARD.getLastMove();

    if (lastMove == null) {
      return false;
    }
    if (!(lastMove.getOriginalPiece() instanceof Pawn)) {
      return false;
    }
    if (lastMove.getNewPositionAfter().getY() != expectedY) {
      return false;
    }
    if (lastMove.getOriginalPosition().getY() != expectedStartingY) {
      return false;
    }
    return ((Integer) Math.abs(lastMove.getNewPositionAfter().getX() - centerX)).equals(1);
  }

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

  private boolean checkFront(Position position) {
    int y = frontDirectionMultiplier() + this.position.getY();
    return position.getX() == this.position.getX() && y == position.getY() && position.isEmpty();
  }

  @Override
  public String toString() {
    return "P";
  }

}
