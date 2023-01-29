package StackandQueues;

public class Implement_2_stacks_in_array {
    class TwoStack {

        int size;
        int top1, top2;
        int arr[] = new int[100];

        TwoStack() {
            size = 100;
            top1 = -1;
            top2 = size;
        }
    }

    class Stacks {

        void push1(int x, TwoStack sq) {
            if (sq.top2 - sq.top1 > 1) {
                sq.top1++;
                sq.arr[sq.top1] = x;
            }
        }

        void push2(int x, TwoStack sq) {
            if (sq.top2 - sq.top1 > 1) {
                sq.top2--;
                sq.arr[sq.top2] = x;
            }

        }

        int pop1(TwoStack sq) {
            if (sq.top1 >= 0) {
                int ans = sq.arr[sq.top1];
                sq.top1--;
                return ans;
            } else {
                return -1;
            }
        }

        int pop2(TwoStack sq) {
            if (sq.top2 < sq.size) {
                int ans = sq.arr[sq.top2];
                sq.top2++;
                return ans;
            } else {
                return -1;
            }
        }
    }
}
