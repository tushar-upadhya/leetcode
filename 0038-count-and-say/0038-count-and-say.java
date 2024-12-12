class Solution {
    public String countAndSay(int n) {
        String result = "1";

        //generate sequence from 2 to n

        for(int i = 2; i <= n; i++)        {
            result = generateNextTerm(result);
        }
        return result;
    }

private String generateNextTerm(String currentTerm) {
    StringBuilder sb = new StringBuilder();
    int count = 1;

    // Iterate over the string starting from the second character
    for (int i = 1; i < currentTerm.length(); i++) {
        // If the current character is the same as the previous one, increment the count
        if (currentTerm.charAt(i) == currentTerm.charAt(i - 1)) {
            count++;
        } else {
            // Append the count and the previous character to sb
            sb.append(count).append(currentTerm.charAt(i - 1));
            count = 1; // Reset the count for the new character
        }
    }

    // Append the count and the last character group after the loop
    sb.append(count).append(currentTerm.charAt(currentTerm.length() - 1));

    return sb.toString();
}


}