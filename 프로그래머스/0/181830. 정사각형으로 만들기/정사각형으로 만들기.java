import java.util.Arrays;

class Solution {
    public int[][] solution(int[][] arr) {
        int numRows = arr.length;
        int numCols = arr[0].length;
        
        if (numRows > numCols) {
            int[][] newArray = new int[numRows][numRows];
            
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    newArray[i][j] = arr[i][j];
                }
            }
            return newArray;
        }
        
        else if (numCols > numRows) {
            int[][] newArray = new int[numCols][numCols];
            
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    newArray[i][j] = arr[i][j];
                }
            }
            return newArray;
        }
        else {
            return arr;
        }
    }
}
