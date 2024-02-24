//store frequencies in hashmap, try adding all frequencies into a set. If it fails return false. 
//You can also add all values of the Map into the set and check if their lengths are equal or not
//Set<Integer> checker = new HashSet<>(cache.values());
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        if(arr.length==1){
            return true;
        }
        Map<Integer, Integer> cache=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            cache.put(arr[i], cache.getOrDefault(arr[i],0)+1);
        }
        Set<Integer> checker = new HashSet<>();
        for(Integer value: cache.values()){
            if(!checker.add(value)){
                return false;
            }
        }
        return true;
    }
}