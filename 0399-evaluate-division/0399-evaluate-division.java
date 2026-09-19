import java.util.*; 
 
class Solution { 
 
    Map<String, Map<String, Double>> graph; 
 
    double dfs(String current, String target, double value, 
               Set<String> visited) { 
 // Node does not exist
if (!graph.containsKey(current)) {
    return -1;
}

// Target found
if (current.equals(target)) {
    return value;
}
 
        visited.add(current); 
 
        for (String neighbor : graph.get(current).keySet()) { 
 
            if (!visited.contains(neighbor)) { 
 
                double weight = graph.get(current).get(neighbor); 
 
                double newValue = value * weight; 
 
                double result = dfs( 
                    neighbor, 
                    target, 
                    newValue, 
                    visited 
                ); 
 
                if (result != -1) { 
                    return result; 
                } 
            } 
        } 
 
        return -1; 
    } 
 
    public double[] calcEquation( 
        List<List<String>> equations, 
        double[] values, 
        List<List<String>> queries) { 
 
        graph = new HashMap<>(); 
 
        // Build graph 
        for (int i = 0; i < equations.size(); i++) { 
 
            String a = equations.get(i).get(0); 
            String b = equations.get(i).get(1); 
            double value = values[i]; 
 
            graph.putIfAbsent(a, new HashMap<>()); 
            graph.putIfAbsent(b, new HashMap<>()); 
 
            graph.get(a).put(b, value); 
            graph.get(b).put(a, 1.0 / value); 
        } 
 
        double[] answer = new double[queries.size()]; 
 
        // Answer each query 
        for (int i = 0; i < queries.size(); i++) { 
 
            String start = queries.get(i).get(0); 
            String target = queries.get(i).get(1); 
 
            Set<String> visited = new HashSet<>(); 
 
            answer[i] = dfs(start, target, 1.0, visited); 
        } 
 
        return answer; 
    } 
} 