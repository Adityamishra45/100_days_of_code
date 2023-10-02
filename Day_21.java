class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> numCount = new HashMap<>();
        List<Integer> intersection = new ArrayList<>();

        for (int num : nums1) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            if (numCount.containsKey(num) && numCount.get(num) > 0) {
                intersection.add(num);
                numCount.put(num, numCount.get(num) - 1);
            }
        }

        int[] result = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }

        return result;
    }
}
