class Solution {
    public String longestPrefix(String s) {
        int[] dp = new int[s.length()];
        int len = 0, i = 1;
        while(i < s.length()){
            if(s.charAt(i) == s.charAt(len)){
                dp[i] = ++len;
                i++;
            }
            else{
                if(len>0){
                    len = dp[len-1];
                }
                else{
                    dp[i] = 0;
                    i++;
                }
            }
        }
        return s.substring(0,dp[dp.length-1]);
    }
}