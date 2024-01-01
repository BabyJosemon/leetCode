class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i=0;i<numbers.length-1;i++){
            int residual=target-numbers[i];
            int start=i+1;
            int end=numbers.length-1;
            int mid;
            while(start<=end){
                mid=start+(end-start)/2;
                if(numbers[mid]>residual){
                    end=mid-1;
                }else if(numbers[mid]<residual){
                    start=mid+1;
                }else{
                    return new int[]{i+1, mid+1};
                }
            }
        }   
        return new int[]{0,0};
    }
}