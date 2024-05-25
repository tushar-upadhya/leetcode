public class Solution {
    public int minAnagramLength(String s) {
        int n = s.length();
        List<Integer> factors = new ArrayList<>();
        
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                int k = n / i;
                if (k != i) {
                    factors.add(i);
                    factors.add(k);
                } else {
                    factors.add(i);
                }
            }
        }
        
        Collections.sort(factors);  // Sort the factors in ascending order
        
        for (int factor : factors) {
            Map<Character, Integer> firstSegmentFreq = new HashMap<>();
            
            // Count the frequency of characters in the first segment
            for (int i = 0; i < factor; i++) {
                firstSegmentFreq.put(s.charAt(i), firstSegmentFreq.getOrDefault(s.charAt(i), 0) + 1);
            }
            
            boolean isAnagramic = true;
            
            // Check if the other segments match the first segment's frequency
            for (int i = factor; i < n; i += factor) {
                Map<Character, Integer> segmentFreq = new HashMap<>();
                for (int j = i; j < i + factor; j++) {
                    segmentFreq.put(s.charAt(j), segmentFreq.getOrDefault(s.charAt(j), 0) + 1);
                }
                if (!firstSegmentFreq.equals(segmentFreq)) {
                    isAnagramic = false;
                    break;
                }
            }
            
            if (isAnagramic) {
                return factor;
            }
        }
        
        return n;  // If no anagramic segments, return the full length
    }
}