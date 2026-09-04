import java.util.*;

public class BmiCalculator {

    public static String getBmiStatus(double bmi) {

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {

        System.out.println("----- Team Wellness Report -----");
        System.out.printf("%-10s %-12s %-12s %-12s%n",
                "Member", "Height(m)", "Weight(kg)", "BMI");

        for (int i = 0; i < heights.length; i++) {

            double bmi = weights[i] / (heights[i] * heights[i]);

            System.out.printf("%-10d %-12.2f %-12.2f %-12.2f%n",
                    i + 1, heights[i], weights[i], bmi);

            System.out.println("Status: " + getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {

        double[] heights = {1.70, 1.65, 1.80, 1.75, 1.60};
        double[] weights = {65, 70, 85, 60, 80};

        printWellnessReport(heights, weights);
    }
}
