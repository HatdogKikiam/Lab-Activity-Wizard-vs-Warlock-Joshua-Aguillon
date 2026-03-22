# Wizard vs Warlock - Improved Java OOP Battle Sim

## Overview
Demonstrates inheritance, encapsulation, polymorphism in Java. Wizard and Warlock extend Character, battle until one defeated.

## Features (Improvements Made)
- **Encapsulation**: Private fields, getters/setters, validation (HP/Mana 0-100/200).
- **Proper Battle Logic**: Alternate turns, random attack/recover, mana/HP/alive checks, ends on defeat.
- **Spells**:
  | Class | Damage Spells | Recover |
  |-------|---------------|---------|
  | Wizard | fireStorm(55d/65m), timeBombAttack(55d/45m) | healthRejuvenation(+20HP/+40Mana, free) |
  | Warlock | Poison(50d/50m), attackOverheating(50d/40m) | healthRejuvenation(+20HP/+40Mana, free) |
- **Character Base**: isAlive(), damageTarget (with checks), levelUp(), enhanced displayStatus.
- **Battle**: Random spell choice, 80% attack / 20% recover per turn. Winner levels +10.

## How to Run
1. Compile: `cd "/Users/joshuajayaguillon/wizard/Lab-Activity-Wizard-vs-Warlock-Joshua-Aguillon" && javac src/*.java`
2. Run: `java -cp src App`
3. Observe battle output, stats, winner.

## Example Output Snippet
```
Wizards and Warlocks Battle!
Character initialized: Zeus
Character initialized: Underlord

Let the Battle Begin!

--- Zeus's Turn ---
=== Zeus Status ===
[...]

Zeus attacks Underlord with Firestorm (Damage: 55, Mana: 65)
Zeus deals 55 damage to Underlord.
[...]

*** Underlord has been defeated! ***
Victory! Zeus wins!
Zeus leveled up by 10 levels! New level: 10
```

All bugs fixed, best practices applied. Enjoy the battle!
