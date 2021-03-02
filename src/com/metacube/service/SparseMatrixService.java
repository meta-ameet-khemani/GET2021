package com.metacube.service;

/**
 * sparse matrix service to list down all possible operations on it
 * @author ameet.khemani_metacu
 */
public interface SparseMatrixService {
	
	int[][] getTranspose(int[][] matrix);
	
	boolean isSymmetrical(int[][] matrix);
	
	int[][] add(int[][] firstMatrix, int[][] secondMatrix);
	
	int[][] multiply(int[][] firstMatrix, int[][] secondMatrix);
	
}
