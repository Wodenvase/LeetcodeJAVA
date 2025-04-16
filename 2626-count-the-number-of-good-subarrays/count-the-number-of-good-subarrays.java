class Solution {
    public long countGood(int[] nums, int k) {
        long l = 0, r = 0, count = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        while (r < n) {
            map.put(nums[(int)r], map.getOrDefault(nums[(int)r], 0) + 1);
            count += map.get(nums[(int)r]) - 1;
            while (l < n && (count - (map.get(nums[(int)l]) - 1)) >= k) {
                map.put(nums[(int)l], map.get(nums[(int)l]) - 1);
                count -= map.get(nums[(int)l]);
                l++;
            }
            if (count >= k) ans += l + 1;
            r++;
        }
        return ans;
    }
}