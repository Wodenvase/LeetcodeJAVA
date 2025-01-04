class Solution {
    public int countPalindromicSubsequence(String s) {
        int ans=0;
        boolean[] made=new boolean[26];
        for(int i=0;i<s.length();i++){
            boolean[] unique=new boolean[26];
            int last=s.length()-1;
            char c=s.charAt(i);
            if(!made[c-'a']){
                made[c-'a']=true;
                while(last>=i){
                    if(s.charAt(last)==c){
                        break;
                    }
                    last--;
                }
            
            if(i!=last){
                for(int j=i+1;j<last;j++){
                    char p=s.charAt(j);
                    if(!unique[p-'a']){
                        unique[p-'a']=true;
                        ans++;
                    }
                }
            }
            }
        }
        return ans;
    }
}