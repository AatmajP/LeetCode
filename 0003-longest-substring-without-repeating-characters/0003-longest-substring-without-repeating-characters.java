class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int max = 0;

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {

            while (set.contains(s.charAt(i))) {

                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(i));

            int idx = i - left + 1;

            max = Math.max(max, idx);
        }

        return max;
    }
}