// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class LocationDistanceTracker{
	int rowNumber;
	int columnNumber;
	int distanceFromSource;
	LocationDistanceTracker(int rowNumber,int columnNumber,int distanceFromSource){
		this.rowNumber = rowNumber;
		this.columnNumber = columnNumber;
		this.distanceFromSource = distanceFromSource;
	}
}


public class MinimumDistance{
	
    static // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int minimumDistance(int numRows, int numColumns, List<List<Integer>> area)
    {
	    LocationDistanceTracker initialPoint = new LocationDistanceTracker(0,0,0);
		boolean[][] visited = new boolean[numRows][numColumns];
		for(int i = 0;i < numRows; i++) {
			for(int j = 0; j< numColumns; j++) {
				if(area.get(i).get(j) == 0) {
					visited[i][j] = true;
				} else {
					visited[i][j] = false;
				}
			}
		}
		
		Queue<LocationDistanceTracker> trackerQueue = new LinkedList<>();
		trackerQueue.add(initialPoint);
		while(!trackerQueue.isEmpty()) {
			LocationDistanceTracker currentPoint = trackerQueue.peek();
			trackerQueue.poll();
			if(area.get(currentPoint.rowNumber).get(currentPoint.columnNumber) == 9) {
				return currentPoint.distanceFromSource;
			}
			
			if(currentPoint.rowNumber -1 >=0 && visited[currentPoint.rowNumber-1][currentPoint.columnNumber] == false) {
				trackerQueue.add(new LocationDistanceTracker(currentPoint.rowNumber -1,currentPoint.columnNumber,currentPoint.distanceFromSource+1));
				visited[currentPoint.rowNumber-1][currentPoint.columnNumber] = true;
			}
			
			if(currentPoint.rowNumber +1 < numRows && visited[currentPoint.rowNumber+1][currentPoint.columnNumber] == false) {
				trackerQueue.add(new LocationDistanceTracker(currentPoint.rowNumber +1,currentPoint.columnNumber,currentPoint.distanceFromSource+1));
				visited[currentPoint.rowNumber+1][currentPoint.columnNumber] = true;
			}
			
			if(currentPoint.columnNumber -1 >=0 && visited[currentPoint.rowNumber][currentPoint.columnNumber-1] == false) {
				trackerQueue.add(new LocationDistanceTracker(currentPoint.rowNumber,currentPoint.columnNumber-1,currentPoint.distanceFromSource+1));
				visited[currentPoint.rowNumber][currentPoint.columnNumber-1] = true;
			}
			
			if(currentPoint.columnNumber +1 < numRows && visited[currentPoint.rowNumber][currentPoint.columnNumber+1] == false) {
				trackerQueue.add(new LocationDistanceTracker(currentPoint.rowNumber,currentPoint.columnNumber+1,currentPoint.distanceFromSource+1));
				visited[currentPoint.rowNumber][currentPoint.columnNumber+1] = true;
			}
			
		}
		return -1;
    }
    
    public static void main(String args[]) {
    	List<List<Integer>> area = new ArrayList<>();
    	List<Integer> row1 = new ArrayList<>();
    	row1.add(1);
    	row1.add(1);
    	row1.add(1);
    	row1.add(1);
    	List<Integer> row2 = new ArrayList<>();
    	row2.add(0);
    	row2.add(1);
    	row2.add(1);
    	row2.add(1);
    	List<Integer> row3 = new ArrayList<>();
    	row3.add(0);
    	row3.add(1);
    	row3.add(0);
    	row3.add(1);
    	List<Integer> row4 = new ArrayList<>();
    	row4.add(1);
    	row4.add(1);
    	row4.add(9);
    	row4.add(1);
    	List<Integer> row5 = new ArrayList<>();
    	row5.add(0);
    	row5.add(0);
    	row5.add(1);
    	row5.add(1);
    	
    	area.add(row1);
    	area.add(row2);
    	area.add(row3);
    	area.add(row4);
    	area.add(row5);
		System.out.println(minimumDistance(5,4,area));
    }
}