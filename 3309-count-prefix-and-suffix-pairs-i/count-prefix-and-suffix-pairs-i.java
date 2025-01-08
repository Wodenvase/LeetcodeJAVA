class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            String s1 = words[i];
            for(int j = i + 1; j < n; j++) {
                String s2 = words[j];
                if(s2.length() < s1.length()) continue;
                String pre = s2.substring(0, s1.length());
                String suf = s2.substring(s2.length() - s1.length());
                if(pre.equals(s1) && suf.equals(s1)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}