package michael.multi.vault;

public class DescendingHackerThread extends HackerThread{
    public DescendingHackerThread(Vault vault) {
        super(vault);
    }

    @Override
    public void run() {
        for (int guess = VaultMain.MAX_PASSWORD; guess >= 0; guess--) {
            if (vault.isCorrectPassword(guess)) {
                System.out.println(this.getName() + " guessed the password " + guess);
                System.exit(0);
            }
        }
    }
}
