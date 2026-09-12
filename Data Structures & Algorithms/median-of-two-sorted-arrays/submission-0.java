class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int i = 0;
        int j = 0;

        int curMedian = 0;
        int prevMedian = 0;

        // Use two pointers.
        // Always take the smaller current number.
        // Only continue until the middle.
        // Track the current and previous picked numbers.

        for (int cur = 0; cur < (len1 + len2) / 2 + 1; cur++) {
            prevMedian = curMedian;
            if (i < len1 && j < len2) {
                if (nums1[i] < nums2[j]) {
                    curMedian = nums1[i];
                    i++;
                } else {
                    curMedian = nums2[j];
                    j++;
                }
            } else if (i < len1) {
                curMedian = nums1[i];
                i++;
            } else {
                curMedian = nums2[j];
                j++;
            }
        }

        if ((len1 + len2) % 2 == 1) {
            return (double) curMedian;
        } else {
            return (curMedian + prevMedian) / 2.0;
        }
    }
}
