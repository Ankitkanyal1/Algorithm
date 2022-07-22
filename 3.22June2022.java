// Two Pointer Approach 

//Question 1 ==> Move Zeroes || Time Complexity ==> O(n) || Space Complexity ==> O(1)
/*Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
*/
class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int temp;
        if(n==0||n==1) return ;
        int left=0;
        int right=0;
        while(right<n){
        //for(int i=right;i<n;i++){
            if(nums[right]==0) right++;
            else {
                temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                left++;right++;
            }
        }
    }
}  
