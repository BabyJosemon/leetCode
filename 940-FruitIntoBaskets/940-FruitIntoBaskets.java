// Last updated: 03/06/2026, 00:10:48
/* This is also a sliding window question except this has a variable length window and we have a constraint to match. This is because we need to keep track of the number of different fruits in a continuos subarray. And we do this by keeping track of the frequencty of fruits in a current window. So hashmap. Everytime we move end, we update the frequency of the newly added end  in the hashmap. And then if the size of map reaches 3 we contract from the start. and we keep contracting until we reach the frequency allowed in a window i.e. 2. This is the start++ place. If we didnt have to contract the array after adding an element then that means that the frequency of fruits in the array is still under 3. So we find the maxFruit then. When we reach the end of array we return.*/
class Solution {
    public int totalFruit(int[] fruits) {
        int start=0;
        Map<Integer, Integer> fruitFrequency= new HashMap<>();
        int maxFruits=0;
        for(int end=0;end<fruits.length;end++){
            //add it to the frequency dictionary
            fruitFrequency.put(fruits[end], fruitFrequency.getOrDefault(fruits[end],0)+1);
            //if the addition causes the frequency to tip over max allowed 3 then we continuosly contract from start
            //until we reduce our frequenct to the max allowed value of 2.
            while(fruitFrequency.size()==3){
                fruitFrequency.put(fruits[start], fruitFrequency.get(fruits[start])-1);
                //this also means if the frequency ever goes to 0, we need to remove it. so as to not interfere in the
                //hashmap size check
                if(fruitFrequency.get(fruits[start])==0){
                    fruitFrequency.remove(fruits[start]);
                }
                //moving start
                start++;
            }
            //if we did not had to contract the array or after done with contraction we find the max.
            maxFruits=Math.max(maxFruits,end-start+1);
        }
        return maxFruits;
    }
}