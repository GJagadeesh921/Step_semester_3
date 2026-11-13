
import java.util.HashSet;

public class PairWithTargetSum {

    static boolean hasPairWithSum(int[] nums, int target) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {

            int complement = target - num;

            if (set.contains(complement)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {

        int[] arr1 = {2, 7, 11, 15};
        int[] arr2 = {3, 4, 6};

        System.out.println(hasPairWithSum(arr1, 9));
        System.out.println(hasPairWithSum(arr2, 20));
    }
}
