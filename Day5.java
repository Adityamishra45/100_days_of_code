//Reverse Prefix of Word


class Solution {
    public String reversePrefix(String word, char ch) {
        String str = "";
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==ch){
                break;
            }
            str = str+word.charAt(i);
            continue;    
        }
        if(str.length()==word.length()){
                return word;
        }
        if(str.length()<word.length()){
            str = str+ch;
        }
        String string = word.substring(str.length());
        String newstr = "";
        for(int i=str.length()-1; i>=0; i--){
            newstr = newstr+str.charAt(i);
        }
        String finalString = newstr+string;
        return finalString;
    }
}
