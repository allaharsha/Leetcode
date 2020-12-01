
public class EightHouses {

	static int[] eightHouses(int[] arr,int num) {
		
		int[] dup = new int[arr.length];
		for(int i=0;i<num;i++) {
			for(int j=0;j<arr.length;j++) {
				if(j==0) {
					if(arr[j+1]==0)
						dup[j] = 0;
					else
						dup[j] = 1;
				} else if(j == arr.length -1) {
					if(arr[j-1]==0)
						dup[j] = 0;
					else
						dup[j] = 1;
				} else {
					if(arr[j-1]==arr[j+1])
						dup[j] = 0;
					else
						dup[j] = 1;
				}
			}
			arr = dup;
			dup = new int[arr.length];
		}
		return arr;
	}
	public static void main(String[] args) {
		int[] arr= {1,1,1,0,1,1,1,1};
		int[] result = eightHouses(arr,2);
		for(int i=0;i<arr.length;i++) {
			System.out.print(result[i]+" ");
		}
	}
}
