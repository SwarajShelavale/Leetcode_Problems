public class Solution {
    public int numberOfBeams(String[] bank) {
        int curr, prev = 0;
        int n = bank.length;    // Number of rows in the bank
        int m = bank[0].length(); // Number of columns in the bank
        int ans1 = 0;           // Variable to store the total number of laser beams

        // Iterate through each row of the bank
        for (int i = 0; i < n; i++) {
            curr = 0; // Reset the current count of security devices for each row

            // Iterate through each column of the current row
            for (int j = 0; j < m; j++) {
                if (bank[i].charAt(j) == '1') {
                    curr++; // Count the number of security devices in the current row
                }
            }

            // If there are security devices in the current row
            if (curr != 0) {
                // Accumulate the product of current count and previous count
                ans1 += curr * prev;
                prev = curr; // Update the previous count for the next iteration
            }
        }

        // Return the total number of laser beams
        return ans1;
    }
}
