//11. Container With Most Water
class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l=0,r=height.length-1;
        int sum=0;
        while(l<r){
           sum=Math.max(sum,Math.min(height[l],height[r])*(r-l));
           if(height[l]<height[r]){
               l++;
           }else{
               r--;
           }
        }
        return sum;
    }
}
