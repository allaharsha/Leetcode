public class HexDec {
	static String toBinary(int a) {
		String b="";
		while(a>0) {
			b=String.valueOf(a%2)+b;
			a=a/2;
		}
		while(b.length()!=4) {
			b="0"+b;
		}
		return b;
	}
	static String conv(String a) {
		String result="";
		char[] b=a.toCharArray();
		String hex="0123456789ABCDEF";
		for(int i=0;i<b.length;i++) {
			int c=hex.indexOf(Character.toUpperCase(b[i]));
			result+=toBinary(c);
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(conv("10AB"));

	}
}
