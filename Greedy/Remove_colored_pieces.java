package Greedy;

public class Remove_colored_pieces {
    class Solution {
        public boolean winnerOfGame(String colors) {
            int c=0;
           for(int i=1;i<colors.length()-1;i++){
               if(colors.charAt(i-1)=='A'&&colors.charAt(i+1)=='A'&&colors.charAt(i)=='A'){
                   c++;
               }else if(colors.charAt(i-1)=='B'&&colors.charAt(i+1)=='B'&&colors.charAt(i)=='B') c--;
           }
           if(c>0)return true;
           return false;
        }
    }
}
