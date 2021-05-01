# Battlefield Chess
Inspired by Chess and Fire Emblem Heroes

### The board
The board is exactly the same as a regular chess board.

### Piece movement
Pieces move as you expect on the board.

### Piece capture/battle
When a piece attacks another piece, the defending piece's position is only captured if it is completely defeated (HP < 0) by the attacking piece.

If the defending piece survives the attack, it remains in the same location, and the attacking piece moves as close as possible to the defender along its path of attack.

Examples:
1. Bishop vs Pawn 
    1. A bishop on `B2` attacks a pawn on `G7`. 
    2. The bishop fails to defeat the pawn. 
    3. The bishop then moves to `F6`.
2. Knight vs Queen
    1. A knight on `D4` attacks a queen on `E6`. 
    2. The knight fails to defeat the queen. 
    3. The knight and queen stay on their respective squares.
    
### Types of weapons
- Staff
    - Magical weapon
    - Effective against cavalry
- Healing Staff
    - If a unit has this weapon, they will not have the 'Heal' skill.
    - Does not deal damage
- Bow
    - Physical weapon
    - Effective against flying enemies
- Spear
    - Physical weapon
    - Advantage over swords
- Axe
    - Physical weapon
    - Advantage over spears
- Sword
    - Physical weapon
    - Advantage over axes
- Throwing Knives
    - Lowers target's defense during combat by a percent
    - More effective against targets using bows
- Hand
    - Only used by Beasts
    - Physical attack
- Magic Beam
    - Only used by Demons
    - Magic attack

### Types of pieces
- Cavalry
    - Advantage against:
        - Infantry
        - Heavy Infantry
- Flying
    - Advantage against:
        - Beasts
        - Infantry
- Infantry
    - Advantage against:
        - Demons
        - Heavy Infantry
- Heavy Infantry
    - Advantage against:
        - Demons
        - Flying
- Beast
    - Must use Hand weapon
    - Advantage against:
        - Cavalry
        - Heavy Infantry
- Demons
    - Must use Magic Beam weapon
    - Advantage against:
        - Beasts
        - Cavalry

### Elemental Type
- None
    - Does not beat and is not beaten by any other type
- Water
    - Beats Fire
- Fire
    - Beats Ground
- Ground
    - Beats Water
    
### Skills
Skills are special effects that can boost pieces on the board

