class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inde = new int[numCourses];

        for (int[] i : prerequisites) {
            int course = i[0];
            int pre = i[1];

            graph.get(pre).add(course);
            inde[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inde[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;

            for (int nei : graph.get(cur)) {
                inde[nei]--;

                if (inde[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        return count == numCourses;
    }
}