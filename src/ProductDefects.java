import java.util.ArrayList;
import java.util.List;

public class ProductDefects {
	public static int minimum (int x, int y, int z) {
		return Integer.min(Integer.min(x, y), z);
	}

	// Function to find the size of largest square sub-matrix of 1's
	// present in the given binary matrix
	public static int findLargestSquare(List<List<Integer>> oneBigSquare)
	{
		// T[i][j] stores the size of maximum square
		// sub-matrix ending at M[i][j]
		List<List<Integer>> maxSquareSizes = new ArrayList<>();
		for(int i = 0;i<oneBigSquare.size();i++) {
			List<Integer> row = new ArrayList<>();
			maxSquareSizes.add(row);
		}

		int maxSquareSize = 0;

		// fill in bottom-up manner
		for (int i = 0; i < oneBigSquare.size(); i++)
		{
			for (int j = 0; j < oneBigSquare.get(0).size(); j++)
			{
				maxSquareSizes.get(i).add(j,oneBigSquare.get(i).get(j));

				// if we are not at the first row or first column and
				// current cell has value 1
				if (i > 0 && j > 0 && oneBigSquare.get(i).get(j) == 1)
				{
					// largest square sub-matrix ending at M[i][j] will be
					// 1 plus minimum of largest square sub-matrix
					// ending at M[i][j-1], M[i-1][j] and M[i-1][j-1]

					maxSquareSizes.get(i).add(j,minimum(maxSquareSizes.get(i).get(j-1), maxSquareSizes.get(i-1).get(j),
									maxSquareSizes.get(i-1).get(j-1)) + 1);
				}

				// update maximum size found so far
				if (maxSquareSize < maxSquareSizes.get(i).get(j)) {
					maxSquareSize = maxSquareSizes.get(i).get(j);
				}
			}
		}

		// return size of largest square matrix
		return maxSquareSize;
	}

	public static void main(String[] args)
	{
		// input boolean matrix
		int mat[][] =
		{
			{ 0, 0, 1, 0, 1, 1 },
			{ 0, 1, 1, 1, 0, 0 },
			{ 0, 0, 1, 1, 1, 1 },
			{ 1, 1, 0, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 0, 1, 1, 1 },
			{ 1, 0, 1, 1, 1, 1 },
			{ 1, 1, 1, 0, 1, 1 }
		};
		
		List<List<Integer>> r = new ArrayList<>();
		List<Integer> row1 = new ArrayList<>();
		row1.add(0);
		row1.add(0);
		row1.add(1);
		row1.add(0);
		row1.add(1);
		row1.add(1);
		List<Integer> row2 = new ArrayList<>();
		row2.add(0);
		row2.add(1);
		row2.add(1);
		row2.add(1);
		row2.add(0);
		row2.add(0);
		List<Integer> row3 = new ArrayList<>();
		row3.add(0);
		row3.add(0);
		row3.add(1);
		row3.add(1);
		row3.add(1);
		row3.add(1);
		List<Integer> row4 = new ArrayList<>();
		row4.add(1);
		row4.add(1);
		row4.add(0);
		row4.add(1);
		row4.add(1);
		row4.add(1);
		List<Integer> row5 = new ArrayList<>();
		row5.add(1);
		row5.add(1);
		row5.add(1);
		row5.add(1);
		row5.add(1);
		row5.add(1);

		List<Integer> row6 = new ArrayList<>();
		row6.add(1);
		row6.add(1);
		row6.add(0);
		row6.add(1);
		row6.add(1);
		row6.add(1);
		List<Integer> row7 = new ArrayList<>();
		row7.add(1);
		row7.add(0);
		row7.add(1);
		row7.add(1);
		row7.add(1);
		row7.add(1);
		List<Integer> row8 = new ArrayList<>(); 
		row8.add(1);
		row8.add(1);
		row8.add(1);
		row8.add(0);
		row8.add(1);
		row8.add(1);
		
		
		r.add(row1);
		r.add(row2);
		r.add(row3);
		r.add(row4);
		r.add(row5);
		r.add(row6);
		r.add(row7);
		r.add(row8);
		

		System.out.print("The size of largest square sub-matrix of 1's is " +
				findLargestSquare(r));
	}
}
