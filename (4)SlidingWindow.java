/*Question 1 ==>  Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without repeating characters.
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Time Complexity ==> O(n)
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen=new HashSet();
        int left=0,right=0;
        int max=0;
        while(right<s.length()){
            char c=s.charAt(right);
            if(seen.add(c)){
                max=Math.max(max,right-left+1);
                right++;
            }
            else{
                while(s.charAt(left)!=c){
                    seen.remove(s.charAt(left));
                    left++;
                }
                seen.remove(c);
                left++;
            }
        }
        return max;
    }
}

/*Question 2 ==> Permutation in String
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.
Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

Time Complexity ==> O(n) */

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1=s1.length();
        int l2=s2.length();
        int[] count=new int[26];
        for(int i=0;i<l1;i++){
            count[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<l2;i++){
            count[s2.charAt(i)-'a']--;
            if(i-l1>=0){
                count[s2.charAt(i-l1)-'a']++;
            }
            if(checkZero(count)) return true;
        }
        return false;
    }
    public boolean checkZero(int[] ch){
        for(int i=0;i<ch.length;i++){
            if(ch[i]!=0){return false;}
        }
        return true;
    }
}
