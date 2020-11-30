
public class SingleNonDuplicate {

	public static void main(String[] args) {
		int[] arr = {1,1,2,2,3,3,4,5,5,6,6};
		System.out.print(singleNonDuplicate(arr));
	}
	
	static int singleNonDuplicate(int[] nums) {
		int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            boolean halvesAreEven = (hi - mid) % 2 == 0;
            if (nums[mid + 1] == nums[mid]) {
                if (halvesAreEven) {
                    lo = mid + 2;
                } else {
                    hi = mid - 1;
                }
            } else if (nums[mid - 1] == nums[mid]) {
                if (halvesAreEven) {
                    hi = mid - 2;
                } else {
                    lo = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[lo];
	}

}
