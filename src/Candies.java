import java.util.HashSet;
import java.util.Set;

public class Candies {

	public int solution(int[] T) {
        // write your code in Java SE 8
        Set<Integer> types = new HashSet<>();
        for(int i = 0;i<T.length;i++){
             types.add(T[i]);   
        }
        return (T.length/2)<types.size()?T.length/2:types.size();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
