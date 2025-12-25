import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RankIndex {

	public static int rankIndex(List<List<Integer>> values, int rank) {
		List<Integer> totals = new ArrayList<>();
		for(List value : values) {
			int total = totalMarks(value);
			totals.add(total);
		}
		
		Integer[] totalsCopy = null;
		totalsCopy = totals.toArray(new Integer[totals.size()]);
		Arrays.sort(totalsCopy);
		Integer rankedMarks = totalsCopy[totalsCopy.length-rank];
		int count = 0;
		while(rank>1) {
			rank--;
			if(totalsCopy[totalsCopy.length-rank].equals(rankedMarks)) {
				count++;
			} else {
				break;
			}
		}
		for(int i = 0;i<totals.size();i++) {
			if(totals.get(i).equals(rankedMarks)) {
				if(count==0) {
					return i;
				} else {
					count--;
					continue;
				}
			}
		}
		return rank;
	    }
	
	
	
	private static int totalMarks(List<Integer> value) {
		Integer total = 0;
		for(Integer marks : value) {
			total += marks;
		}
		return total;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> input1 = new ArrayList<>();
		input1.add(80);
		input1.add(96);
		input1.add(81);
		input1.add(77);
		
		List<Integer> input2 = new ArrayList<>();
		input2.add(78);
		input2.add(71);
		input2.add(93);
		input2.add(75);
		
		List<Integer> input3 = new ArrayList<>();
		input3.add(71);
		input3.add(98);
		input3.add(70);
		input3.add(95);
		
		List<Integer> input4 = new ArrayList<>();
		input4.add(80);
		input4.add(96);
		input4.add(89);
		input4.add(77);
		
		List<List<Integer>> input = new ArrayList<>();
		input.add(input1);
		input.add(input2);
		input.add(input3);
		input.add(input4);
		
		System.out.print(rankIndex(input, 3));
	}
}
