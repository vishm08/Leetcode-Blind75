public int[] twoSum(int[] nums, int target) {
    
    //brute-force
    for(int i=0; i<nums.length; i++) {
        for(int j=i+1; j<nums.length; j++) {
            if(nums[i] + nums[j] == target)
                return new int[] {i, j};
        }
    }

    //two-pass hash table
    Map<Integer, Integer> map = new HashMap<>();

    for(int i=0; i<nums.length; i++)
        map.put(nums[i], i);
    
    for(int i=0; i<nums.length; i++) {
        int comp = target - nums[i];

        if(map.containsKey(comp) && map.get(comp) != i)
            return new int[] {i, map.get(comp)};
    }

    //one-pass hash table
    Map<Integer, Integer> map = new HashMap<>();

    for(int i=0; i<nums.length; i++) {
        int comp = target - nums[i];

        if(map.containsKey(comp))
            return new int[] {i, map.get(comp)};
        
        map.put(nums[i], i);
    }

    return null;
}