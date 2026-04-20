class Solution {
    public int maxDistance(int[] colors) {
        int maxdist = 0;
        for(int i=0;i<colors.length;i++){
            for(int j=i+1;j<colors.length;j++){
                if(colors[i]!=colors[j]){
                    int currdist = j-i;
                    maxdist = Math.max(maxdist, currdist);
                }
            }
        }
        return maxdist;
    }
}