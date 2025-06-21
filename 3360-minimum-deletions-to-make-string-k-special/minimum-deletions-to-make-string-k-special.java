class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq=new int[26];
        freq=countFreq(word);int minDel=Integer.MAX_VALUE;
        for(int i=0;i<freq.length;i++){
            int removed=0;
            if(freq[i]!=0){
                for(int j=0;j<freq.length;j=j+1){
                    if (i!=j&&freq[j]!=0) {
                        if(freq[i]>freq[j]){
                            removed=removed+freq[j];
                        }
                        else if(freq[j]>(freq[i]+k)){
                            removed=removed+(freq[j]-freq[i]-k);
                        }
                    }
                }
                minDel=Math.min(minDel, removed);
            }
        }
        return minDel;
    }
    private static int[] countFreq(String word){
        int[] freq=new int[26];char ch;int x=0,pos;
        for (int i=0;i<word.length();i++) {
            ch=word.charAt(i);
            x=(int)ch;
            pos=x%97;
            freq[pos]=freq[pos]+1;
        }
        return freq;
    }
}