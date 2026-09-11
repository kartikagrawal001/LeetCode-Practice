class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][]dp = new int[text1.length()][text2.length()];
        for(int i[]:dp)Arrays.fill(i,-1);
        return helper(0,0,text1,text2,dp);
    }
    public int helper(int i,int j,String s1,String s2,int[][]dp){
        if(i==s1.length() || j==s2.length())return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j))return dp[i][j] =  1 + helper(i+1,j+1,s1,s2,dp);
        int c1 = helper(i+1,j,s1,s2,dp);
        int c2 = helper(i,j+1,s1,s2,dp);
        return dp[i][j] = Math.max(c1,c2);
    }
}