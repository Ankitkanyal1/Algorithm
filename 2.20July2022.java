// Without Two pointer approach
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] temp=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            temp[i]=nums[i]*nums[i];
        }
        Arrays.sort(temp);
        return temp;
    }
}

// Two Pointer Approach
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans=new int[nums.length];
        int left=0; int right=nums.length-1;
        for(int i=right;i>=0;i--){
            if(Math.abs(nums[left])>Math.abs(nums[right])){
                ans[i]=nums[left]*nums[left];
                left++;
            }
             else{
                 ans[i]=nums[right]*nums[right];
                 right--;
             }
    }      
     return ans;          
    }
}
