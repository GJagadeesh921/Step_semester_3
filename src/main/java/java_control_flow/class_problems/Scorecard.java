public class Scorecard {

    private final boolean[] results;
    private int answersRecorded;

    public Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
        answersRecorded = 0;
    }

    public void recordAnswer(boolean correct) {

        if (answersRecorded >= results.length) {
            System.out.println("Answer rejected: all questions are already recorded");
            return;
        }

        results[answersRecorded] = correct;
        answersRecorded++;

        System.out.println("Answer recorded");
    }

    public int getScore() {

        int score = 0;

        for (int i = 0; i < answersRecorded; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }

    public static void main(String[] args) {

        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Final score: " + sc.getScore());

        // Extra answer
        sc.recordAnswer(true);

        System.out.println("Score after extra answer: " + sc.getScore());
    }
}
