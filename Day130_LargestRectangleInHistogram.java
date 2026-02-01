// Largest Rectangle In Histogram:
// You are given an array of integers heights where heights[i] represents the height of a bar. The width of each bar is 1.
// Return the area of the largest rectangle that can be formed among the bars.
// Note: This chart is known as a histogram.
// Example 1:
// Input: heights = [7,1,7,2,2,4]
// Output: 8
// Example 2:
// Input: heights = [1,3,7]
// Output: 7
// Constraints:
// 1 <= heights.length <= 1000.
// 0 <= heights[i] <= 1000


class Day130_LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int rightMost = i + 1;
            int leftMost = i;
            while (rightMost < n && heights[rightMost] >= height) {
                rightMost++;
            }
            while (leftMost >= 0 && heights[leftMost] >= height) {
                leftMost--;
            }
            rightMost--;
            leftMost++;
            maxArea = Math.max(maxArea, height * (rightMost - leftMost + 1));
        }
        return maxArea;
    }
}
