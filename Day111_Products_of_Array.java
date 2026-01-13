// Products of Array Except Self: 
// Given an integer array nums, return an array output where output[i] is the product of all the elements of nums except nums[i].
// Each product is guaranteed to fit in a 32-bit integer.
// Follow-up: Could you solve it in O(n)
// O(n) time without using the division operation?
// Example 1:
// Input: nums = [1,2,4,6]
// Output: [48,24,12,8]
// Example 2:
// Input: nums = [-1,0,1,2,3]
// Output: [0,-6,0,0,0]
// Constraints:
// 2 <= nums.length <= 1000
// -20 <= nums[i] <= 20

class Day111_Products_of_Array {
    public int[] productExceptSelf(int[] nums) {
        int arr_len = nums.length;
        int[] result = new int[arr_len];
        for(int i = 0; i < arr_len; i++){
            int count = 1;
            for(int j = 0; j < arr_len; j++){
                if(i != j){
                    count *= nums[j];
                }
            }
            result[i] = count;
        }
        return result;
    }
}  
