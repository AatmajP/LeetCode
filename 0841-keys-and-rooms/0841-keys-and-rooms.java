class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[rooms.size()];

        q.offer(0);
        visit[0] = true;

        while (!q.isEmpty()) {

            int room = q.poll();

            for (int nei : rooms.get(room)) {

                if (!visit[nei]) {
                    visit[nei] = true;
                    q.offer(nei);
                }
            }
        }

        for (boolean v : visit) {
            if (!v) {
                return false;
            }
        }

        return true;
    }
}