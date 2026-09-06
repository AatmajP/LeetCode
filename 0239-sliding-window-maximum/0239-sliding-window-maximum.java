class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];

        // First window
        for (int i = 0; i < k; i++) {

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);
        }

        res[0] = nums[dq.peekFirst()];

        // Remaining windows
        for (int i = k; i < nums.length; i++) {

            // Remove index outside the window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove smaller elements
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(i);

            // Maximum is at front
            res[i - k + 1] = nums[dq.peekFirst()];
        }

        return res;
    }
}