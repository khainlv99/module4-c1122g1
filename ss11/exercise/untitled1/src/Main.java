import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[0] < nums[i]) {
                max = nums[i];
                break;
            }
            if (nums[0] > nums[i]){
                min = nums[i];
                break;
            }
        }
        int[] nums1 =new int[nums.length+1];
        for (int j = min; j <= max; j++) {
            System.out.println(j);
//            nums1[] = j;
        };
        System.out.println(Arrays.toString(nums1));
    }
}