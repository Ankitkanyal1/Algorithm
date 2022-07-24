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

//Question 2==> Two Sum II - Input Array Is Sorted || Time Complexity ==> O(n) 
/*Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
The tests are generated such that there is exactly one solution. You may not use the same element twice.
Your solution must use only constant extra space.

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int left=0;
        int right=n-1;
        int ans=0;
        while(left<right){
            ans=nums[left]+nums[right];
            if(target==ans){
                break;
            }
            else if(ans<target) left++;
            else right --;
        }
        return new int []{left+1,right+1};
    }
}

//Question 3 ==> Reverse String || Time Complexity ==> O(1)
/*Write a function that reverses a string. The input string is given as an array of characters s.
You must do this by modifying the input array in-place with O(1) extra memory.
Example 1:
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]*/

class Solution {
    public void reverseString(char[] s) {
        int n=s.length;
        int left=0;
        int right=n-1;
        char tempL;
        char tempR;
        while(left<right){
            tempL=s[left];
            tempR=s[right];
            s[left]=tempR;
            s[right]=tempL;
            left++;right--;
        }   
    }
}

/*Question 4 ==> Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.
Example :
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.*/

class Solution {
    public ListNode middleNode(ListNode head) {
      ListNode start=head,end=head;
        while(end!=null&&end.next!=null){
            start=start.next;
            end=end.next.next;
        }
        return start;
    }
}

