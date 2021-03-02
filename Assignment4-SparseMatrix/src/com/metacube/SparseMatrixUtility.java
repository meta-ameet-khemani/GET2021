package com.metacube;

/**
 * Sparse matrix utility class to 
 * getFakeMatrix, display matrix, get count of non-zero elements and generate sparse matrix out of normal matrix
 * @author ameet.khemani_metacu
 *
 */
public class SparseMatrixUtility {

	private final int ROWS = 3;
	private final int COLS = 3;
	
	public int[][] getFirstTestMatrix() {
		int matrix[][] = new int[ROWS][COLS];
		matrix[0][0] = 1;
		matrix[0][1] = 0;
		matrix[0][2] = 0;
		matrix[1][0] = 0;
		matrix[1][1] = 2;
		matrix[1][2] = 1;
		matrix[2][0] = 0;
		matrix[2][1] = 0;
		matrix[2][2] = 0;
		return matrix;
	}
	
	public int[][] getSecondTestMatrix() {
		int matrix[][] = new int[ROWS][COLS];
		matrix[0][0] = 0;
		matrix[0][1] = 0;
		matrix[0][2] = 2;
		matrix[1][0] = 0;
		matrix[1][1] = 5;
		matrix[1][2] = 0;
		matrix[2][0] = 1;
		matrix[2][1] = 0;
		matrix[2][2] = 4;
		return matrix;
	}
	
	/**
	 * shows matrix in tabular form
	 * @param matrix
	 */
	public void displayMatrix(int matrix[][]) {
		System.out.println();
		for (int rowCounter = 0; rowCounter < matrix.length; rowCounter++) {
			System.out.println();
			for (int colCounter = 0; colCounter < COLS; colCounter++)
				System.out.print(matrix[rowCounter][colCounter] + " ");
		}
	}
	
	/**
	 * gives count of total non-zero elements in matrix
	 * @param matrix of which non-zero elements to be counted
	 * @return number of non zero elements
	 */
	public int getCountOfNonZero(int matrix[][]) {
		int count = 0;
		for (int rowCounter = 0; rowCounter < ROWS; rowCounter++) {
			for (int colCounter = 0; colCounter < COLS; colCounter++)
				if (matrix[rowCounter][colCounter] != 0) {
					count++;
				}
		}
		return count;
	}

	/**
	 * generate sparse matrix from normal matrix
	 * @param matrix of which sparse to be get
	 * @return 2-d array as sparse matrix
	 */
	public int[][] getSparseMatrix(int matrix[][]) {
		int totalNonZeroElements = getCountOfNonZero(matrix);
		if (totalNonZeroElements == 0) {
			System.out.println("No non zero elements");
			return new int[][]{};
		} else {
			int sparseMatrix[][] = new int[totalNonZeroElements][3];
			int sparseMatrixRowNumber = 0;
			for (int rowCounter = 0; rowCounter < matrix.length; rowCounter++) {
				for (int colCounter = 0; colCounter < 3; colCounter++) {
					if (matrix[rowCounter][colCounter] != 0) {
						sparseMatrix[sparseMatrixRowNumber][0] = rowCounter;
						sparseMatrix[sparseMatrixRowNumber][1] = colCounter;
						sparseMatrix[sparseMatrixRowNumber][2] = matrix[rowCounter][colCounter];
						sparseMatrixRowNumber++;
					}
				}
			}
			return sparseMatrix;	
		}
	}
	
}
