/**
 * Main battle simulation between Wizard and Warlock.
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Wizards and Warlocks Battle!");

        Wizard zeus = new Wizard("Zeus");
        Warlock underlord = new Warlock("Underlord");

        zeus.introduce();
        underlord.introduce();

        System.out.println("\nLet the Battle Begin!\n");

        // Battle loop: alternate turns until one defeated
        boolean zeusTurn = true;  // Zeus starts
        while (zeus.isAlive() && underlord.isAlive()) {
            Character current = zeusTurn ? zeus : underlord;
            Character opponent = zeusTurn ? underlord : zeus;

            System.out.println("\n--- " + current.getCharacterName() + "'s Turn ---");
            current.displayStatus();

            // 80% chance attack, 20% recover (for demo)
            if (Math.random() < 0.8) {
                // Attack (choose random spell for variety)
                if (current instanceof Wizard) {
                    if (Math.random() < 0.5) {
                        ((Wizard) current).fireStorm(opponent);
                    } else {
                        ((Wizard) current).timeBombAttack(opponent);
                    }
                } else {
                    if (Math.random() < 0.5) {
                        ((Warlock) current).Poison(opponent);
                    } else {
                        ((Warlock) current).attackOverheating(opponent);
                    }
                }
            } else {
                // Recover
                if (current instanceof Wizard) {
                    ((Wizard) current).healthRejuvenation();
                } else {
                    ((Warlock) current).healthRejuvenation();
                }
            }

            opponent.displayStatus();
            zeusTurn = !zeusTurn;  // Switch turns
        }

        // Declare winner and level up
        if (zeus.isAlive()) {
            System.out.println("\n*** Victory! " + zeus.getCharacterName() + " wins! ***");
            zeus.levelUp(10);
            underlord.displayStatus();
        } else {
            System.out.println("\n*** Victory! " + underlord.getCharacterName() + " wins! ***");
            underlord.levelUp(10);
            zeus.displayStatus();
        }

        System.out.println("Battle Ended.");
    }
}
