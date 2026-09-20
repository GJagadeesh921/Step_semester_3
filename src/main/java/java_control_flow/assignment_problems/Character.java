public class Character {

    private int health;
    private final int maxHealth;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {

        if (amount > 0) {
            health -= amount;

            if (health < 0) {
                health = 0;
            }

            System.out.println("Health after damage: " + health);
        } else {
            System.out.println("Damage rejected: amount must be positive");
        }
    }

    public void heal(int amount) {

        if (amount > 0) {
            health += amount;

            if (health > maxHealth) {
                health = maxHealth;
            }

            System.out.println("Health after healing: " + health);
        } else {
            System.out.println("Healing rejected: amount must be positive");
        }
    }

    public int getHealth() {
        return health;
    }

    public static void main(String[] args) {

        Character c = new Character(100);

        System.out.println("Initial health: " + c.getHealth());

        c.takeDamage(30);

        c.heal(50);

        c.takeDamage(150);

        System.out.println("Final health: " + c.getHealth());
    }
}
