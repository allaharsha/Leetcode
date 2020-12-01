import java.util.ArrayList;
import java.util.List;

public class MergeSortedLists {

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(4);
		System.out.print(mergeLists(list1,list2));
	}

	private static List<Integer> mergeLists(List<Integer> list1, List<Integer> list2) {
		List<Integer> result = new ArrayList<>();
		int j = 0;
		for(int i=0;i<list1.size();i++) {
			if(j<list2.size() && list1.get(i)<list2.get(j)) {
				result.add(list1.get(i));
			} else if (j<list2.size()){
				result.add(list2.get(j));
				j++;
				i--;
			} else {
				result.add(list1.get(i));
			}
		}
		while(j<list2.size()) {
			result.add(list2.get(j));
			j++;
		}
		return result;
	}

}
