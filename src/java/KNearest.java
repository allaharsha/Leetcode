import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class KNearest {

	public static List<List<Integer>> closestLocations(int totalCrates,List<List<Integer>> allLocations,int truckCapacity){
		List<List<Integer>> resultPoints = new ArrayList<>();
		HashMap<Integer,List<List<Integer>>> resultMap = new HashMap<>();
		List<Integer> keys = new ArrayList<>();
		for(List<Integer> point : allLocations) {
			int distance = point.get(0)*point.get(0)+point.get(1)*point.get(1);
			if(resultMap.get(distance) == null) {
				List<List<Integer>> newList = new ArrayList<>();
				newList.add(point);
	            resultMap.put(distance, newList);
	            keys.add(distance);
			} else {
				resultMap.get(distance).add(point);
			}
		}
		Collections.sort(keys);
		for(int i=0;i<keys.size();i++) {
			int count = resultMap.get(keys.get(i)).size();
			if(truckCapacity >= count) {
				resultPoints.addAll(resultMap.get(keys.get(i)));
				truckCapacity -= count;
			} else {
				for(int j=0; j<truckCapacity; j++) {
					resultPoints.add(resultMap.get(keys.get(i)).get(j));
				}
				break;
			}
		}
		return resultPoints;
	}

	public static void main(String[] args) {
		List<List<Integer>> points = new ArrayList<>();
		List<Integer> point = new ArrayList<>();
		point.add(1);
		point.add(2);
		points.add(point);
		point = new ArrayList<>();
		point.add(3);
		point.add(4);
		points.add(point);
		point = new ArrayList<>();
		point.add(4);
		point.add(3);
		points.add(point);
		point = new ArrayList<>();
		point.add(1);
		point.add(-1);
		points.add(point);
		
		System.out.println(closestLocations(4,points,3));
	}

}
