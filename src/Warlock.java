/**
 * Warlock subclass with dark spells.
 */
public class Warlock extends Character {

    public Warlock(String name) {
        super(name);
    }

    /** Poison spell: 50 dmg, 50 mana */
    public void Poison(Character enemy) {
        System.out.println(getCharacterName() + " attacks " + enemy.getCharacterName() + " with Poison (Damage: 50, Mana: 50)");
        damageTarget(enemy, 50, 50);
    }

    /** Overheating spell: 50 dmg, 40 mana */
    public void attackOverheating(Character enemy) {
        System.out.println(getCharacterName() + " attacks " + enemy.getCharacterName() + " with Attack Overheating (Damage: 50, Mana: 40)");
        damageTarget(enemy, 50, 40);
    }

    /** Recover spell: no mana cost */
    public void healthRejuvenation() {
        System.out.println(getCharacterName() + " casts Health Rejuvenation.");
        recover(20, 40);
    }
}
