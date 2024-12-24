/**import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}**/

class Solution {
    public int minimumOperations(TreeNode root) {
        if (root == null) return 0;

        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // Level order traversal to collect values at each level
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                currentLevel.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            list.add(currentLevel);
        }

        int totalSwaps = 0;

        // Process each level to count the minimum swaps needed
        for (List<Integer> level : list) {
            totalSwaps += countSwaps(level);
        }
        return totalSwaps;
    }

    private int countSwaps(List<Integer> level) {
        int n = level.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = level.get(i);
        }

        // Create a sorted version of the array
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        // Create a map to store the original indices of the sorted values
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(sorted[i], i);
        }

        boolean[] visited = new boolean[n];
        int swaps = 0;

        // Count the number of swaps needed using cycle detection
        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i] == sorted[i]) {
                continue; // Already in the correct position or visited
            }

            // Count the size of the cycle
            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = indexMap.get(arr[j]); // Move to the next index in the cycle
                cycleSize++;
            }

            // If there is a cycle of size k, we need (k - 1) swaps to sort it
            if (cycleSize > 0) {
                swaps += (cycleSize - 1);
            }
        }
        return swaps;
    }
}