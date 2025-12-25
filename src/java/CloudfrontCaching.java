import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.ArrayList;
import java.util.HashMap;

public class CloudfrontCaching {

    static Map<Integer, List<Integer>> visitedNodes;
    static boolean[] visited;
    
    private static int doBFS(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(start);
        visited[start] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            cnt++;
            if (!visitedNodes.containsKey(cur)) continue;
            for (int next : visitedNodes.get(cur)) {
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
        return (int)(Math.ceil(Math.sqrt(cnt)));
    }
    public static int getEfficiencyOfCloudFrontCaching(int N, int[][] edges) {
    	visitedNodes = new HashMap<>();
        visited = new boolean[N];
        for (int i=0; i<edges.length; ++i) {
            int src = edges[i][0]-1, dest = edges[i][1]-1;
            if (!visitedNodes.containsKey(src)) visitedNodes.put(src, new ArrayList<>());
            if (!visitedNodes.containsKey(dest)) visitedNodes.put(dest, new ArrayList<>());
            visitedNodes.get(src).add(dest);
            visitedNodes.get(dest).add(src);
        }

        int res = 0;
        for (int i=0; i<N; ++i) {
            if (!visited[i]) res += doBFS(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] edges1 = {{1, 2}, {3, 4}, {5, 6}, {9, 10}, {7, 8}};
        System.out.println(getEfficiencyOfCloudFrontCaching(10, edges1));
        int[][] edges2 = {{1, 2}, {1, 4}};
        System.out.println(getEfficiencyOfCloudFrontCaching(4, edges2));
        int[][] edges3 = {{8, 1}, {5, 8}, {7, 3}, {8, 6}};
        System.out.println(getEfficiencyOfCloudFrontCaching(8, edges3));
    }
}