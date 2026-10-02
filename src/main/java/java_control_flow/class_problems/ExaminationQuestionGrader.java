import java.util.Scanner;

abstract class Question {
    protected double points;

    public Question(double points) {
        this.points = points;
    }

    public abstract double calculateScore(String answer);

    public abstract String getType();
}

class MCQQuestion extends Question {
    private String correctAnswer;

    public MCQQuestion(double points, String correctAnswer) {
        super(points);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public double calculateScore(String answer) {
        if (answer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }

        return 0;
    }

    @Override
    public String getType() {
        return "MCQ";
    }
}

class TrueFalseQuestion extends Question {
    private String correctAnswer;

    public TrueFalseQuestion(double points, String correctAnswer) {
        super(points);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public double calculateScore(String answer) {
        if (answer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }

        return 0;
    }

    @Override
    public String getType() {
        return "TRUE_FALSE";
    }
}

class EssayQuestion extends Question {
    private String keyword1;
    private String keyword2;

    public EssayQuestion(
            double points,
            String keyword1,
            String keyword2) {

        super(points);
        this.keyword1 = keyword1;
        this.keyword2 = keyword2;
    }

    @Override
    public double calculateScore(String answer) {

        int matches = 0;

        if (answer.toLowerCase().contains(
                keyword1.toLowerCase())) {
            matches++;
        }

        if (answer.toLowerCase().contains(
                keyword2.toLowerCase())) {
            matches++;
        }

        if (matches >= 2) {
            return points * 0.75;
        } else if (matches == 1) {
            return points * 0.50;
        }

        return 0;
    }

    @Override
    public String getType() {
        return "ESSAY";
    }
}

public class ExaminationQuestionGrader {

    public static Question createQuestion(
            String type,
            double points,
            String answerKey1,
            String answerKey2) {

        switch (type) {

            case "MCQ":
                return new MCQQuestion(
                        points, answerKey1);

            case "TRUE_FALSE":
                return new TrueFalseQuestion(
                        points, answerKey1);

            case "ESSAY":
                return new EssayQuestion(
                        points,
                        answerKey1,
                        answerKey2);

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double totalScore = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.nextLine();
            double points = Double.parseDouble(
                    sc.nextLine());

            String key1 = sc.nextLine();
            String key2 = sc.nextLine();
            String answer = sc.nextLine();

            Question question = createQuestion(
                    type,
                    points,
                    key1,
                    key2
            );

            double score =
                    question.calculateScore(answer);

            System.out.printf(
                    "%s: %.2f%n",
                    question.getType(),
                    score
            );

            totalScore += score;
        }

        System.out.printf(
                "Total Score: %.2f%n",
                totalScore
        );

        sc.close();
    }
}
