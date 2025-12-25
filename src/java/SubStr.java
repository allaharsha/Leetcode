
public class SubStr {
	static String substr(String a) {
		//char[] b=a.toCharArray();
		String b;
		for(int i=1;i<=a.length()/2;i++) {
			b=a.substring(0, i);
			for(int j=i;j<=a.length()-i;j+=i) {
				String c=a.substring(j,j+i);
				System.out.println(b+"   "+c);
				if(!b.equals(c)) {
					System.out.println("break");
					break;
				}
				if(j==a.length()-i)
					return b.toString();
			}
		}
		return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(substr("hellohello"));
	}

}
