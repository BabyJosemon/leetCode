class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result=new ArrayList<>();
        if(s==null){
            return result;
        }
        result.add(s);
        for(int i=0;i<s.length();i++){
            if(Character.isLetter(s.charAt(i))){
                int n=result.size();
                for(int j=0;j<n;j++){
                    char[] copy=result.get(j).toCharArray();//We need this as an array
                    if(Character.isUpperCase(copy[i])){
                        copy[i]=Character.toLowerCase(copy[i]);
                    }else{
                        copy[i]=Character.toUpperCase(copy[i]);
                    }
                    result.add(String.valueOf(copy));
                }
            }
        }
       return result;   
    }
}