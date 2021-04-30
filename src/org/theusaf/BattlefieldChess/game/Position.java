package org.theusaf.BattlefieldChess.game;

import java.util.ArrayList;

public class Position {

  private final ArrayList<Piece> DEAD_PIECES;
  private Piece piece;

  public Position() {
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
}
