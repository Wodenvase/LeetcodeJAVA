class Solution {
    public String longestPrefix(String s) {
        String res = "";
        for (int i = s.length()-1; i>=0; i--){
            String str = s.substring(0, i);
            if (s.endsWith(str)){
                res+=str;
                break;
            }
        }
        return res;
        
    }
}