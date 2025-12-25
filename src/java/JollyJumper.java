import java.util.Arrays;

public class JollyJumper {
	static  boolean check(int[] lst) {
		boolean b=true;
		int[] bool=new int[lst.length-1];
		int[] t = new int[lst.length-1];
		for(int i=0;i<a.length-1;i++) { 
			t[i]=Math.abs(lst[i]-lst[i+1]);
			//System.out.println(t[i]);
			if(t[i]==0 || t[i]>=lst.length)
				return false;
			if(bool[t[i]-1]==0) {
				bool[t[i]-1]=1;
				continue;
			}
			else
				return false;
		}
		return b;
	}
	public static void main(String[] args) {
		int[] lst={1,-1,0,3,7,7};
		System.out.println(check(lst));

	}

}
