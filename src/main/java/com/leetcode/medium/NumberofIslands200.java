package com.leetcode.medium;

/**
 * Created by pro on 16/11/25.
 */
public class NumberofIslands200 {
    public static void main(String[] args) {
        char[][] a={
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        char[][] b={
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numIslands(b));
    }
    
    public static int numIslands(char[][] grid) {
        int num=0;
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                if(grid[i][j]=='1'){
                    num++;
                    draw(grid,i,j);
                }
            }
        }
        return num;
    }

    public  static void draw(char[][] grid, int row, int col) {
        if (row<0||row>grid.length-1||col<0||col>grid[0].length-1||grid[row][col]!='1')
            return ;
        grid[row][col]='2';
        draw(grid,row+1,col);
        draw(grid,row,col+1);
        draw(grid,row-1,col);
        draw(grid,row,col-1);
    }


}
