public int maximumProduct (int[] nums) {

    if (nums.length == 0)  return 0;

    //brute-force - Time: O(N^2) - Space: O(1)
    int maxProd = Integer.MIN_VALUE;

    for(int i=0; i<nums.length; i++) {
        int curr = 1;
        for(int j=i; i<nums.length; j++) {
            curr *= nums[j];
            maxProd = Math.max(curr, maxProd);
        }
    }

    return maxProd;

    //Dynamic Programming - Time: O(N) - Space: O(1)

    int min_so_far = nums[0];
    int max_so_far = nums[0];
    int res = max_so_far;

    for(int i=1; i<nums.length; i++) {
        int curr = nums[i];

        int temp_max = Math.max(curr, Math.max(min_so_far*curr, max_so_far*curr));
        min_so_far = Math.min(curr, Math.min(min_so_far*curr, max_so_far*curr));
        max_so_far = temp_max;

        res = Math.max(res, max_so_far);
    }

    return res;
}