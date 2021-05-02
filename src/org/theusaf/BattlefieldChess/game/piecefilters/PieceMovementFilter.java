package org.theusaf.BattlefieldChess.game.piecefilters;

import org.theusaf.BattlefieldChess.game.Position;

public interface PieceMovementFilter {

  Position[] attackable();

  Position[] movable();

  Position[] theoretical();

}
