package org.theusaf.BattlefieldChess.game;

import java.util.ArrayList;

public class Position {

  private final int X, Y;
  private final ArrayList<Piece> DEAD_PIECES;
  private Piece piece;

  public Position(int x, int y) {
    this.X = x;
    this.Y = y;
    DEAD_PIECES = new ArrayList<>();
  }

  public ArrayList<Piece> getDeadPieces() {
    return DEAD_PIECES;
  }

  public Piece getPiece() {
    return piece;
  }

  public void setPiece(Piece piece) {
    this.piece = piece;
  }

  public void capturePiece() {
    DEAD_PIECES.add(piece);
  }

  public void removePiece() {
    piece = null;
  }

  public int getX() {
    return X;
  }

  public int getY() {
    return Y;
  }

}
