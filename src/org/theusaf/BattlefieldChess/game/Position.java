package org.theusaf.BattlefieldChess.game;

import org.theusaf.BattlefieldChess.util.Copyable;

import java.util.ArrayList;

/**
 * Represents a location on a board.
 */
public class Position extends Copyable<Position> {

  private final int X, Y;
  private final ArrayList<Piece> DEAD_PIECES;
  private Piece piece;

  /**
   * Constructs a Position with an x and y coordinate.
   *
   * @param x The x coordinate
   * @param y The y coordinate
   */
  public Position(int x, int y) {
    this.X = x;
    this.Y = y;
    DEAD_PIECES = new ArrayList<>();
  }

  /**
   * Returns the list of dead pieces.
   * <br>
   * Dead pieces are pieces that have been defeated on this position.
   *
   * @return The list of dead pieces
   */
  public ArrayList<Piece> getDeadPieces() {
    return DEAD_PIECES;
  }

  /**
   * Returns whether there is an active piece in this Position.
   *
   * @return Whether there is an active piece in this position
   */
  public boolean isEmpty() {
    return piece == null;
  }

  /**
   * Gets the current piece on this Position.
   *
   * @return The Piece. May be null.
   */
  public Piece getPiece() {
    return piece;
  }

  /**
   * Sets the active piece for this Position.
   *
   * @param piece The Piece to place on this position.
   *              <br>
   *              <p>Note:</p>
   *              <p>Pieces added using this method will <b>not be removed</b> from their old location.
   *              Call <code>Position.removePiece()</code> to remove the piece on the old Position</p>
   */
  public void setPiece(Piece piece) {
    this.piece = piece;
  }

  /**
   * Moves the current active piece to the dead pieces list and removes it from the active position.
   */
  public void capturePiece() {
    DEAD_PIECES.add(piece);
    removePiece();
  }

  /**
   * Removes the current piece from this position.
   */
  public void removePiece() {
    piece = null;
  }

  /**
   * Returns the x coordinate of this position.
   *
   * @return The x coordinate
   */
  public int getX() {
    return X;
  }

  /**
   * Returns the y coordinate of this position.
   *
   * @return The y coordinate
   */
  public int getY() {
    return Y;
  }

  /**
   * Generates a clone of the position.
   * <br>
   * The cloned position will also contain a clone of the Piece, if there was an active piece on this position.
   * TODO: check that these cloning methods actually work
   *
   * @return The clone of this position
   */
  @Override
  protected Position copySpecific() {
    Position clone = new Position(X, Y); // create new position
    if (piece != null) {
      Piece pieceClone = piece.copy(true); // clone piece (w/o cloning position)
      clone.setPiece(pieceClone); // update position clone piece
      pieceClone.setPosition(clone); // update piece clone position
      pieceClone.getBoard().setPosition(X, Y, clone); // fix position on cloned board
    }
    return clone;
  }

  /**
   * Generates a clone of the position (without cloned Piece).
   *
   * @param args The arguments
   * @return A clone of the position without the piece
   */
  @Override
  protected Position copySpecific(Object... args) {
    if (args[0] instanceof Board) {
      Position clone = copySpecific(); // Creates a clone with cloned position, board, and piece
      if (!clone.isEmpty()) {
        clone.getPiece().setBoard((Board) args[0]); // Updates the board of the cloned piece to the specified board
      }
      return clone;
    }
    return new Position(X, Y);
  }

  @Override
  public boolean equals(Object position) {
    if (!(position instanceof Position)) {
      return false;
    }
    Position other = (Position) position;
    return ((Integer) other.getX()).equals(X) && ((Integer) other.getY()).equals(Y);
  }

}
