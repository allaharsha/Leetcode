import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumTruck {
	static List<Integer> truckSpace(int truckSpace, List<Integer> packagesSpace){
		truckSpace -=30;
		Set<Integer> set = new HashSet<>();
		for(Integer i: packagesSpace) {
			set.add(i);
		}
		while(set.size()>1) {
		Integer max = Collections.max(set);
		if(set.contains(truckSpace-max)) {
			if(max!=truckSpace/2) {
				List<Integer> result = new ArrayList<>();
				result.add(packagesSpace.indexOf(max));
				packagesSpace.remove(max);
				Integer second = packagesSpace.indexOf(truckSpace-max);
				if(second>= result.get(0)) {
					second++;
				}
				result.add(second);
				Collections.sort(result);
				return result;
			} else {
				if(count(packagesSpace,max)>=2) {
					List<Integer> result = new ArrayList<>();
					result.add(packagesSpace.indexOf(max));
					packagesSpace.remove(max);
					Integer second = packagesSpace.indexOf(truckSpace-max);
					if(second>= result.get(0)) {
						second++;
					}
					result.add(second);
					Collections.sort(result);
					return result;
				}
			}
			
		}
		set.remove(max);
		}
		return null;
	}
	
	static int count(List<Integer> list,int i) {
		int counter = 0;
		for(Integer j:list) {
			if(i==j)
				counter++;
		}
		return counter;
	}
	public static void main(String[] args) {
		List<Integer> input = new ArrayList<>();
		input.add(20);
		input.add(70);
		input.add(90);
		input.add(30);
		input.add(60);
		input.add(110);
		List<Integer> result = truckSpace(110, input);
		for(Integer i: result) {
			System.out.println(i);
		}
	}
}
