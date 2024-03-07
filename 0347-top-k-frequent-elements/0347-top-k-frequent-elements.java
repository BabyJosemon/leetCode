class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        for(Integer i: nums){
            cache.put(i, cache.getOrDefault(i,0)+1);// creating freq
        }
        List<Integer>[] bucket = new List[nums.length+1];//we create a bucket list
        for(int i=0;i<bucket.length;i++){
            bucket[i]= new ArrayList<>();//setting its initial values
        }
        for(Map.Entry<Integer, Integer> entry: cache.entrySet()){
            bucket[entry.getValue()].add(entry.getKey());//add keys to the frequenc
        }
        List<Integer> result = new ArrayList();
        for(int j=bucket.length-1;j>=0;j--){//iterate from last of array and only consider values upto k
            if(!bucket[j].isEmpty()){
                result.addAll(bucket[j]);
                if (result.size()>=k) break;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
        /*
        HashMap<Integer, Integer> cache=new HashMap<>();
        for(Integer i:nums){
            cache.put(i, cache.getOrDefault(i,0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minheap=new PriorityQueue<>((e1,e2)->e1.getValue()-e2.getValue());
        for(Map.entry<Integer, Integer> entry: cache.entrySet()){
            minheap.add(entry);
            if(minheap.size()>k){
                minheap.poll();
            }
        }
        List<Integer> result=new ArrayList<>();
        while(!minheap.isEmpty()){
            result.add(minheap.poll().getKey());
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
        */
    }
}