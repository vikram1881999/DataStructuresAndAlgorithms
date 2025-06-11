package com.vikram.dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class GenericInclusionExclusionCode {

    static final long MOD = 1_000_000_007L;

    /* ------------------------------------------------------------
     * public API
     * ------------------------------------------------------------ */
    public int stringCount(int n, String pattern) {
        if (n < pattern.length()) return 0;   // impossible

        int[] need = new int[26];
        for (char ch : pattern.toCharArray()) need[ch - 'a']++;

        /* distinct letters that actually matter */
        List<Integer> letters = new ArrayList<>();
        for (int c = 0; c < 26; ++c)
            if (need[c] > 0) letters.add(c);
        int k = letters.size();

        /* factorial and inverse factorial up to |pattern|  (≤ 26) */
        int maxF = pattern.length();
        long[] fact = new long[maxF + 1];
        long[] ifact = new long[maxF + 1];
        fact[0] = 1;
        for (int i = 1; i <= maxF; ++i) fact[i] = fact[i - 1] * i % MOD;
        ifact[maxF] = modPow(fact[maxF], MOD - 2);
        for (int i = maxF; i >= 1; --i) ifact[i - 1] = ifact[i] * i % MOD;

        /* main inclusion–exclusion loop */
        long ans = 0;
        int totalMasks = 1 << k;                       // iterate over all S ⊆ Need
        for (int mask = 0; mask < totalMasks; ++mask) {
            int m = Integer.bitCount(mask);            // |S|
            int freeAlphabet = 26 - m;
            if (m == 0) {
                ans = (ans + modPow(26, n)) % MOD;     // empty subset
                continue;
            }

            /* collect the “under-supply” upper bounds j_c ≤ need[c]-1 */
            int[] limits = new int[m];
            int ptr = 0;
            for (int i = 0; i < k; ++i)
                if ((mask & (1 << i)) != 0)
                    limits[ptr++] = need[letters.get(i)] - 1;

            long ways = countFail(n, freeAlphabet, limits, fact, ifact);

            if ((m & 1) == 1) {         // odd |S|  → subtract
                ans = (ans - ways) % MOD;
            } else {                    // even |S| → add
                ans = (ans + ways) % MOD;
            }
        }
        if (ans < 0) ans += MOD;
        return (int) ans;
    }

    /* ------------------------------------------------------------
     * helper: count F(S)
     * limits[i] = need[c]-1  for each c in subset S
     * ------------------------------------------------------------ */
    private long countFail(long n, int alpha, int[] limits,
                           long[] fact, long[] ifact)
    {
        return dfs(0, n, 1L, limits, alpha, fact, ifact);
    }

    private long dfs(int idx, long remaining, long prefix,
                     int[] limits, int alpha,
                     long[] fact, long[] ifact)
    {
        if (idx == limits.length) {
            /* all j_c chosen → fill the rest with (alpha)^(remaining) */
            return prefix * modPow(alpha, remaining) % MOD;
        }

        long total = 0;
        int lim = limits[idx];
        for (int j = 0; j <= lim && j <= remaining; ++j) {
            long choose = smallC(remaining, j, ifact);      // C(remaining, j)
            long next = prefix * choose % MOD;
            total = (total + dfs(idx + 1, remaining - j, next,
                                 limits, alpha, fact, ifact)) % MOD;
        }
        return total;
    }

    /* ------------------------------------------------------------
     *  nCk  (k is tiny: ≤ |pattern| ≤ 26)
     * ------------------------------------------------------------ */
    private long smallC(long n, int k, long[] ifact) {
        if (k == 0) return 1;
        long num = 1;
        for (int i = 0; i < k; ++i)
            num = num * ((n - i) % MOD) % MOD;
        return num * ifact[k] % MOD;         // divide by k!  via inverse
    }

    /* ------------------------------------------------------------
     * binary exponentiation
     * ------------------------------------------------------------ */
    private long modPow(long base, long exp) {
        long res = 1, b = base % MOD;
        long e = exp;
        while (e > 0) {
            if ((e & 1) == 1) res = res * b % MOD;
            b = b * b % MOD;
            e >>= 1;
        }
        return res;
    }

    /* ------------------------------------------------------------
     * quick demo
     * ------------------------------------------------------------ */
    public static void main(String[] args) {
        GenericInclusionExclusionCode gs = new GenericInclusionExclusionCode();

        System.out.println(gs.stringCount(5,  "leeet"));        // 12
        System.out.println(gs.stringCount(5,  "leet"));        // 1460
        System.out.println(gs.stringCount(8,  "aabbccde"));    // 5040
        System.out.println(gs.stringCount(9,  "aabbccde"));    // 1043280
    }
}
