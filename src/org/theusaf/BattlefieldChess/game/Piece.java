package org.theusaf.BattlefieldChess.game;

public class Piece {

  protected Position position;
  protected Character character;
  protected final Board BOARD;

  public Piece(Board board) {
    BOARD = board;
  }

  public Piece(Board board, Position position) {
    BOARD = board;
    this.position = position;
  }

  public boolean canMoveTo(Position position) {
    return true;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public Character getCharacter() {
    return character;
  }

  public void setCharacter(Character character) {
    this.character = character;
  }
}
