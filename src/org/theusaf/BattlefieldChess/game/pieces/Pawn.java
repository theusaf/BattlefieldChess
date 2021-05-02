package org.theusaf.BattlefieldChess.game.pieces;

import org.theusaf.BattlefieldChess.game.*;

/**
 * Represents a Piece that moves forwards slowly and attacks diagonally.
 */
public class Pawn extends Piece {

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
