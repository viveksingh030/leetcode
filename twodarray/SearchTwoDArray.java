//240. Search a 2D Matrix II
/*
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true
 */
class SearchTwoDArray {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length-1;
        int col=0;
        while(row>=0 && col<matrix[0].length){
            if(matrix[row][col]==target){
                return true;
            }
            if(matrix[row][col]>target){
                row--;
            }else{
                col++;
            }
        }
        return false;
    }
}