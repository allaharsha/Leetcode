import java.util.HashMap;
import java.util.Map;

public class Keyword {

	public static int entryTime(String s, String keypad) {
		int result = 0;
		Map<Integer,Integer> key = new HashMap<>();
		int row = 1;
		int column = 1;
		for(int i=1;i<=9;i++) {
			key.put(Integer.parseInt(keypad.substring(i-1,i)),row*10+column); 
			column++;
			if(i%3==0) {
				row++;
				column=1;
			}
		}
		int previous = 0;
		for(int i=0;i<s.length();i++) {
			int round = 0;
			int current = Integer.parseInt(s.substring(i,i+1));
			if(i==0) {
				previous = Integer.parseInt(s.substring(i,i+1));
				continue;
			}
			if(previous==current) {
				continue;
			} else {
				int p = key.get(previous);
				int c = key.get(current);
				round = Math.abs((p%10)-(c%10))>Math.abs((p/10)-(c/10))?Math.abs((p%10)-(c%10)):Math.abs((p/10)-(c/10));
				previous = current;
			}
			
			result += round;
		}
		
		
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(entryTime("423692","923857614"));
		}

}
