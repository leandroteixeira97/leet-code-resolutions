import java.util.Arrays;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * Example 1:
 *
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [1]
 * Output: 1
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] example1 = {2, 2, 1};
        int[] example2 = {4,1,2,1,2};
        int[] example3 = {1};
        int[] example4 = {1,3,4,5,4,3,5,1,8,2,2,8,7,7,6};

        System.out.println(singleNumber(example1) == 1);
        System.out.println(singleNumber(example2) == 4);
        System.out.println(singleNumber(example3) == 1);
        System.out.println(singleNumber(example4) == 6);
    }

    public static int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 3) {
            if (nums[0] == nums[1]) {
                return nums[2];
            } else if (nums[0] == nums[2]) {
                return nums[1];
            }
            return nums[0];
        }

        Arrays.sort(nums);

        for (int pos = nums.length - 1; pos >= 0; pos--) {
            if ((pos - 1) <= 0) {
                return nums[0];
            }

            int current = nums[pos - 1];
            int next = nums[pos];

            if (current == next) {
                continue;
            }

            int before = nums[pos - 2];

            if (before != current) {
                return current;
            }

            if ((nums.length - 1) == (pos)) {
                return next;
            }
        }

        return nums[0];
    }
}
