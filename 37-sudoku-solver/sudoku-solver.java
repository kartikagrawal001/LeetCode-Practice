class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
    }
    public boolean helper(char[][]board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char dig = '1';dig<='9';dig++){
                        if(valid(board,dig,i,j)){
                            board[i][j]=dig;
                            if(helper(board)==true)return true;
                            else board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean valid(char[][]board,char dig,int row,int col){
        for(int i=0;i<9;i++){
            if(board[i][col]==dig)return false;
            if(board[row][i]==dig)return false;
        }
        int r = (row/3)*3;
        int c= (col/3)*3;
        for(int stR = r;stR<=r+2;stR++){
            for(int stC=c;stC<=c+2;stC++){
                if(board[stR][stC]==dig)return false;
            }
        }
        return true;
    }
}