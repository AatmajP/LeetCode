class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // 1. Build graph
        ArrayList<ArrayList<double[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];

            // Undirected graph
            graph.get(u).add(new double[]{v, prob});
            graph.get(v).add(new double[]{u, prob});
        }

        // 2. Maximum probability known for each node
        double[] probability = new double[n];

        probability[start_node] = 1.0;

        // 3. Max Heap
        // [node, probability]
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b[1], a[1])
        );

        pq.offer(new double[]{start_node, 1.0});

        // 4. Traverse using maximum probability first
        while (!pq.isEmpty()) {

            double[] curr = pq.poll();

            int node = (int) curr[0];
            double currentProbability = curr[1];

            // Destination reached
            if (node == end_node) {
                return currentProbability;
            }

            // Explore neighbours
            for (double[] edge : graph.get(node)) {

                int neighbor = (int) edge[0];
                double edgeProbability = edge[1];

                // Probability of reaching neighbor
                double newProbability =
                    currentProbability * edgeProbability;

                // Found a better probability
                if (newProbability > probability[neighbor]) {

                    probability[neighbor] = newProbability;

                    pq.offer(new double[]{
                        neighbor,
                        newProbability
                    });
                }
            }
        }

        return 0.0;
    }
}
