import java.util.Arrays;

public class HackathonScoreCurveBooster {

    static void curveScores(int[] scores, int bonus) {

        for (int i = 0; i < scores.length; i++) {
            scores[i] = scores[i] + bonus;
        }
    }

    public static void main(String[] args) {

        int[] scores = {70, 85, 60};
        int bonus = 10;

        System.out.println("Original Scores: " + Arrays.toString(scores));

        curveScores(scores, bonus);

        System.out.println("Bonus: " + bonus);
        System.out.println("Updated Scores: " + Arrays.toString(scores));
    }
}
