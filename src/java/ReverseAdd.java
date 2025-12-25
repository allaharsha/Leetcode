
public class ReverseAdd {
	static int reverse(int n) {
	    int su=0;
	    while (n>0) {
	        int s=n%10;
	        n=n/10;
	        su=su*10+s;
	    }
	    return su;
	}

	static int reverseAdd(int n) {
	    return n+reverse(n);
	}

	static boolean pal(int n) {
	    if (n==reverse(n))
	        return true;
	    else
	        return false;
	}
	
	static int test(int n) {
	    n=reverseAdd(n);
	    int count=0;
	    while(!pal(n)) {
	        n=reverseAdd(n);
	        count+=1;
	    }
	    return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(test(525));

	}

}
