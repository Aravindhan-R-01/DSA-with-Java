// Trapping Rain Water:
// You are given an array of non-negative integers height which represent an elevation map. Each value height[i] represents the height of a bar, which has a width of 1.
// Return the maximum area of water that can be trapped between the bars.
// Example 1:
// Input: height = [0,2,0,3,1,0,1,3,2,1]
// Output: 9
// Constraints:
// 1 <= height.length <= 1000
// 0 <= height[i] <= 1000


class Day118_TrappingRainWater {
    public int trap(int[] quantity) {
        if(quantity == null || quantity.length == 0){
            return 0;
        }
        int waterCollected = 0;
        int len = quantity.length;
        for(int x = 0; x < len; x++){
            int leftQty = quantity[x];
            int rightQty = quantity[x];
            for(int y = 0; y < x; y++){
                leftQty = Math.max(leftQty, quantity[y]);
            }
            for(int z = x + 1; z < len; z++){
                rightQty = Math.max(rightQty, quantity[z]);
            }
            waterCollected += Math.min(leftQty, rightQty) - quantity[x];
        }
        return waterCollected;
    }
}
