package java_control_flow.class_problems;

public class ArmstrongNum {
    public static void main(String[] args) {

        int num = 1534;
        int temp = num;
        int result = 0;

        while (num > 0) {
            int last = num % 10;
            result = result + (last * last * last * last);
            num = num / 10;
        }

        if (result == temp) {
            System.out.println("Armstrong Number");
        } else {
            System.out.println("Not Armstrong Number");
        }
    }
}