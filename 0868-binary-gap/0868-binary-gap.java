class Solution {
    public int binaryGap(int n) {
        String binaryStr=Integer.toBinaryString(n);
        boolean flag=false,closedAtleastOnce= false;
        int maxSize=0;
        int currentSize=0;
        for(int i=0;i<binaryStr.length();i++){
            char currentChar=binaryStr.charAt(i);
            if(currentChar=='1'){
                if(!flag){
                    flag=true;

                }else{//flag is true
                    maxSize=Math.max(maxSize, currentSize);
                    currentSize=0;
                    closedAtleastOnce=true;
                }
            }else{
                if(flag){
                    currentSize+=1;
                }
            }
        }
        if(closedAtleastOnce){
            return maxSize+1;
        }
        return 0;
    }
}