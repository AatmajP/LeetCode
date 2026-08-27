class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String sn : strs) {

            char[] s = sn.toCharArray();

            Arrays.sort(s);

            String sy = new String(s);

            if (!map.containsKey(sy)) {
                map.put(sy, new ArrayList<>());
            }

            map.get(sy).add(sn);
        }

        return new ArrayList<>(map.values());
    }
}