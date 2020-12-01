
public class Direction {
	static String comy(int y1,int y2) {
        String d="";
        if(y1==y2)
            return d;
        else if(y1<y2)
            d+="N";
        else
            d+="S";
        return d;
	}
	static String com(int x1,int x2) {
        String d="";
        if(x1==x2)
            return d;
        else if(x1<x2)
            d+="E";
        else
            d+="W";
        return d;
	}
	static String test(int x1,int y1,int x2,int y2) {
	    return comy(y1,y2)+com(x1,x2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(test(0,0,1,-1));

	}

}
