public boolean containsDuplicate (int[] nums) {

    //brute-force - Time: O(n^2) - Space: O(1)
    for(int i=0; i<nums.length; i++) {
        for(int j=i+1; j<nums.length; j++) {
            if(nums[i] == nums[j])
                return true;
        }
    }

    return false;

    //Sorting Array - Time: O(nlogn) - Space: O(1)
    Arrays.sort(nums);

    for(int i=0; i<nums.length-1; i++) {
        if(nums[i] == nums[i+1])
            return true;
    }

    return false;

    //Hash Table - Time: O(n) - Space: O(n)
    Set<Integer> set = new HashSet<>();

    for(int i=0; i<nums.length; i++) {
        if(set.contains(nums[i]))
            return true;
        set.add(nums[i]);
    }

    return false;
}