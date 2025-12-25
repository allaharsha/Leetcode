import java.util.HashSet;
import java.util.Set;

public class BiValued {

	public static int solution(int A[]) {
		if(A.length < 2) {
			return 0;
		}
		int max = 0;
		for(int i = 0;i<A.length-1;i++) {
			if(max >= A.length - i) {
				break;
			}
			int count = 0;
			Set<Integer> current = new HashSet<>();
			for(int j = i;j<A.length;j++) {
				if(current.contains(A[j]) || current.size()<2) {
					current.add(A[j]);
					count++;
				} else {
					break;
				}
			}
			max = count>max?count:max;		
		}
		
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A={4,5,5,4,5,6,7,7,7,7,6};
		System.out.println(solution(A));
	}

}
