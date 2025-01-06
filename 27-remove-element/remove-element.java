class Solution {
    // Find length of remaining elements
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for(int i=0;i<nums.length;i++){
           if (nums[i]!=val) {
                int temp = nums[index];
                nums[index]=nums[i];
                nums[i]=temp;
                index++;
            }
        }
        return index;
    }
}

//  nums = [0,1,2,2,3,0,4,2], val = 2
//  [0,1,3,0,4,2,2]