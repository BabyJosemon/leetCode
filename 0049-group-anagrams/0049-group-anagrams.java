class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List<String>> cache=new HashMap<>();
        List<List<String>> result=new ArrayList<>();
        char[] temp;
        String key;
        for(int i=0;i<strs.length;i++){
            temp=strs[i].toCharArray();
            Arrays.sort(temp);
            key=String.valueOf(temp);
            if(!cache.containsKey(key)){
                cache.put(key, new ArrayList<>(Arrays.asList(strs[i])));
                /*OR
                List<String> stringList= new ArrayList<>();
                stringList.add(strs[i]);
                cache.put(key,stringList);*/
                          
            }else{
                cache.get(key).add(strs[i]);
            }
        }
        
        result.addAll(cache.values());
        return result;
        
    }
}