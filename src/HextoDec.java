
public class HextoDec {
	static int convert(String a) {
		String hex="0123456789ABCDEF";
		int result=0;
		int p=1;
		for(int i=a.length()-1;i>=0;i--) {
			int j=hex.indexOf(a.substring(i, i+1));
			result+=j*p;
			p*=16;
		}
		return result;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(convert("BA"));
	}
}