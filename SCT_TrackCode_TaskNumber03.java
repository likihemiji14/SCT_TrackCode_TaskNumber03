import java.util.Scanner;

public class SCT_TrackCode_TaskNumber03 {

    public static final int SIZE = 9;

    public static void main(String[] args) {
        int[][] board = new int[SIZE][SIZE];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Sudoku puzzle (use 0 for empty cells):");

        // Input from user
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print("Enter value for cell [" + row + "][" + col + "]: ");
                board[row][col] = scanner.nextInt();
            }
        }

        System.out.println("\nSolving the Sudoku puzzle...");

        if (solveSudoku(board)) {
            System.out.println("Solved Sudoku:");
            printBoard(board);
        } else {
            System.out.println("No solution exists for the given Sudoku puzzle.");
        }

        scanner.close();
    }

    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    for (int number = 1; number <= SIZE; number++) {
                        if (isValid(board, row, col, number)) {
                            board[row][col] = number;

                            if (solveSudoku(board)) {
                                return true;
                            } else {
                                board[row][col] = 0; // backtrack
                            }
                        }
                    }
                    return false; // trigger backtracking
                }
            }
        }
        return true; // puzzle solved
    }

    public static boolean isValid(int[][] board, int row, int col, int number) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == number || board[i][col] == number ||
                    board[row - row % 3 + i / 3][col - col % 3 + i % 3] == number) {
                return false;
            }
        }
        return true;
    }

    public static void printBoard(int[][] board) {
        for (int r = 0; r < SIZE; r++) {
            for (int d = 0; d < SIZE; d++) {
                System.out.print(board[r][d] + " ");
            }
            System.out.println();
        }
    }
}
