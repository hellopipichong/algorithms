package sliding_window.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符串最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 解题思路：滑动窗口（队列：数组、字符串等等） 所谓滑动窗口就是控制左右边界，然后朝着一个方向遍历
 *
 * @author wangyong
 * @since 2020/5/12
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        int max = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
                max = Math.max(max, i - left + 1);
            }
            else {
                int newLeft = map.get(s.charAt(i)) + 1;
                for (int j = left; j < newLeft; j++) {
                    map.remove(s.charAt(j));
                }
                map.put(s.charAt(i), i);
                left = newLeft;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));//3
        System.out.println(solution.lengthOfLongestSubstring("pwwkepw"));//4
        System.out.println(solution.lengthOfLongestSubstring("tmmzuxt")); // 5
        System.out.println(solution.lengthOfLongestSubstring("asjrgapa")); //6
    }


}
