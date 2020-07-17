package com.example.demo.algorithm;

/**
 * longestCommonPrefix
 */
public class LongestCommonPrefix {

    
    public String longestCommonPrefixs(String[] strs) {
      if(strs.length ==0){
          return "";
      }
       String prefix = strs[0];
      for (int i = 0; i < strs.length; i++) {
          while(strs[i].indexOf(prefix)!=0){
              prefix = prefix.substring(0,prefix.length()-1);
              if(prefix.isEmpty()){
                return "";
            }
          }
        
          System.out.println(prefix);
      }
      return prefix;
    }

        public static void main(String[] args) {
            String[]  testdata = {"fliwer","fliow","flight"};
            LongestCommonPrefix ll = new LongestCommonPrefix();
            ll.longestCommonPrefixs(testdata);
        }
}