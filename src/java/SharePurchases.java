
public class SharePurchases {

	public static long analyzeInvestments(String s) {
		long count = 0;
	    for(int i = 0;i<s.length();i++) {
	    	for(int j = i+2; j<=s.length();j++) {
	    		String str = s.substring(i,j);
	    		if(str.length()>2 && str.contains("A") && str.contains("B") && str.contains("C")) {
	    			count++;
	    		}
	    	}
	    }
	    return count;
	    }
	
	public static void main(String[] args) {
		System.out.print(analyzeInvestments("ABBCZBAC"));
	}

}
