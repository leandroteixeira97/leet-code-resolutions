/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{2,7,11,15}, 9));
        System.out.println(twoSum(new int[]{3,2,4}, 6));
        System.out.println(twoSum(new int[]{0,4,3,0}, 0));
        System.out.println(twoSum(new int[]{-1,-2,-3,-4,-5}, -8));
    }

    public static int[] twoSum(int[] nums, int target) {
        int firstPos = 0;
        int lastPos = -1;

        for (int i = 0; i < nums.length; i++) {
            if (lastPos != -1) {
                break;
            }

            int element1 = nums[i];

            firstPos = i;

            for (int j = 0; j < nums.length; j++) {
                if (j == i)
                    continue;

                int element2 = nums[j];

                if ((element1 + element2) == target) {
                    lastPos = j;
                    break;
                }
            }
        }

        return new int[] { firstPos, lastPos };
    }
}