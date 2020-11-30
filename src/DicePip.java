import java.util.HashMap;
import java.util.Map;

public class DicePip {

	public static int solution(int[] A) {
        // write your code in Java SE 8
		Map<Integer,Integer> dices = new HashMap<>();
		
		for(int i = 0 ;i<A.length;i++) {
			if(dices.containsKey(A[i])) {
				dices.replace(A[i], dices.get(A[i])+1);
			} else {
				dices.put(A[i], 1);
			}
		}
		int minimum = 200;
		for(int i = 1 ;i<=6;i++) {
			int min = minimumForX(dices,i);
			minimum = min < minimum ? min : minimum;
		}
		
		return minimum;
    }
	
	public static int minimumForX(Map<Integer,Integer> dices, int val) {
		int count=0;
		for(Integer i:dices.keySet()) {
			if((val == 1 && i==6) || (val==2 && i==5) || (val==3 && i==4)) {
				count += dices.get(i)*2;
			} else if(val == i){
				continue;
			} else {
				count += dices.get(i);
			}
		}
		System.out.println(count);
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,6,2,3};
		System.out.println(solution(A));
	}

}
