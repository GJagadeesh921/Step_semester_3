
import java.util.Arrays;

public class PairSumSorted {

    static int[] pairSumSorted(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            }

            else if (sum < target) {
                left++;
            }

            else {
                right--;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        int[] arr1 = {-4, -1, 0, 3, 5, 9};
        int[] arr2 = {1, 2, 3};

        int[] result1 = pairSumSorted(arr1, 4);
        int[] result2 = pairSumSorted(arr2, 100);

        if (result1 != null) {
            System.out.println(Arrays.toString(result1));
        } else {
            System.out.println("Not Found");
        }

        if (result2 != null) {
            System.out.println(Arrays.toString(result2));
        } else {
            System.out.println("Not Found");
        }
    }
}
