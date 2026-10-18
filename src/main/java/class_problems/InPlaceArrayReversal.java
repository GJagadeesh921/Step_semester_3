
import java.util.Arrays;

public class InPlaceArrayReversal {

    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 44};

        reverseArray(arr);

        System.out.println(Arrays.toString(arr));
    }
}
