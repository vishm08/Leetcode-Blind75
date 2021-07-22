public int[] productExceptSelf(int[] nums) {

    //brute-force - Time: O(n^2) - Space: O(1)
    int len = nums.length;

    int[] ans = new int[len];

    for(int i=0; i<len; i++) {
        int prod = 1;
        for(int j=0; j<len; j++) {
            if(nums[i] != nums[j])
                prod *= nums[j];
        }
        ans[i] = prod;
    }

    return ans;

    //left and right product arrays - Time: O(n) - Space: O(n)
    int len = nums.length;

    int[] ans = new int[len];

    int[] left = new int[len];
    int[] right = new int[len];

    left[0] = 1;

    for(int i=1; i<len; i++) {
        left[i] = left[i-1] * nums[i-1];
    }

    right[len-1] = 1;

    for(int i=len-2; i>=0; i--) {
        right[i] = right[i+1] * nums[i+1];
    }

    for(int i=0; i<len; i++) {
        ans[i] = left[i] * right[i];
    }

    return ans;

    //Follow-up: Use O(1) space - Time: O(n) - Space(1)
    int len = nums.length;

    int[] ans = new int[len];

    ans[0] = 1;

    for(int i=1; i<len; i++) {
        ans[i] = ans[i-1] * nums[i-1];
    }

    int right = 1;

    for(int i=len-1; i>=0; i--) {
        ans[i] = ans[i] * right;
        right = right * nums[i];
    }

    return ans;
}