class Solution {
    public int[] twoSum(int[] nums, int target) {
    //    int  sum = 0;

    //     for(int i=0;i<nums.length;i++)
    //     {
    //         for(int j=i+1;j<nums.length;j++)
    //         {
    //             if(nums[i]+nums[j] == target)
    //             { 
    //                 return new int[]{i,j};
    //             }       
    //         }
    //     }
    //     return new int[]{-1,-1};
        //number index
    Map<Integer,Integer> map = new HashMap<>();

    for(int i=0;i<nums.length;i++) 
    {
        int pairValue = target - nums[i];
        if(map.containsKey(pairValue))
        {
            int index1=i;
            int index2=map.get(pairValue);

           return new int[]{index1,index2};
        }
        map.put(nums[i],i); //add number index
    }
    return new int[]{-1,-1};


    }
}
// 19 + (-10) = 9
// nums = [2,11,8,3,7], target = 9

// Map
// Key Value
// 2 0
// 11 1
// 8 2
// 3 3
// 7 4




// boolean isPairPresent = map.containsKey(7) true / false




























