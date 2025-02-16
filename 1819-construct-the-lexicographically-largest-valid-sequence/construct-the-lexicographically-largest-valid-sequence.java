class Solution {
    public int[] constructDistancedSequence(int n) {
        int result[]=new int[2*n-1];
        boolean used[]=new boolean[n+1];

        backtrack(result,used,0,n);
        return result;
    }

    private boolean backtrack(int result[],boolean used[],int idx,int n){
        // if we reach end of array, return true
        if(idx==result.length) return true;

        //if current index is already filled, move to next index
        if(result[idx]!=0) return backtrack(result,used,idx+1,n);
        
        //try placing numbers from n to 1 for lexi's largest seq.
        for(int num=n;num>=1;num--){
            int j=(num==1)?idx:idx+num; //check 2nd position for num

            //check if number is not used and 2nd position is valid
            if(!used[num] && (num==1 || (j<result.length && result[j]==0))){
                result[idx]=num;
                if(num>1) result[j]=num;
                used[num]=true; //mark the no. as used

                if(backtrack(result,used,idx+1,n)) return true;

                //backtrack(remove if sol. doesn't exist)
                result[idx]=0;
                if(num>1) result[j]=0;
                used[num]=false;
            }
        }
        return false;
    }
}