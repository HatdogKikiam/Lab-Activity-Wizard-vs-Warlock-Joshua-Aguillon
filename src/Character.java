/**
 * Base class for RPG characters with encapsulation and validation.
 */
public class Character {
    private String characterName;
    private int level;
    private int healthPoints;
    private int manaPoints;
    private static final int MAX_HP = 100;
    private static final int MAX_MANA = 200;

    // Default constructor
    public Character() {
        this.characterName = "Unnamed";
        this.level = 0;
        this.healthPoints = MAX_HP;
        this.manaPoints = MAX_MANA;
    }

    // 1-arg constructor
    public Character(String name) {
        this.characterName = name;
        this.level = 0;
        this.healthPoints = MAX_HP;
        this.manaPoints = MAX_MANA;
    }

    // Full parameterized constructor
    public Character(String name, int level, int hp, int mana) {
        this.characterName = name;
        this.level = Math.max(0, level);
        this.healthPoints = Math.min(Math.max(0, hp), MAX_HP);
        this.manaPoints = Math.min(Math.max(0, mana), MAX_MANA);
    }

    // Getters
    public String getCharacterName() { return characterName; }
    public int getLevel() { return level; }
    public int getHealthPoints() { return healthPoints; }
    public int getManaPoints() { return manaPoints; }

    // Setters with validation
    public void setHealthPoints(int hp) {
        this.healthPoints = Math.min(Math.max(0, hp), MAX_HP);
    }
    public void setManaPoints(int mana) {
        this.manaPoints = Math.min(Math.max(0, mana), MAX_MANA);
    }

    /**
     * Increase level.
     */
    public void levelUp(int levels) {
        this.level += Math.max(0, levels);
        System.out.println(characterName + " leveled up by " + levels + " levels! New level: " + this.level);
    }

    /**
     * Recover HP and Mana (no mana cost).
     */
    public void recover(int hpGain, int manaGain) {
        if (!isAlive()) {
            System.out.println(characterName + " is defeated and cannot recover.");
            return;
        }
        setHealthPoints(healthPoints + hpGain);
        setManaPoints(manaPoints + manaGain);
        System.out.println(characterName + " recovered +" + hpGain + " HP and +" + manaGain + " Mana.");
    }

    /**
     * Check if alive.
     */
    public boolean isAlive() {
        return healthPoints > 0;
    }

    /**
     * Damage target if possible.
     * @return true if damage applied
     */
    public boolean damageTarget(Character target, int damagePoints, int manaCost) {
        if (!isAlive()) {
            System.out.println(characterName + " is defeated and cannot attack.");
            return false;
        }
        if (manaPoints < manaCost) {
            System.out.println(characterName + " insufficient mana (" + manaPoints + "/" + manaCost + ").");
            return false;
        }
        if (!target.isAlive()) {
            System.out.println("Target " + target.getCharacterName() + " is already defeated.");
            return false;
        }

        System.out.println(characterName + " deals " + damagePoints + " damage to " + target.getCharacterName() + ".");
        target.setHealthPoints(target.getHealthPoints() - damagePoints);
        setManaPoints(manaPoints - manaCost);

        if (!target.isAlive()) {
            System.out.println("\n*** " + target.getCharacterName() + " has been defeated! ***");
        }
        return true;
    }

    /**
     * Display status.
     */
    public void displayStatus() {
        System.out.println("\n=== " + characterName + " Status ===");
        System.out.println("Level: " + level);
        System.out.println("HP: " + healthPoints + "/" + MAX_HP + (isAlive() ? "" : " (DEFEATED)"));
        System.out.println("Mana: " + manaPoints + "/" + MAX_MANA);
        System.out.println("========================\n");
    }

    /**
     * Introduce character.
     */
    public void introduce() {
        System.out.println("Character initialized: " + characterName);
    }
}
