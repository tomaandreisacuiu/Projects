/**
 * Class that solves the Asterisk Sudoku. Prints the number of solutions of a
 * Sudoku if there are multiple. If there is only a single solution, prints this
 * solution instead. Asterisk Sudoku by Toma Sacuiu 1681591 and Bianca Neagoe
 * 1708287 as group 71
 */
class SudokuSolver {

    int SUDOKU_SIZE = 9; // Size of the grid.
    int SUDOKU_MIN_NUMBER = 1; // Minimum digit to be filled in.
    int SUDOKU_MAX_NUMBER = 9; // Maximum digit to be filled in.
    int SUDOKU_BOX_DIMENSION = 3; // Dimension of the boxes (sub-grids that should contain all digits).
    int rempty;
    int cempty;
    boolean row, col, ast, box; // Variables in which the row, column, asterisk and box are stored
    int[][] grid2 = new int[9][9]; // A new grid

    int[][] grid = new int[][] { // The puzzle grid; 0 represents empty.
            { 0, 9, 0, 7, 3, 0, 4, 0, 0 }, // One solution.
            { 0, 0, 0, 0, 0, 0, 5, 0, 0 }, { 3, 0, 0, 0, 0, 6, 0, 0, 0 },

            { 0, 0, 0, 0, 0, 2, 6, 4, 0 }, { 0, 0, 0, 6, 5, 1, 0, 0, 0 }, { 0, 0, 6, 9, 0, 7, 0, 0, 0 },

            { 5, 8, 0, 0, 0, 0, 0, 0, 0 }, { 9, 0, 0, 0, 0, 3, 0, 2, 5 }, { 6, 0, 3, 0, 0, 0, 8, 0, 0 }, };

    int solutionCounter = 0; // Solution counter

    // Is there a conflict when we fill in d at position (r, c)?
    boolean givesConflict(int r, int c, int d) {

        row = rowConflict(r, d);
        col = columnConflict(c, d);
        ast = asteriskConflict(r, c, d);
        box = boxConflict(r, c, d);

        if (row == false && col == false && ast == false && box == false) {
            return false;
        } else {
            return true;
        }
    }

    // Is there a conflict when we fill in d in row r?
    boolean rowConflict(int r, int d) {
        for (int i = 0; i < 9; i++) {
            if (grid[r][i] == d) {
                return true;
            }
        }
        return false;
    }

    // Is there a conflict in column c when we fill in d?
    boolean columnConflict(int c, int d) {
        for (int i = 0; i < 9; i++) {
            if (grid[i][c] == d) {
                return true;
            }
        }
        return false;
    }

    // Is there a conflict in the box at (r, c) when we fill in d?
    boolean boxConflict(int r, int c, int d) {
        if (r == 1 || r == 2) {
            r = 0;
        } else if (r == 4 || r == 5) {
            r = 3;
        } else if (r == 7 || r == 8) {
            r = 6;
        }

        if (c == 1 || c == 2) {
            c = 0;
        } else if (c == 4 || c == 5) {
            c = 3;
        } else if (c == 7 || c == 8) {
            c = 6;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (d == grid[r + i][c + j]) {
                    return true;
                }
            }
        }

