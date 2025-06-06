class Solution {
//merge function
    public static void merge(int nums1[],int nums2[],int arr[],int n,int m){
        int i=0,j=0,k=0;
        while(i<n&&j<m){
            if(nums1[i]<nums2[j]){
                arr[k]=nums1[i];
                i++;
            }
            else{
                arr[k]=nums2[j];
                j++;
            }
            k++;
        }
        while(i<n){
            arr[k]=nums1[i];
            i++;
            k++;
        }
        while(j<m){
            arr[k]=nums2[j];
            j++;
            k++;
        }
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length,m=nums2.length;
        int len=n+m;
        // new array
        int arr[]=new int[len];
        merge(nums1,nums2,arr,n,m);
        //even length
        if(len%2==0){
            return (double)(arr[len/2]+arr[len/2-1])/2;
        }
        // odd length
        return (double)arr[len/2];
    }
}