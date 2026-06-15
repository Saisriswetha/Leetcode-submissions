class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        Set<Long> candidates = new HashSet<>();
        
        candidates.add((long)Math.pow(10, len - 1) - 1);
        candidates.add((long)Math.pow(10, len) + 1);
        
        String prefix = n.substring(0, (len + 1) / 2);
        
        for (long delta = -1; delta <= 1; delta++) {
            long newPrefixNum = Long.parseLong(prefix) + delta;
            String newPrefix = String.valueOf(newPrefixNum);
            String palindrome = buildPalindrome(newPrefix, len % 2 == 1);
            
            if (palindrome.length() == len) {
                candidates.add(Long.parseLong(palindrome));
            }
        }
        
        long num = Long.parseLong(n);
        candidates.remove(num);
        
        long result = -1;
        long minDiff = Long.MAX_VALUE;
        
        for (long candidate : candidates) {
            long diff = Math.abs(candidate - num);
            if (diff < minDiff || (diff == minDiff && candidate < result)) {
                minDiff = diff;
                result = candidate;
            }
        }
        
        return String.valueOf(result);
    }
    
    private String buildPalindrome(String prefix, boolean isOdd) {
        String palindrome = prefix;
        int start = isOdd ? prefix.length() - 2 : prefix.length() - 1;
        for (int i = start; i >= 0; i--) {
            palindrome += prefix.charAt(i);
        }
        return palindrome;
    }
}