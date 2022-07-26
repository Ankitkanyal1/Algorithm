/*Question ==> An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
Return the modified image after performing the flood fill.
Example 1:
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
Example 2:
Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
Output: [[0,0,0],[0,0,0]]
Explanation: The starting pixel is already colored 0, so no changes are made to the image.

Time Complexity ==> O(n) 
*/ class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color==image[sr][sc]) return image;
        floodfill(image,sr,sc,color,image[sr][sc]);
        return image;
    }
    public void floodfill(int [][]image,int row ,int col, int color, int oldColor){
        if(row>=image.length || row<0 || col>=image[0].length || col<0 || oldColor!=image[row][col]) return;
        image[row][col]=color;
        floodfill(image,row-1,col,color,oldColor);
        floodfill(image,row+1,col,color,oldColor);
        floodfill(image,row,col-1,color,oldColor);
        floodfill(image,row,col+1,color,oldColor);
        }    
}

/*Question2 ==> Max Area of Island
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
The area of an island is the number of cells with a value 1 in the island.
Return the maximum area of an island in grid. If there is no island, return 0.
Example 1:
Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.

Time Complexity ==> O(nXm)*/

class Solution {
     boolean[][] seen; 
    public int maxAreaOfIsland(int[][] grid) {
        seen=new boolean[grid.length][grid[0].length];
        int ans=0;
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                ans=Math.max(ans,area(grid,r,c));
            }
        }
        return ans;
              
    }
    public int area(int[][] grid,int r,int c){
        if(r<0||r>=grid.length||c<0||c>=grid[0].length||seen[r][c]||grid[r][c]==0)return 0;
        seen[r][c]=true;
        return (1+area(grid,r+1,c)+area(grid,r-1,c)+area(grid,r,c-1)+area(grid,r,c+1));
    }
}
