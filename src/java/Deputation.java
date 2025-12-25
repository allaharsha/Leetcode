
public class Deputation {
	public static int deputation(int m,int w) {
		int result = 0;
		if(m == 0 || w ==0 )
			return result;
		if(w>=2) {
			result += m*(factorial(w)/(factorial(w-2)*2));
		}
		if(m>=2) {
			result += w*(factorial(m)/(factorial(m-2)*2));
		}
		
		return result;
	}

	public static int factorial(int a) {
		int result=1;
		//if(a==0||a==1) {
		//	return 1;
		//}
		while(a>1) {
			result*=a;
			a--;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(deputation(1,2));
	}
}
