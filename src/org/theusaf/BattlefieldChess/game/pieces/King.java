package org.theusaf.BattlefieldChess.game.pieces;

import org.theusaf.BattlefieldChess.game.Board;
import org.theusaf.BattlefieldChess.game.GameTeam;
import org.theusaf.BattlefieldChess.game.Piece;
import org.theusaf.BattlefieldChess.game.Position;

public class King extends Piece {

  public King(Board board) {
    this(board, null, GameTeam.WHITE);
  }

  public King(Board board, Position position, GameTeam team) {
    super(board, position, team);
  }

}
