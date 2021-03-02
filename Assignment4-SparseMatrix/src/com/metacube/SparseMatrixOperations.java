package com.metacube;

import com.metacube.service.SparseMatrixService;

/**
 * Sparse matrix service methods implementation
 * @author ameet.khemani_metacu
 *
 */
public class SparseMatrixOperations implements SparseMatrixService {

	/**
	 * used to get transpose of matrix
	 * @param matrix of which transpose to be get
	 * @return 2-d array as transposed matrix
	 */
	@Override
	public int[][] getTranspose(int[][] matrix) {
		int transposeMatrix[][] = new int[matrix.length][3];
		for (int rowCounter = 0; rowCounter < matrix.length; rowCounter++) {
			transposeMatrix[rowCounter][0] = matrix[rowCounter][1];
			transposeMatrix[rowCounter][1] = matrix[rowCounter][0];
			transposeMatrix[rowCounter][2] = matrix[rowCounter][2];
		}
		return transposeMatrix;
	}

	/**
	 * checks whether passed matrix is symmetrical or not
	 * @param matrix of which transpose to be get
	 * @return true if is symmetrical else false
	 */
	@Override
	public boolean isSymmetrical(int[][] matrix) {
		int transposeMatrix[][] = getTranspose(matrix);
		for (int rowCounter = 0; rowCounter < matrix.length; rowCounter++) {
			for (int colCounter = 0; colCounter < matrix[0].length; colCounter++) {
				if (transposeMatrix[rowCounter][colCounter] != matrix[rowCounter][colCounter]) {
					return false;
				}
			}
		}
		return true;
	}

	/***
	 * adds 2 passed matrices
	 * @param1 firstMatrix as first matrix
	 * @param2 firstMatrix as first matrix
	 * return added matrix of 2
	 */
	@Override
	public int[][] add(int[][] firstMatrix, int[][] secondMatrix) {
		int firstMatrixRowCount = firstMatrix.length;
		int firstMatrixColumnCount = firstMatrix[0].length;
		int secondMatrixRowCount = secondMatrix.length;
		int secondMatrixColumnCount = secondMatrix[0].length;
		if (firstMatrixRowCount != secondMatrixRowCount &&
				firstMatrixColumnCount != secondMatrixColumnCount) {
			System.out.println("Addition not possible");
			return null;	
		} else {
			int addedMatrix[][] = new int[firstMatrixRowCount][firstMatrixColumnCount];
			for (int rowCounter = 0; rowCounter < firstMatrixRowCount; rowCounter++) {
				for (int colCounter = 0; colCounter < firstMatrixColumnCount; colCounter++) {
					addedMatrix[rowCounter][colCounter] = firstMatrix[rowCounter][colCounter] + secondMatrix[rowCounter][colCounter];
				}
			}
			return addedMatrix;
		}
	}

	/***
	 * multiply 2 passed matrices
	 * @param1 firstMatrix as first matrix
	 * @param2 firstMatrix as first matrix
	 * return multiplied matrix of 2
	 */
	@Override
	public int[][] multiply(int[][] firstMatrix, int[][] secondMatrix) {
		int firstMatrixRowCount = firstMatrix.length;
		int firstMatrixColumnCount = firstMatrix[0].length;
		int secondMatrixRowCount = secondMatrix.length;
		int secondMatrixColumnCount = secondMatrix[0].length;
		if (firstMatrixColumnCount != secondMatrixRowCount) {
			System.out.println("Multiplication not possible");
			return null;	
		} else {
			int multipliedMatrix[][] = new int[firstMatrixRowCount][secondMatrixColumnCount];
			for (int rowCounter = 0; rowCounter < firstMatrixRowCount; rowCounter++) {
				for (int colCounter = 0; colCounter < firstMatrixColumnCount; colCounter++) {
					multipliedMatrix[rowCounter][colCounter] = 0;
					for (int multipliedMatrixCounter = 0; multipliedMatrixCounter < firstMatrixColumnCount; multipliedMatrixCounter++) {
						multipliedMatrix[rowCounter][colCounter] += firstMatrix[rowCounter][multipliedMatrixCounter] * secondMatrix[multipliedMatrixCounter][colCounter];	
					}
				}
			}
			return multipliedMatrix;
		}
	}

}
