
public class MaxDistToClosest {
	//Maximize Distance to Closest Person
    public int maxDistToClosest(int[] seats) {
        int start = -1;
        int max = 0;
        int current = 0;
        for(int i = 0; i<seats.length; i++){
            if(seats[i]==0){
                current++;
            } else {
                if(start==-1){
                    max = current*2;
                } else if(current > max){
                    max = current;
                }
                start = i;
                current = 0;
            }
        }
        if(2 * current > max){
            max = current*2;;
        }
        return max%2==0? max/2 : (max+1)/2;
    }
}
