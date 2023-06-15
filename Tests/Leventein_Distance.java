package Tests;

public class Leventein_Distance {

    static int compareStrings(String a,  String b){
        int c = 0;
        if (a.length()==b.length()){
            for(int i = 0; i<a.length(); i++){
            char ch1 = a.charAt(i);
            char ch2 = b.charAt(i);

            if(ch1!=ch2){
                c++;
            }

        }
        return c;
        }else{
            for(int i = 0, j=0; i<a.length() || j<b.length(); i++, j++){
            char ch1 = a.charAt(i);
            char ch2 = b.charAt(j);

            if(ch1!=ch2){
                c++;
            }

        }
        return c+(Math.max(a.length(),b.length()))-Math.min(a.length(),b.length());
        }
        
    }
    public static void main(String[] args) {
        String a ="muvbas4alpga";
        String b = "8fy4fxcji1hx";

        System.out.println(compareStrings(a, b));
    }
}
