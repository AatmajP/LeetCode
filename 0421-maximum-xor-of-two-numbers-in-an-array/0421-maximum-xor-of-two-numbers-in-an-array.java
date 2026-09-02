class Solution {
    public int findMaximumXOR(int[] nums) {

        int maxXor = 0;
        int mask = 0;

        for (int bit = 31; bit >= 0; bit--) {

            mask = mask | (1 << bit);

            HashSet<Integer> set = new HashSet<>();

            for (int num : nums) {
                set.add(num & mask);
            }

            int candidate = maxXor | (1 << bit);

            boolean found = false;

            for (int prefix : set) {

                int required = prefix ^ candidate;

                if (set.contains(required)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                maxXor = candidate;
            }
        }

        return maxXor;
    }
}