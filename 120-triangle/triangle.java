import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        if (n == 1)
            return triangle.get(0).get(0);

        // Create a separate list to store the minimum path sums
        List<List<Integer>> minPathSums = new ArrayList<>(triangle);

        for (int i = 1; i < n; i++) {
            int m = triangle.get(i).size();

            for (int j = 0; j < m; j++) {
                int val = triangle.get(i).get(j);

                if (j == 0)
                    minPathSums.get(i).set(j, minPathSums.get(i - 1).get(j) + val);
                else if (j == m - 1)
                    minPathSums.get(i).set(j, minPathSums.get(i - 1).get(j - 1) + val);
                else
                    minPathSums.get(i).set(j, Math.min(minPathSums.get(i - 1).get(j), minPathSums.get(i - 1).get(j - 1)) + val);
            }
        }

        int mini = Integer.MAX_VALUE;

        // Find the minimum path sum in the last row of minPathSums
        for (int j = 0; j < minPathSums.get(n - 1).size(); j++)
            mini = Math.min(mini, minPathSums.get(n - 1).get(j));

        return mini;
    }
}
