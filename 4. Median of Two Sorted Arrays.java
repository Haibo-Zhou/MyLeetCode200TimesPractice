class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        double median = 0;
        int[] sum = new int[nums1.length + nums2.length];
        
        
        if (l1 + l2 == 1) {
            if (nums1.length != 0) { return nums1[0]; }
            if (nums2.length != 0) { return nums2[0]; } 
        }
        
        sum = this.mergeAndSort(nums1, nums2);
        
        if (sum.length % 2 == 0) {
            int mid = sum.length / 2;
            median = (double) (sum[mid - 1] + sum[mid]) / 2;
            return median;
        } else {
            return (double) sum[sum.length / 2];
        }
        
    }
    
    public int[] mergeAndSort(int[] a, int[] b) {
        int[] answer = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) 
            {
                answer[k] = a[i];
                i++;
            } 
            else 
            {
                answer[k] = b[j];
                j++;
            }
            k++;
        }
        
        while (i < a.length)
        {
            answer[k] = a[i];
            i++;
            k++;
        }
        
        while (j < b.length)
        {
            answer[k] = b[j];
            j++;
            k++;
        }
        
        return answer;
    }
}