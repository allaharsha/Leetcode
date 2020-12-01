import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SumOfTwo {

	public static void main(String[] args) {
		int[] input = {1,2,3,4,5,6,7};
		System.out.print(determineSumOfTwo(input,10));
	}

	private static boolean determineSumOfTwo(int[] input,int target) {
		Map<Integer,Integer> map= new HashMap<>();
		for(int i = 0;i<input.length;i++) {
			if(map.containsKey(input[i])) {
				int count = map.get(input[i]);
				map.remove(input[i]);
				map.put(input[i], count+1);
			} else {
				map.put(input[i], 1);
			}
		}
		//System.out.print(map);
		for(Entry<Integer, Integer> entry : map.entrySet()) {
			Integer key = entry.getKey();
			if(key == target-key && entry.getValue() > 1) {
				return true;
			} else if (map.containsKey(target-key)){
				return true;
			}
		}
		
		return false;
	}

}
