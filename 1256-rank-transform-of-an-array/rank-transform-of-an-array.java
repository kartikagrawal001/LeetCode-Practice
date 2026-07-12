class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length==0)return arr;
        int carr []= arr.clone();
        Arrays.sort(carr);
        Map<Integer,Integer> map = new HashMap<>();
        map.put(carr[0],map.getOrDefault(carr[0],1));
        int rank = 1; 
        int prev = carr[0];
        for(int i=1;i<carr.length;i++){
            if(carr[i]==prev){
                map.put(carr[i],map.getOrDefault(carr[i],rank));
                prev = carr[i];
            }
            else {
                rank++;
                map.put(carr[i],map.getOrDefault(carr[i],rank));
                prev = carr[i];
            }
        } 
        for(int i=0;i<arr.length;i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}