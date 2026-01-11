class Top_K_FrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<int[]> li = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            li.add(new int[]{entry.getValue(), entry.getKey()});
        }
        li.sort((a,b) -> Integer.compare(b[0],a[0]));
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = li.get(i)[1];
        }
        return result;
    }
}
