
public class Convert {
	static int conv(String a) {
		int n=0;
		int p=1;
		char[] b=a.toCharArray();
		for(int i=b.length-1;i>=0;i--) {
			n+=Integer.parseInt(String.valueOf(b[i]))*p;
			p*=2;
		}
		
		return n;
	}
	public static void main(String[] args) {
		System.out.println(conv("10101"));

	}

}
