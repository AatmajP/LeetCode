import java.util.*;

class Solution {
    public int minMoves2(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;
        int target = nums[n / 2];

        int operations = 0;

        for (int i = 0; i < nums.length; i++) {
            operations += Math.abs(nums[i] - target);
        }

        return operations;
    }
}