<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Effect</th>
            <th>Restrictions</th>
            <th>Type</th>
        </tr>
        <tr>
            <td>The name of the skill</td>
            <td>The effect of the skill</td>
            <td>Any restrictions to using the skill</td>
            <td>
                <p>Active/Passive</p>
                <p><b>Active</b> skills are considered a move</p>
                <p><b>Passive</b> skills affect all units that can be targeted by the piece, unless specified by restrictions</p>
            </td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <th colspan="4">Special Skills</th>
        </tr>
        <tr>
            <td>Heal</td>
            <td>Restores HP of friendly units</td>
            <td>
                <ul>
                    <li>User must be a staff user</li>
                </ul>
            </td>
            <td>Active</td>
        </tr>
        <tr>
            <td>Cheer</td>
            <td>Enables target to have two actions in the next turn</td>
            <td>
                <ul>
                    <li>Target must not have the Cheer skill</li>
                </ul>
            </td>
            <td>Active</td>
        </tr>
        <tr>
            <td>Swap (in consideration)</td>
            <td>Enables the user to swap places with the target</td>
            <td>
                <ul>
                    <li>The target's position must be a valid position for the user to go to</li>
                    <li>The user's position must be a valid position for the target to go to</li>
                </ul>
            </td>
            <td>Active</td>
        </tr>
        <tr>
            <td>Boost Attack/Defense/Speed/M. Defense</td>
            <td>Temporarily increases target(s) stats</td>
            <td>
                <ul>
                    <li>None</li>
                </ul>
            </td>
            <td>Passive</td>
        </tr>
        <tr>
            <td>Sacrifice</td>
            <td>Transfers health from one unit to another</td>
            <td>
                <ul>
                    <li>User must have at least 11 health</li>
                    <li>Target must not have full health</li>
                </ul>
            </td>
            <td>Active</td>
        </tr>
        <tr>
            <td>Cure</td>
            <td>Removes curses from target. High levels can even turn curses into buffs</td>
            <td>
                <ul>
                    <li>Target must have a curse</li>
                </ul>
            </td>
            <td>Active</td>
        </tr>
        <tr>
            <th colspan="3">Charge Skills</th>
            <td>Charge skills charge each time a unit attacks (in defense or offense)</td>
        </tr>
        <tr>
            <td>Life leech</td>
            <td>Gain back a percentage of damage dealt as health</td>
            <td>
                <ul>
                    <li>User cannot use a Healing Staff</li>
                </ul>
            </td>
            <td>Charge</td>
        </tr>
        <tr>
            <td>Penetration</td>
            <td>When in combat, treats the opponents <code>DEF/M.DEF</code> as reduced by a percentage</td>
            <td>
                <ul>
                    <li>User cannot use a Healing Staff</li>
                </ul>
            </td>
            <td>Charge</td>
        </tr>
        <tr>
            <td>Adrenaline Boost</td>
            <td>When in combat, increases damage by a percentage</td>
            <td>
                <ul>
                    <li>User cannot use a Healing Staff</li>
                </ul>
            </td>
            <td>Charge</td>
        </tr>
        <tr>
            <td>Preemptive Strike</td>
            <td>Before attacking, the target and any units directly next to it takes damage <code>Attack - Def/M. Def</code></td>
            <td>
                <ul>
                    <li>User cannot use a Healing Staff</li>
                    <li>Enemy piece health cannot go under 1</li>
                </ul>
            </td>
            <td>Charge</td>
        </tr>
        <tr>
            <td>Guard</td>
            <td>Reduces damage from an opposing piece's attack by a percent</td>
            <td>
                <ul>
                    <li>User cannot use a Throwing Knife or Bow</li>
                </ul>
            </td>
            <td>Charge</td>
        </tr>
        <tr>
            <td>Miracle</td>
            <td>If an opposing piece's attack would cause health to drop below 1, the piece will survive with 1 HP.</td>
            <td>
                <ul>
                    <li>None</li>
                </ul>
            </td>
            <td>Charge</td>
        </tr>
        <tr>
            <td>Group Cheer</td>
            <td>When healing a target, all pieces on the board gain a boost to all stats by a number for 2 turns (this turn + next turn)</td>
            <td>
                <ul>
                    <li>User must use a Healing Staff</li>
                </ul>
            </td>
            <td>Charge</td>
        </tr>
        <tr>
            <th colspan="4">Type I Passive</th>
        </tr>
        <tr>
            <td>HP/ATK/DEF/M. DEF/SPD Boost</td>
            <td>Permanently increases stats</td>
            <td>
                <ul>
                    <li>Targets self</li>
                </ul>
            </td>
            <td>Passive</td>
        </tr>
        <tr>
            <td>Hard Hitter</td>
            <td>Increases ATK/DEF/M. DEF/SPD during combat</td>
            <td>
                <ul>
                    <li>Targets self</li>
                    <li>User must initiate combat</li>
                </ul>
            </td>
            <td>Passive</td>
        </tr>
        <tr>
            <td>Thick Skin</td>
            <td>Increases ATK/DEF/M. DEF/SPD during combat</td>
            <td>
                <ul>
                    <li>Targets self</li>
                    <li>Opponent piece must initiate combat</li>
                </ul>
            </td>
            <td>Passive</td>
        </tr>
        <tr>
            <td>Painful Strength</td>
            <td>Greatly increases stats during combat</td>
            <td>
                <ul>
                    <li>Targets self</li>
                    <li>User's HP must be less than a percent</li>
                </ul>
            </td>
            <td>Passive</td>
        </tr>
        <tr>
            <td>Overclock</td>
            <td>Increases/Decreases stats by a percent during combat</td>
            <td>
                <ul>
                    <li>Targets self</li>
                    <li>If User's advantage is greater than Opponent piece's advantage, increases stats. Else, decreases</li>
                </ul>
            </td>
            <td>Passive</td>
        </tr>
        <tr>
            <td>Teamwork</td>
            <td>Increases ATK/DEF/M. DEF/SPD during combat</td>
            <td>
                <ul>
                    <li>Targets self</li>
                    <li>User must be next to another friendly piece</li>
                </ul>
            </td>
            <td>Passive</td>
        </tr>
        <tr>
            <td>Solo Leveling</td>
            <td>Increases ATK/DEF/M. DEF/SPD during combat</td>
            <td>
                <ul>
                    <li>Targets self</li>
                    <li>User must not be near another friendly piece</li>
                </ul>
            </td>
            <td>Passive</td>
        </tr>
        <tr>
            <th colspan="4">Type II Passive</th>
        </tr>
        <tr>
            <td>Pass Through</td>
            <td>Allows self to move through friendly pieces</td>
            <td>
                <ul>
                    <li>Targets self</li>
                    <li>If moving through friendlies, cannot attack or use active skills</li>
                </ul>
            </td>
            <td>Passive</td>
        </tr>
        <tr>
            <td>Ambush</td>
            <td>Counterattack before opponent piece attacks</td>
            <td>
                <ul>
                    <li>Targets self</li>
                    <li>User's HP must be less than a percentage</li>
                    <li>Opponent piece must initiate combat</li>
                    <li>Opponent piece must be in a location that the User can attack</li>
                    <li>User cannot use a Healing Staff</li>
                </ul>
            </td>
            <td>Passive</td>
        </tr>
        <tr>
            <td>Desperation</td>
            <td>Perform a guaranteed secondary attack before opponent piece counters</td>
            <td>
                <ul>
                    <li>Targets self</li>
                    <li>User's HP must be less than a percentage</li>
                    <li>User cannot use a Healing Staff</li>
                </ul>
            </td>
            <td>Passive</td>
        </tr>
        <tr>
            <td>Double Tap</td>
            <td>Deal additional damage to target after combat</td>
            <td>
                <ul>
                    <li>Targets opponent target</li>
                    <li>User must initiate combat</li>
                    <li>Target's health may not drop below 1</li>
                    <li>User cannot use a Healing Staff</li>
                </ul>
            </td>
            <td>Passive</td>
        </tr>
        <tr>
            <td>Live to Serve</td>
            <td>Restores health after healing someone else</td>
            <td>
                <ul>
                    <li>User must use a Healing Staff</li>
                    <li>Targets self</li>
                </ul>
            </td>
            <td>Passive</td>
        </tr>
        <tr>
            <td>Curse</td>
            <td>Reduces ATK/DEF/M. DEF/SPD of opponent piece after combat for 3 turns</td>
            <td>
                <ul>
                    <li>Targets opponent target/attacker</li>
                </ul>
            </td>
            <td>Passive</td>
        </tr>
        <tr>
            <td>Sabotage</td>
            <td>Reduces ATK/DEF/M. DEF/SPD of opponent pieces for 2 turns</td>
            <td>
                <ul>
                    <li>Targets opponent pieces that can be targeted by the User</li>
                    <li>Target must have less stats than User</li>
                </ul>
            </td>
            <td>Passive</td>
        </tr>
        <tr>
            <td>Neutral Advantage</td>
            <td>Cancels out weapon/elemental/unit advantages and disadvantages</td>
            <td>
                <ul>
                    <li>Targets self</li>
                </ul>
            </td>
            <td>Passive</td>
        </tr>
        <tr>
            <td>Charge</td>
            <td>Charges up Unit's charge ability at the start of its turn</td>
            <td>
                <ul>
                    <li>Targets self</li>
                    <li>User must have HP higher than a percent</li>
                </ul>
            </td>
            <td>Passive</td>
        </tr>
        <tr>
            <td>Parry</td>
            <td>Reduces damage taken by a percent</td>
            <td>
                <ul>
                    <li>Targets self</li>
                    <li>Opponent piece must initiate combat</li>
                    <li>Opponent piece must be in a position targetable by the User</li>
                </ul>
            </td>
            <td>Passive</td>
        </tr>
        <tr>
            <td>Recovery</td>
            <td>Restores health after combat</td>
            <td>
                <ul>
                    <li>Targets self</li>
                </ul>
            </td>
            <td>Passive</td>
        </tr>
        <tr>
            <th colspan="4">Type III Passive</th>
        </tr>
        <tr>
            <td>Battle Rest</td>
            <td>Restores HP after combat</td>
            <td>
                <ul>
                    <li>Targets self</li>
                </ul>
            </td>
            <td>Passive</td>
        </tr>
        <tr>
            <td>Power of Friendship</td>
            <td>Boosts friendly pieces ATK/DEF/M. DEF/SPD for 1 turn</td>
            <td>
                <ul>
                    <li>Targets friendly pieces</li>
                </ul>
            </td>
            <td>Passive</td>
        </tr>
        <tr>
            <td>Threaten</td>
            <td>Reduces opponent pieces ATK/DEF/M. DEF/SPD for 1 turn</td>
            <td>
                <ul>
                    <li>Targets opponent pieces</li>
                </ul>
            </td>
            <td>Passive</td>
        </tr>
        <tr>
            <td>Poison Smoke</td>
            <td>Reduces opponent pieces ATK/DEF/M. DEF/SPD for 1 turn after combat</td>
            <td>
                <ul>
                    <li>Targets opponent pieces</li>
                </ul>
            </td>
            <td>Passive</td>
        </tr>
        <tr>
            <td>Quick Charge</td>
            <td>Charges User's charge skill</td>
            <td>
                <ul>
                    <li>Targets self</li>
                    <li>Charge skill must be at 0 charge (not charged)</li>
                </ul>
            </td>
            <td>Passive</td>
        </tr>
    </tbody>
