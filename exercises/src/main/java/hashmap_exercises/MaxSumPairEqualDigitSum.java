package hashmap_exercises;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 2342 - Max Sum of a Pair With Equal Sum of Digits
 * <p>
 * You are given a 0-indexed integer array nums.
 * Find the maximum sum of a pair of numbers (nums[i] + nums[j]) such that
 * the sum of digits of nums[i] is equal to the sum of digits of nums[j],
 * and i != j.
 * <p>
 * If no such pair exists, return -1.
 * <p>
 * Example:
 * nums = [18, 43, 36, 13, 7]
 * digit sums: 9, 7, 9, 4, 7
 * Pairs with same digit sum:
 * (18, 36) -> sum = 54 with digit sum 9
 * (43, 7)  -> sum = 50 with digit sum 7
 * Answer: 54
 */
public class MaxSumPairEqualDigitSum {

    /**
     * @param nums input array
     * @return maximum sum of a pair of numbers sharing the same digit sum,
     * or -1 if no such pair exists
     */
    public int maximumSum(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int maxSum = -1;

        for (int i = 0; i < nums.length; i++) {

            int currentNumber = nums[i];
            int digitSum = digitSum(currentNumber);

            // if already have value for this digit sum
            if (map.containsKey(digitSum)) {
                int bestSoFar = map.get(digitSum);
                int pairSum = currentNumber + bestSoFar;
                maxSum = Math.max(maxSum, pairSum);

                // update map if current number is bigger
                map.put(digitSum, Math.max(bestSoFar, currentNumber));

            } else {
                map.put(digitSum, currentNumber);
            }
        }
        return maxSum;

    }


    /**
     * Optional helper method:
     * Computes the sum of digits of a non-negative integer.
     */

    int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}

