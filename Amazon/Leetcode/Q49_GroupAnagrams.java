import java.util.*;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]

Time: O(NKlogK)
Space: O(NK)
 */

class Q49_GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs)
    {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) return result;
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++)
        {
            char [] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String val = new String(ch);
            if (!map.containsKey(val)) map.put(val, new ArrayList<>());
            map.get(val).add(strs[i]);
        }
        result.addAll(map.values());
        return result;
    }

    public static void main(String[] args)
    {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> input = groupAnagrams(arr);
        for (List<String> list : input)
        {
            for (String s : list) System.out.println(s);
        }
    }
}
