import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);          // sort logs by time

        int m = queries.length;
        Integer[] order = new Integer[m];                   // query indices sorted by query value
        for (int i = 0; i < m; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> queries[a] - queries[b]);

        int[] cnt = new int[n + 1];                         // requests per server inside the window
        int active = 0;                                     // servers with cnt > 0
        int l = 0, r = 0;
        int[] ans = new int[m];

        for (int idx : order) {
            int q = queries[idx];

            while (r < logs.length && logs[r][1] <= q) {    // add logs up to time q
                if (cnt[logs[r][0]]++ == 0) active++;
                r++;
            }
            while (l < r && logs[l][1] < q - x) {           // drop logs before q - x
                if (--cnt[logs[l][0]] == 0) active--;
                l++;
            }
            ans[idx] = n - active;
        }
        return ans;
    }
}