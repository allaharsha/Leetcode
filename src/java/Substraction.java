
public class Substraction {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(difference(2437,875));
	}

	private static int difference(int i, int j) {
		// TODO Auto-generated method stub
		while(i!=j) {
			if(i>j)
				i=i-j;
			else if(i<j)
				j=j-i;
		}
		return i;
	}

}
