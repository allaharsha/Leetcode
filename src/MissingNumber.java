import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber {

	static int returnMissingNumber(int[] input) {
		int total = input.length*(input.length+1)/2;
		int sum = 0;
		for(int i = 0;i < input.length-1 ;i++) {
			sum += input[i];
		}
		return total-sum;
	}
	
	public static void main(String[] args) {
		int[] input = {1,2,3,4,5,6,8};
		System.out.print(returnMissingNumber(input));
	}

}
