class Solution {
    public int waysToSplitArray(int[] nums) 
    {
        long prefix[]=new long[nums.length];
        long sum1=0;
        long sum2=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            sum1=sum1+nums[i];
            prefix[i]=sum1;
        }
        int result=0;
        for(int i=0;i<n-1;i++)
        {
            if(prefix[i]>=prefix[n-1]-prefix[i])
            result++;
        }
        return result;
    }
}