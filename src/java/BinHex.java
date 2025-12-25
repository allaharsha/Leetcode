
public class BinHex {
	static int toDecimal(String a) {
		int p=1;
		int result=0;
		for(int i=a.length()-1;i>=0;i--) {
			result+=Integer.parseInt(a.substring(i, i+1))*p;
			p*=2;
		}
		return result;
	}
static String bintohex(String a) {
	String hex="0123456789ABCDEF";
	String result="";
	while(a.length()%4!=0)
		a="0"+a;
	for(int i=0;i<=a.length()-4;i+=4) {
		//System.out.println(a.substring(i, i+4));
		int j=toDecimal(a.substring(i, i+4));
		result+=hex.charAt(j);
	}
	return result;
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(bintohex("00001111"));
	}

}
