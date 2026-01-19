// Container With Most Water:
// You are given an integer array heights where heights[i] represents the height of the ith bar.
// You may choose any two bars to form a container. Return the maximum amount of water a container can store.
// Example 1:
// Input: height = [1,7,2,5,4,7,3,6]
// Output: 36
// Example 2:
// Input: height = [2,2,2]
// Output: 4
// Constraints:
// 2 <= height.length <= 1000
// 0 <= height[i] <= 1000

class Day117_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int area = 0;
        for(int i = 0; i < height.length; i++){
            for(int j = i + 1; j < height.length; j++){
                area = Math.max(area, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return area;
    }
}
