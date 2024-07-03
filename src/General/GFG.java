package General;

class GfG {

    private static int next(int[] arr, int target)
    {

        int start = 0, end = arr.length-1;
        // Minimum size of the array should be 1
        if(end == 0) return -1;
        // If target lies beyond the max element, than the index of strictly smaller
        // value than target should be (end - 1)
        if (target > arr[end]) return end;

        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;

            // Move to the left side if the target is smaller
            if (arr[mid] >= target) {
                end = mid - 1;
            }

            // Move right side
            else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }

    // Driver code
    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 3, 5, 8, 12 };
        System.out.println(next(arr, 5));
    }
}
