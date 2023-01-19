class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

    if(matrix.length==1 && matrix[0].length == 1){
        if(target == matrix[0][0]){
            return true;
        }
    }       

    int row = 0;

	for(int i = 0; i<matrix.length; i++){
		if(target>matrix[i][0] && target<matrix[i][matrix[0].length-1]){
			row=i;
			break;
        }
        if(target == matrix[i][0] || target==matrix[i][matrix[0].length-1]){
			return true;
        }
    }

    int left =0;
    int right=matrix[0].length-1;
    while(left<=right){
        int mid = (left+right) / 2;
        if(matrix[row][mid]==target){
            return true;
        }
        if(matrix[row][mid]>target){
            right = mid-1;
        }else{
            left = mid+1;
        }
    }
    return false;
    }
}
