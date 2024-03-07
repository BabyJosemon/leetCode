class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> cache=new HashMap<>();
        for(int i=0;i<s.length();i++){
            cache.put(s.charAt(i), cache.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> minheap=new PriorityQueue<>((e1,e2)->e2.getValue()-e1.getValue());
        for(Map.Entry<Character, Integer> entry: cache.entrySet()){
            minheap.add(entry);
        }
        String result="";
        while(!minheap.isEmpty()){
            Map.Entry<Character, Integer> oneEntry=minheap.poll();
            Character chr=oneEntry.getKey();
            Integer freq=oneEntry.getValue();
            for(int i=0;i<freq;i++){
                result+=chr;
            }
        }
        return result;
    }
}