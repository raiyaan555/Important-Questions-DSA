package Bit_Manipulation;

public class Bitwise_and_of_numbers {
    public int rangeBitwiseAnd(int left, int right) {


        int c = 0;
        while(left!=right){
            left =left>>1;
            right = right>>1;

            c++;
        }
        return left<<c;

    }
}
