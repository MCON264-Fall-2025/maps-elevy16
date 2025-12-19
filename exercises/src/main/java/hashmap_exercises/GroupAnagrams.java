package hashmap_exercises;

import java.util.*;

/**
 * LeetCode 49 - Group Anagrams
 *
 * Given an array of strings strs, group the anagrams together.
 * You can return the answer in any order.
 *
 * Example:
 * Input:  ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]] (order may vary)
 */
public class GroupAnagrams {

    /**
     * Groups the given words into lists of anagrams.
     *
     * @param strs array of input strings
     * @return a list of groups, where each group is a list of anagrams
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String canonical = new String(charArray);

            // check if canonical form exists in the map
            if (!map.containsKey(canonical)) {
                map.put(canonical, new ArrayList<>()); // create a new list for this canonical form
            }

            // add the word to the list for this canonical form
            map.get(canonical).add(word);
        }

        return new ArrayList<>(map.values());
    }
}

