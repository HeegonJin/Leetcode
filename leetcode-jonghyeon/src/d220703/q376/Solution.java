package d220703.q376;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static int wiggleMaxLength(int[] nums) {
        int minusCount = 0;
        List<Boolean> discriminator = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] < nums[i+1]){
                discriminator.add(true);
            } else if (nums[i] > nums[i+1]){
                discriminator.add(false);
            } else{
                continue;
            }
        }

        for (int i = 1; i < discriminator.size(); i++){
            if (discriminator.get(i-1) == discriminator.get(i)){
                minusCount++;
            }
        }
        return discriminator.size() - minusCount + 1;
    }

    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{0,0,0,0,0}));
    }
}
