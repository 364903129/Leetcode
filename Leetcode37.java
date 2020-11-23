// ------------------------- sudoku solver ----------------------------
/* Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells. */

// Time complexity: O(9^m) where m is the number of blank space.
// Space complexity: O(n^2) where n is the length of the board.

class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    private boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == '.'){
                    for(char k = '1';k <='9';k++){
                        if(vaild(board, i, j, k)){
                            board[i][j] = k;
                            //if there are vaild numbers to put into the blank space, return to put another number
                            if(solve(board)){
                                return true;
                            //if no vaild numbers to put into the blank space, remove the number.
                            }else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    //tried all 9 numbers and not working
                    return false;
                }
            }
        }
        //put all the numbers into the blank space.
        return true;
    }
    
    private boolean vaild(char[][] board, int width, int height, char num){
        for(int i = 0; i < 9; i++){
            if(board[i][height] == num) return false;
            if(board[width][i] == num) return false;
            if(board[3 * (width / 3) + i / 3][3 * (height / 3) + i % 3] == num) return false;
        }
        return true;
    }
}
