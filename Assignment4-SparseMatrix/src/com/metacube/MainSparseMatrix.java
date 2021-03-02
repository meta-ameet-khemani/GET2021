package com.metacube;

/**
 * Main class to check working
 * @author ameet.khemani_metacu
 *
 */
public class MainSparseMatrix {

	public static void main(String[] args) {
		
		SparseMatrixUtility sparseMatrixUtility = new SparseMatrixUtility();
		int firstMatrix[][] = sparseMatrixUtility.getFirstTestMatrix();
		sparseMatrixUtility.displayMatrix(firstMatrix);
		int secondMatrix[][] = sparseMatrixUtility.getSecondTestMatrix();
		sparseMatrixUtility.displayMatrix(secondMatrix);
		
		int firstSparseMatrix[][] = sparseMatrixUtility.getSparseMatrix(firstMatrix);
		sparseMatrixUtility.displayMatrix(firstSparseMatrix);
		
		int secondSparseMatrix[][] = sparseMatrixUtility.getSparseMatrix(secondMatrix);
		sparseMatrixUtility.displayMatrix(secondSparseMatrix);
		
		SparseMatrixOperations matrixOperations = new SparseMatrixOperations();
		sparseMatrixUtility.displayMatrix(matrixOperations.getTranspose(firstSparseMatrix));
		
		sparseMatrixUtility.displayMatrix(matrixOperations.getTranspose(secondSparseMatrix));
		
		System.out.println();
		System.out.println(matrixOperations.isSymmetrical(firstMatrix));
		
		sparseMatrixUtility.displayMatrix(sparseMatrixUtility.getSparseMatrix(matrixOperations.add(firstMatrix, secondMatrix)));
		
		sparseMatrixUtility.displayMatrix(sparseMatrixUtility.getSparseMatrix(matrixOperations.multiply(firstMatrix, firstMatrix)));
	}
	
}
