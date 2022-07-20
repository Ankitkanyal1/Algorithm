// Binary Search Algorithm
class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length-1;
        int first=0;
        while(first<=n){
            int mid=(first+n)/2;
            if(nums[mid]<target){
                first=mid+1;
            }
            else if(nums[mid]==target){
               return mid;  
            }
            else{
                n=mid-1;
            }
            mid=(first+n)/2;
        }
        return -1;   
    }
}
