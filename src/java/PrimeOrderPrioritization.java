import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimeOrderPrioritization {

	static List<String> sortOrders(List<String> orderList){
		List<String> result = new ArrayList<>();
		List<String> primeOrders = new ArrayList<>();
		List<String> nonPrimeOrders = new ArrayList<>();
		for(String orderId : orderList) {
			if(isPrimeOrder(orderId)) {
		        String[] arr = orderId.split(" ", 2);
				primeOrders.add(arr[1]+ " " +  "00000000"+arr[0]);
			} else {
				nonPrimeOrders.add(orderId);
			}
		}
		Collections.sort(primeOrders);
		System.out.println(primeOrders);
		List<String> resultPrimeOrders = new ArrayList<>();
		for(String primeOrderId : primeOrders) {
			String[] arr = primeOrderId.split(" ");
			String order = arr[arr.length-1].substring(8) + " "; 
			
			for(int i = 0 ; i < arr.length-1 ; i++ ) {
				order += arr[i] + " ";
			}
			resultPrimeOrders.add(order.substring(0,order.length()-1));
		}
		System.out.println(resultPrimeOrders);
		result.addAll(resultPrimeOrders);
		System.out.println(nonPrimeOrders);
		result.addAll(nonPrimeOrders);
		
		return result;
	}
	
	static boolean isPrimeOrder(String orderId) {
        String[] arr = orderId.split(" ", 2);
        return arr[1].matches(".*[a-zA-Z]+.*");
	}
	public static void main(String[] args) {
		List<String> orderList = new ArrayList<>();
		orderList.add("mi2 jog mid pet");
		orderList.add("wz3 34 54 398");
		orderList.add("al alps cow bar");
		orderList.add("x4 45 21 7");
		
		System.out.print(sortOrders(orderList));

	}

}
