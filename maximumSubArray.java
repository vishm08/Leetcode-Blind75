//brute-force - time: O(N^2) - space: O(1)

public int maxSubArray (int[] nums) {
    int maxSubArr = Integer.MIN_VALUE;

    for (int i=0; i<nums.length; i++) {
        int curr = 0;

        for(int j=i; i<nums.length; j++) {
            curr += nums[j];
            maxSubArr = Math.max(curr, maxSubArr);
        }
    }

    return maxSubArr;

}

//Dynamic Programming - Time: O(N) - Space: O(1)

public int maxSubArray(int[] nums) {
    int currMax = nums[0];
    int maxSubArr = nums[0];

    for(int i=1; i<nums.length; i++) {
        currMax = Math.max(nums[i], nums[i]+currMax);
        maxSubArr = Math.max(maxSubArr, currMax);
    }

    return maxSubArr;
}

//Divide & Conquer - Time: (NlogN) - Space: (NlogN)

private int[] numsArr;

public int maxSubArr(int[] nums) {
    numsArr = nums;

    //helper function is designed to solve this problem for any array - so just call it using the entire input
    return findMaxSubArr(0, numsArr.length - 1);
}

public int findMaxSubArr(int left, int right) {

    //best case - empty array.
    if(left>right) return Integer.MIN_VALUE;

    int mid = Math.floorDiv(left+right,2);
    int curr = 0;
    int bestLeftSum = 0;
    int bestRightSum = 0;

    //Iterate from the middle to the beginning.
    for(int i=mid-1; i>=left; i--) {
        curr+=numsArr[i];
        bestLeftSum = Math.max(bestLeftSum, curr);
    }

    //Reset curr and iterate from the middle to the end.
    curr=0;
    for(int i=mid+1; i<=right; i++) {
        curr+=numsArr[i];
        bestRightSum = Math.max(bestRightSum, curr);
    }

    //The bestCombinedSum uses the middle element and the best possible sum from each half.
    int bestCombinedSum = numsArr[mid] + bestLeftSum + bestRightSum;

    //Find the best subarray possible from both halves.
    int leftHalf = findMaxSubArr(left, mid-1);
    int rightHalf = findMaxSubArr(mid+1, right);

    //The largest of the 3 is the answer for any given input array.
    return Math.max(bestCombinedSum, Math.max(leftHalf, rightHalf));
}