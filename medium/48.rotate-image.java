/*

[1,2,3]                  [1,4,7]                [7,4,1]
[4,5,6] ---transpose---> [2,5,8] ---reverse---> [8,5,2]
[6,7,8]                  [3,6,9]                [9,6,3]

*/


class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        for (int i = 0; i < matrix.length; i++) {
            reverse(matrix[i]);
        }
    }

    public void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }  

    public void reverse(int[] row) {
        for (int i = 0; i < row.length / 2; i++) {
            int temp = row[i];
            row[i] = row[row.length - i - 1];
            row[row.length - i - 1] = temp;
        }
    }
}