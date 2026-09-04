import java.util.*;

public class RotateArray {

    public static int[] rotate(int[] nums, int k) {

        int n = nums.length;
        int[] newArray = new int[n];

        k = k % n;

        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }

        return newArray;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        int[] result = rotate(nums, k);

        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("K: " + k);
        System.out.println("Rotated Array: " + Arrays.toString(result));
    }
}
