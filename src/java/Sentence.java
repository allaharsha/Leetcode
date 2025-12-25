import java.util.Arrays;

public class Sentence {
	static String find(String a) {
		char[] b=a.toCharArray();
		String[] delim= {" ",".","?","!"};
		int i=1;
		int j=0;
		for(i=b.length-2;i>=0;i--) {
			if(Arrays.asList(delim).contains(String.valueOf(b[i]))) {
				for(j=i-1;j>=0;j--)
					if(Arrays.asList(delim).contains(String.valueOf(b[j])))
						break;
				break;
			}
				
		}
		System.out.println(i);
		System.out.println(j);
		return a.substring(j+1,i);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(find("Hello world!java"));
	}

}
