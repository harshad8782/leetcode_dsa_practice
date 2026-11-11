class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long a = cost(0, cost1, cost2, costBoth, need1, need2);
        long b = cost(Math.min(need1, need2), cost1, cost2, costBoth, need1, need2);
        long c = cost(Math.max(need1, need2), cost1, cost2, costBoth, need1, need2);
        return Math.min(a, Math.min(b, c));
    }

    // total cost when buying 'both' items of type 3
    private long cost(long both, long c1, long c2, long cb, long n1, long n2) {
        return both * cb
             + Math.max(0, n1 - both) * c1
             + Math.max(0, n2 - both) * c2;
    }
}