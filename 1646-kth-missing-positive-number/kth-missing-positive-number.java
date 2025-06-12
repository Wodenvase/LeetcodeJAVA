class Solution {
    public int findKthPositive(int[] arr, int k) {
        int x= 1;
        int y= 0;
        int i = 0;
        
        while (i < arr.length) {
            if (arr[i] == x) {
                i++;
            } else {
                y++;
                if (y == k) {
                    return x;
                }
            }
            x++;
        }
        
        int a = x + (k - y - 1);
        return a;
    }
}