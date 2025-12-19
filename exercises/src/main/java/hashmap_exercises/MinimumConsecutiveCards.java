package hashmap_exercises;


import java.util.HashMap;

/**
 * LeetCode 2260 - Minimum Consecutive Cards to Pick Up
 * <p>
 * You are given an integer array cards where cards[i] represents the value of the i-th card.
 * You need to pick up a sequence of cards (a contiguous subarray) that contains at least
 * two cards with the same value.
 * <p>
 * Return the minimum length of such a subarray, or -1 if it is impossible.
 * <p>
 * Example:
 * cards = [3, 4, 2, 3, 4, 7] -> answer = 4
 * (e.g., subarray [3, 4, 2, 3] from index 0 to 3)
 */
public class MinimumConsecutiveCards {

    /**
     * @param cards array of card values
     * @return minimum length of a contiguous subarray containing two equal cards,
     * or -1 if no such subarray exists
     */
    public int minimumCardPickup(int[] cards) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < cards.length; i++) {
            int cardValue = cards[i]; // cardValue = current index

            if (map.containsKey(cardValue)) {// this card value was seen before
                // get where we last saw this card
                int lastIndex = map.get(cardValue);

                // calculate the distance (length of the subarray)
                int distance = i - lastIndex + 1;

                // update out minimum
                minLength = Math.min(minLength, distance);
            }

            // update the map with current index
            map.put(cardValue, i);

        }
        if (minLength == Integer.MAX_VALUE) {
            return -1;
        } else {
            return minLength;
        }
    }
}
