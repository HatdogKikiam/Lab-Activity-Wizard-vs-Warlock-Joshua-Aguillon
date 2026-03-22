/**
 * Wizard subclass with fire-based spells.
 */
public class Wizard extends Character {

    public Wizard(String name) {
        super(name);
    }

    /** Firestorm spell: 55 dmg, 65 mana */
    public void fireStorm(Character enemy) {
        System.out.println(getCharacterName() + " attacks " + enemy.getCharacterName() + " with Firestorm (Damage: 55, Mana: 65)");
        damageTarget(enemy, 55, 65);
    }

    /** Time bomb spell: 55 dmg, 45 mana */
    public void timeBombAttack(Character enemy) {
        System.out.println(getCharacterName() + " attacks " + enemy.getCharacterName() + " with Time Bomb Attack (Damage: 55, Mana: 45)");
        damageTarget(enemy, 55, 45);
    }

    /** Recover spell: no mana cost */
    public void healthRejuvenation() {
        System.out.println(getCharacterName() + " casts Health Rejuvenation.");
        recover(20, 40);
    }
}