</table>

### Special Skills
- Heal
    - Can restore HP of friendly troops as its move.
    - Only compatible with Staff users.
- Cheer
    - Enables the target to have two moves the next turn (if that piece is used).
    - The target cannot have the Cheer skill.
    
### Pre-battle
- Effects from the last turn are decremented/removed.
- All passive skills that enhance friendly pieces and weaken enemy pieces are activated.

### Battle
1. Bonus stats are calculated (passive skills, type advantages).
2. Unless defender has a skill to counterattack first, attacker engages first.
3. Attacker deals damage `(ATK - (DEF/M. DEF))`
    - `DEF` is used against physical attacks.
    - `M. DEF` is used against magical attacks.
4. If the defender is still alive, it can counterattack if the original position of the attacker is in the defender's attack path.
    - In this way, the opponent's piece can be defeated when it's not one's turn.
    
### Bonus Stats
TODO

### Check
The King is in check only if it is under the threat of an attack that can defeat it.

The King can also move into danger, as long as the danger is not lethal.

### Checkmate
Checkmate occurs when the King is in check, and:
- The King cannot move to a nonlethal position
- The attacker cannot be taken out by a defending piece
- The path of attack cannot be blocked by a defending piece

### Stalemate
- The King is not in check, but there are no valid moves to do.
- The same position is played 3 times in a row by both sides.

### Castling
The King can castle if:
- The King and the Rook have not moved from their starting positions.
- The spaces between the Rook and the King must be empty  
- It is not under threat of attack (even if nonlethal).
- All the squares in the path of castling are not under attack.

### En Passant
Rules to do En Passant are the same as normal chess.

The pawns battle, and regardless if the defending pawn is defeated, if the attacking pawn survives (which it should always survive...), it moves to the position behind the defending pawn.

## Why?
Clearly, this project exists just to make that scene from Code Geass possible.