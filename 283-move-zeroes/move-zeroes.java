class Solution {
    public void moveZeroes(int[] nums) {
        // Two Pointer Technique
        int index = 0;
        for(int i=0;i<nums.length;i++){
           if (nums[i]!=0) {
                int temp = nums[index];
                nums[index]=nums[i];
                nums[i]=temp;
                index++;
            }
        }
    }
}

// [4,1,4,3,12]
// [1,3,12,4,4]
// 0 1 2 3




// [0,1,0,3,12]  target =0

  

