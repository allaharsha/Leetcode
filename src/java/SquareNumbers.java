import java.util.ArrayList;
import java.util.List;

public class SquareNumbers {

//	public static List<Integer> getMinimumUniqueSum(List<String> arr) {
//		List<Integer> result = new ArrayList<>();
//	    for(String str:arr) {
//	    	String[] input = str.split(" ");
//	    	Integer a = Integer.parseInt(input[0]);
//	    	Integer b = Integer.parseInt(input[1]);
//	    	Integer res = (int) (Math.floor(Math.sqrt(b))-Math.floor(Math.sqrt(a)));
//	    	result.add(res);
//	    }
//		return result;
//	    }
//	
	public static List<Integer> getMinimumUniqueSum(List<String> arr) {
	    // Write your code here
	    //System.out.println(arr.get(0)[0]);
	    List<Integer> result=new ArrayList<Integer>();
	    for(int i=0;i<arr.size();i++)
	    {
	    String[] pattern = arr.get(i).split("\\s");
	    int a=Integer.parseInt(pattern[0]);
	    int b=Integer.parseInt(pattern[1]);
	    result.add(squares(a,b));
	    }    
	    return result;
	    }

	    public static int squares(int a, int b) {
	     int count = (int)Math.floor(Math.sqrt(b)) - (int)Math.ceil(Math.sqrt(a)) + 1;  
	    return count;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> input = new ArrayList<>();
		input.add("1 9");
		input.add("2 9");
		input.add("4 10");
		input.add("2 10");
		
		List<Integer> result = getMinimumUniqueSum(input);
		for(Integer i: result) {
			System.out.println(i);
		}
	}

}
