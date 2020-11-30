import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


class Bamboo {

    /*
     * Complete the 'cutBamboo' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY lengths as parameter.
     */

    public static List<Integer> cutBamboo(List<Integer> lengths) {
    	List<Integer> count = new ArrayList<>();
    	Integer size = lengths.size();
    	if(size>0)
			count.add(size);
    	while(size>1){
        	List<Integer> list = new ArrayList<>();
    		int minimum = 1000;
    		for(Integer a:lengths) {
    			if(a<minimum)
    				minimum = a;
    		}
    		for(Integer a:lengths) {
    			if(a-minimum>0) {
    				list.add(a-minimum);
    			}
    		}
    		lengths = list; 
    		size = lengths.size();
    		if(size>0)
    			count.add(size); 		
    	}

    	return count;
    }
    
    public static void main(String[] args) throws IOException {

        List<Integer> lengths = new ArrayList<>();
        lengths.add(5);
        lengths.add(4);
        lengths.add(4);
        lengths.add(2);
        lengths.add(2);
        lengths.add(8);
//        for (int i = 0; i < lengthsCount; i++) {
//            int lengthsItem = Integer.parseInt(bufferedReader.readLine().trim());
//            lengths.add(lengthsItem);
//        }

        List<Integer> result = cutBamboo(lengths);

        for (Integer a : result) {
        	System.out.println(a);
        }
    }

}