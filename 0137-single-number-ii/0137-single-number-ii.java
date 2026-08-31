class Solution {
    public int singleNumber(int[] nums) {

        int[] count = new int[32];

        // Count 1s at every bit position
        for (int num : nums) {

            for (int j = 0; j < 32; j++) {

                if ((num & (1 << j)) != 0) {
                    count[j]++;
                }
            }
        }

        // Build the answer
        int result = 0;

        for (int j = 0; j < 32; j++) {

            if (count[j] % 3 == 1) {
                result = result | (1 << j);
            }
        }

        return result;
    }
}