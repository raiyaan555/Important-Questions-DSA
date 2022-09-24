import java.util.*;
public class P4_Contains_Duplicate {


    //  Using hash map lets try

    public static boolean containsDuplicate(int[] nums) {
         
        HashMap<Integer, Integer> h= new HashMap<>();

        for (int num : nums
        ) {
            if (!h.containsKey(num)) {
                h.put(num, 1);
            } else {
                return true;
            }
        }

        
        return false;
    }


    //  This is the way to do this question with set


    // public static boolean containsDuplicate(int[] nums) {
    //     Set<Integer> set = new HashSet<>();

    //     for(int i: nums){
    //         set.add(i);
    //     }

    //     return (set.size() == nums.length) ? false: true;
    //     }




        public static void main(String[] args) {
            int[] arr = {1,2,3,4};
            System.out.println(containsDuplicate(arr));
        }
    }


