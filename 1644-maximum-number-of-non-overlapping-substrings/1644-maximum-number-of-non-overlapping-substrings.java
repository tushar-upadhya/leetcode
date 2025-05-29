import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int start[] = new int[26];
        int end[] = new int[26];
        
        Arrays.fill(start, -1);
        Arrays.fill(end, -1);

        // Initialize start and end for each character
        for (int i = 0; i < n; i++) {
            int mid = s.charAt(i) - 'a';
            if (start[mid] == -1) start[mid] = i;
            end[mid] = i;
        }

        // Determine the valid substrings
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (start[i] != -1) {
                int left = start[i];
                int right = end[i];
                for (int j = left; j <= right; j++) {
                    left = Math.min(left, start[s.charAt(j) - 'a']);
                    right = Math.max(right, end[s.charAt(j) - 'a']);
                }
                if (left == start[i]) 
                intervals.add(new int[]{left, right});
            }
        }

        // Sort intervals by end index
        Collections.sort(intervals, (a, b) -> a[1] - b[1]);

        // Select the non-overlapping intervals with minimum total length
        List<String> result = new ArrayList<>();
        int prevEnd = -1;
        for (int[] interval : intervals) {
            if (interval[0] > prevEnd) {
                result.add(s.substring(interval[0], interval[1] + 1));
                prevEnd = interval[1];
            }
        }

        return result;
    }
}