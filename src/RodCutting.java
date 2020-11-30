import java.util.ArrayList;
import java.util.List;

public class RodCutting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> lengths = new ArrayList<>();
		lengths.add(5);
		lengths.add(4);
		lengths.add(4);
		lengths.add(2);
		lengths.add(2);
		lengths.add(8);
		System.out.println(cuttingRods(lengths));
	}

	static List<Integer> cuttingRods(List<Integer> lengths){
		List<Integer> result = new ArrayList<>();
		while(!lengths.isEmpty()) {
			result.add(lengths.size());
			Integer minimum = minimumLength(lengths);
			lengths = cutAndRemoveAllMinimums(lengths,minimum);			
		}
		
		return result;
	}
	
	static Integer minimumLength(List<Integer> lengths) {
		Integer minimum = Integer.MAX_VALUE;
		for(Integer i: lengths) {
			if(i<minimum)
				minimum = i;
		}
		
		return minimum;
	}
	
	static List<Integer> cutAndRemoveAllMinimums(List<Integer> lengths, Integer minimum){
		List<Integer> result = new ArrayList<>();
		for(Integer i: lengths) {
			if(i>minimum) {
				result.add(i-minimum);
			}
		}
		return result;
	}
}