        return false;
    }

    // Is there a conflict in the asterisk when we fill in d?
    boolean asteriskConflict(int r, int c, int d) {
        if (r == 1 && c == 4) {
            if (d == grid[2][2]) {
                return true;
            }
            if (d == grid[2][6]) {
                return true;
            }
            if (d == grid[4][1]) {
                return true;
            }
            if (d == grid[4][4]) {
                return true;
            }
            if (d == grid[4][7]) {
                return true;
            }
            if (d == grid[6][2]) {
                return true;
            }
            if (d == grid[6][6]) {
                return true;
            }
            if (d == grid[7][4]) {
                return true;
            }
        }

        if (r == 2 && c == 2) {
            if (d == grid[1][4]) {
                return true;
            }
            if (d == grid[2][6]) {
                return true;
            }
            if (d == grid[4][1]) {
                return true;
            }
            if (d == grid[4][4]) {
                return true;
            }
            if (d == grid[4][7]) {
                return true;
            }
            if (d == grid[6][2]) {
                return true;
            }
            if (d == grid[6][6]) {
                return true;
            }
            if (d == grid[7][4]) {
                return true;
            }
        }

        if (r == 2 && c == 6) {
            if (d == grid[1][4]) {
                return true;
            }
            if (d == grid[2][2]) {
                return true;
            }
            if (d == grid[4][1]) {
                return true;
            }
            if (d == grid[4][4]) {
                return true;
            }
            if (d == grid[4][7]) {
                return true;
            }
            if (d == grid[6][2]) {
                return true;
            }
            if (d == grid[6][6]) {
                return true;
            }
            if (d == grid[7][4]) {
                return true;
            }
        }

        if (r == 4 && c == 1) {
            if (d == grid[1][4]) {
                return true;
            }
            if (d == grid[2][2]) {
                return true;
            }
            if (d == grid[2][6]) {
                return true;
            }
            if (d == grid[4][4]) {
                return true;
            }
            if (d == grid[4][7]) {
                return true;
            }
            if (d == grid[6][2]) {
                return true;
            }
            if (d == grid[6][6]) {
                return true;
            }
            if (d == grid[7][4]) {
                return true;
            }
        }

        if (r == 4 && c == 4) {
            if (d == grid[1][4]) {
                return true;
            }
            if (d == grid[2][2]) {
                return true;
            }
            if (d == grid[2][6]) {
                return true;
            }
            if (d == grid[4][1]) {
                return true;
            }
            if (d == grid[4][7]) {
                return true;
            }
            if (d == grid[6][2]) {
                return true;
            }
            if (d == grid[6][6]) {
                return true;
            }
            if (d == grid[7][4]) {
                return true;
            }
        }

        if (r == 4 && c == 7) {
            if (d == grid[1][4]) {
                return true;
            }
            if (d == grid[2][2]) {
                return true;
            }
            if (d == grid[2][6]) {
                return true;
            }
            if (d == grid[4][1]) {
                return true;
            }
            if (d == grid[4][4]) {
                return true;
            }
            if (d == grid[6][2]) {
                return true;
            }
            if (d == grid[6][6]) {
                return true;
            }
            if (d == grid[7][4]) {
                return true;
            }
        }

        if (r == 6 && c == 2) {
            if (d == grid[1][4]) {
                return true;
            }
            if (d == grid[2][2]) {
                return true;
            }
            if (d == grid[2][6]) {
                return true;
            }
            if (d == grid[4][1]) {
                return true;
            }
            if (d == grid[4][4]) {
                return true;
            }
            if (d == grid[4][7]) {
                return true;
            }
            if (d == grid[6][6]) {
                return true;
            }
            if (d == grid[7][4]) {
                return true;
            }
        }

        if (r == 6 && c == 6) {
            if (d == grid[1][4]) {
                return true;
            }
            if (d == grid[2][2]) {
                return true;
            }
            if (d == grid[2][6]) {
                return true;
            }
            if (d == grid[4][1]) {
                return true;
            }
            if (d == grid[4][4]) {
                return true;
            }
            if (d == grid[4][7]) {
                return true;
            }
            if (d == grid[6][2]) {
                return true;
            }
            if (d == grid[7][4]) {
                return true;
            }
        }

        if (r == 7 && c == 4) {
            if (d == grid[1][4]) {
                return true;
            }
            if (d == grid[2][2]) {
                return true;
            }
            if (d == grid[2][6]) {
                return true;
            }
            if (d == grid[4][1]) {
                return true;
            }
            if (d == grid[4][4]) {
                return true;
            }
            if (d == grid[4][7]) {
                return true;
            }
            if (d == grid[6][2]) {
                return true;
            }
            if (d == grid[6][6]) {
                return true;
            }
        }

        return false;
    }

    // The method which finds the empty space
    int[] findEmptySquare() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }

    // Find all solutions for the grid, and stores the final solution.
    void solve() {
        if (findEmptySquare()[0] != -1) {

            int rempty = findEmptySquare()[0];
            int cempty = findEmptySquare()[1];

            for (int d = 1; d <= 9; d++) {
                if (givesConflict(rempty, cempty, d) != true) {
                    grid[rempty][cempty] = d;
                    solve();
                    grid[rempty][cempty] = 0;
                }
            }
        } else {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    grid2[i][j] = grid[i][j];
                }
            }
            solutionCounter++;
        }
    }

    // Print the sudoku grid.
    void print() {
        for (int i = 0; i < 19; i++) {
            if (i == 0 || i == 18) {
                System.out.print("+");
            } else {
                System.out.print("-");
            }
        }

        System.out.println();

        for (int i = 0; i < 9; i++) {
            System.out.print("|");

            for (int j = 0; j < 9; j++) {
                if ((i == 1 && j == 4) || (i == 2 && j == 6) || (i == 4 && j == 1) || (i == 4 && j == 4)
                        || (i == 4 && j == 7) || (i == 6 && j == 6) || (i == 7 && j == 4)) {
                    if (grid[i][j] == 0) {
                        System.out.print(" ");
                        System.out.print("<");
                    } else {
                        System.out.print(grid[i][j]);
                        System.out.print("<");
                    }
                } else if ((i == 1 && j == 3) || (i == 2 && j == 1) || (i == 4 && j == 0) || (i == 4 && j == 3)
                        || (i == 4 && j == 6) || (i == 6 && j == 1) || (i == 7 && j == 3)) {
                    if (grid[i][j] == 0) {
                        System.out.print(" ");
                        System.out.print(">");
                    } else {
                        System.out.print(grid[i][j]);
                        System.out.print(">");
                    }
                } else if (j == 2 || j == 5 || j == 8) {
                    if (grid[i][j] == 0) {
                        System.out.print(" ");
                        System.out.print("|");
                    } else {
                        System.out.print(grid[i][j]);
                        System.out.print("|");
                    }
                } else if (grid[i][j] == 0) {
                    System.out.print(" ");
                    System.out.print(" ");
                } else {
                    System.out.print(grid[i][j]);
                    System.out.print(" ");
                }
            }

            if (i == 2 || i == 5) {
                System.out.println();
                for (int k = 0; k < 19; k++) {
                    if (k == 0 || k == 18) {
                        System.out.print("+");
                    } else {
                        System.out.print("-");
                    }
                }
                System.out.println();
            } else {
                System.out.println();
            }
        }

        for (int i = 0; i < 19; i++) {
            if (i == 0 || i == 18) {
                System.out.print("+");
            } else {
                System.out.print("-");
            }
        }
    }

    // Run the actual solver.
    void solveIt() {
        solve();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = grid2[i][j];
            }
        }

        if (solutionCounter == 1) {
            print();
        } else if (solutionCounter > 1) {
            System.out.println(solutionCounter);
        }
    }

    public static void main(String[] args) {
        (new SudokuSolver()).solveIt();
    }
}