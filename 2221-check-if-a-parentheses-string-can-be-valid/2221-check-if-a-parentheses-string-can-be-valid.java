class Solution {
    public boolean canBeValid(String s, String locked) {
        int stringLength = s.length();

        if(stringLength % 2 == 1){
            return false;
        }
        Stack<Integer> openIndices = new Stack<>();
        Stack<Integer> unLockedIndices = new Stack<>();

        // Traverse the string
        for (int i = 0; i < stringLength; i++) {
            if (locked.charAt(i) == '0') {
                unLockedIndices.push(i);
            } else if (s.charAt(i) == '(') {
                openIndices.push(i);
            } else if (s.charAt(i) == ')') {
                if (!openIndices.isEmpty()) {
                    openIndices.pop();
                } else if (!unLockedIndices.isEmpty()) {
                    unLockedIndices.pop();
                } else {
                    return false;
                }
            }
        }


            // Match remaining open parentheses 

        while(!openIndices.isEmpty() && !unLockedIndices.isEmpty() && openIndices.peek() < unLockedIndices.peek()){
            openIndices.pop();
            unLockedIndices.pop();
        }

        // final check

        if(openIndices.isEmpty() && !unLockedIndices.isEmpty()){
            return unLockedIndices.size() % 2 == 0;
        }

        return openIndices.isEmpty();
    }
}

/* 

\U0001f9e0 Intuition
The problem involves determining if a string of parentheses (s) can be rearranged into a valid format using unlocked positions. A valid string must satisfy:

Every ) has a matching ( before it.
The total count of ( and ) is balanced.
Key observation:
Unlocked positions (locked[i] == '0') can act as either ( or ), which provides flexibility. This flexibility can be managed using stacks to track indices of open parentheses and unlocked positions.

\U0001f680 Approach
Step 1: Handle Odd-Length Strings
A valid parentheses string must have an even length. If s.length() is odd, immediately return false.
Step 2: Traverse String and Use Stacks
Use two stacks:
openIndices to store indices of locked (.
unlockedIndices to store indices of unlocked positions (locked[i] == '0').
For every character:
If it’s unlocked, push its index to unlockedIndices.
If it’s (, push its index to openIndices.
If it’s ), try to match it:
First, use any available ( from openIndices.
If openIndices is empty, use an unlocked position from unlockedIndices.
If both are empty, return false (unmatched )).
Step 3: Match Remaining Open Parentheses with Unlocked Positions
After the traversal, there might still be unmatched ( in openIndices.
Use available indices from unlockedIndices to match them.
Ensure the indices of unlocked positions come after the open parentheses they match.
Step 4: Final Check
If openIndices is empty after matching, return true; otherwise, return false.
⏱️ Complexity
Time Complexity:
O(n) — Single traversal of the string and stack operations are O(1).

Space Complexity:
O(n) — Stacks stor


*/