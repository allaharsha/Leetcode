import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KClosestPoints {
	public int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][2];
        List<Integer> distances = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i<points.length; i++){
            int distance = points[i][0]*points[i][0]+points[i][1]*points[i][1];
            if(!map.containsKey(distance)){
                distances.add(distance);
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                map.put(distance,indices);
            } else {
                map.get(distance).add(i);
            }
        }
        Collections.sort(distances);
        int i = 0;
        for(Integer distance: distances){
            for(Integer index:map.get(distance)){
                if(i<K){
                    int[] point = new int[2];
                    point[0] = points[index][0];
                    point[1] = points[index][1];
                    result[i] = point;     
                    i++;
                } else {
                    break;
                }
            }
            if(i>=K){
                break;
            }
        }
        return result;
    }
}
