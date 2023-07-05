class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length,m=nums2.length;
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int midOfAll=(nums1.length+nums2.length+1)/2;
        int start=0,end=nums1.length;
        if(n==0 && m==0){
            return 0.0;
        }
        else if(n==0){
            if(m%2==0){
                return (nums2[m/2]+nums2[m/2-1])/2.0;
            }else{
                return nums2[m/2];
            }
        }
        System.out.println("m="+m+"n="+n);
        while(start<=end){
            int mid=start+(end-start)/2;
            int leftBSize=midOfAll-mid;
            int leftA=(mid>0)?nums1[mid-1]:Integer.MIN_VALUE;
            int leftB=(leftBSize>0)?nums2[leftBSize-1]:Integer.MIN_VALUE;
            int rightA=(mid<nums1.length)?nums1[mid]:Integer.MAX_VALUE;
            int rightB=(leftBSize<nums2.length)?nums2[leftBSize]:Integer.MAX_VALUE;
            if(leftA<=rightB && leftB<=rightA){
                if((nums1.length+nums2.length)%2==0){
                    return (Math.max(leftA,leftB)+Math.min(rightA,rightB))/2.0;
                }
                else{
                    return Math.max(leftA,leftB);
                }
            }
            else if(leftA>rightB){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return 0.0;
    }
}
