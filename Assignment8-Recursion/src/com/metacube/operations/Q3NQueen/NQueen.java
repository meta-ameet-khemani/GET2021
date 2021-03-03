package com.metacube.operations.Q3NQueen;

/**
 * NQueen problem
 * @author ameet.khemani_metacu
 *
 */
public class NQueen {
	
	/**
	 * printing chess board with queens position
	 * @param board
	 */
	private static void printSolution(int board[][]) {
		System.out.println();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(" " + board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * checking if next location is safe or not
	 * @param board
	 * @param row
	 * @param col
	 * @return true if safe else false
	 */
	private static boolean isSafe(int board[][], int row, int col) {
		
		boolean isSafe = true;
		
		// checking through columns
		for (int loopIndex = 0; loopIndex < col; loopIndex++) {
			if (board[row][loopIndex] == 1) {
				isSafe = false;
				break;
			}
		}
		
		// checking through diagonals
		for (int loopRowIndex = row, loopColIndex = col; loopRowIndex >= 0 && loopColIndex >= 0; loopRowIndex--, loopColIndex--) {
			if (board[loopRowIndex][loopColIndex] == 1) {
				isSafe = false;
				break;
			}
		}
		
		// checking through diagonals
		for (int loopRowIndex = row, loopColIndex = col; loopColIndex >= 0 && loopRowIndex < board.length; loopRowIndex++, loopColIndex--) {
			if (board[loopRowIndex][loopColIndex] == 1) {
				isSafe = false;
				break;
			}
		}
		
		return isSafe;
	}
	
	/**
	 * get chess board with queens positions
	 * @param board
	 * @param col
	 * @return true if there is possible solution else false
	 */
	private static boolean solveNQueen(int board[][], int col) {
		
		boolean isFurtherPossible = false;
		
		if (col >= board.length)
			return true;
		
		for (int i = 0; i < board.length; i++) {
			if (isSafe(board, i, col)) {
				board[i][col] = 1;
				if (solveNQueen(board, col + 1)) {
					isFurtherPossible = true;
					break;
				}
				board[i][col] = 0;
			}
		}
		return isFurtherPossible;
	}
	
	/**
	 * used to get the chess board with queens position
	 * @param size chess board size i.e size * size
	 * @return chess board with safe queens positions else blank chess board
	 */
	public static int[][] getNQueenSolution(int size) {
		int board[][] = new int[size][size];
		if (!solveNQueen(board, 0))
			board = new int[size][size];
		else
			printSolution(board);
		return board;
	}
	
}
