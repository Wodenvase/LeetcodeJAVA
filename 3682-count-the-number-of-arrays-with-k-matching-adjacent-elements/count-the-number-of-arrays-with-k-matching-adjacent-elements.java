public class Solution {
    static final int MOD = (int)1e9 + 7;
    static final int MAX = 100000;
    static int[] factorial = new int[MAX];
    static int[] Inv = new int[MAX];

    static {
        factorial[0] = 1;
        Inv[0] = 1;
        for (int i = 1; i < MAX; i++) {
            factorial[i] = (int)((long)factorial[i - 1] * i % MOD);
        }

        Inv[MAX - 1] = modInverse(factorial[MAX - 1], MOD);
        for (int i = MAX - 2; i >= 0; i--) {
            Inv[i] = (int)((long)Inv[i + 1] * (i + 1) % MOD);
        }
    }

    public static int modInverse(int a, int mod) {
        int x0 = 1, x1 = 0;
        int r0 = a, r1 = mod;
        while (r1 != 0) {
            int q = r0 / r1;
            int rr = r1;
            int xx = x1;
            r1 = r0 - q * r1;
            x1 = x0 - q * x1;
            r0 = rr;
            x0 = xx;
        }
        if (x0 < 0) {
            x0 += mod;
        }
        return x0;
    }

    public static int modPow(int x, int exp, int mod) {
        int result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (int)((long)result * x % mod);
            }
            x = (int)((long)x * x % mod);
            exp /= 2;
        }
        return result;
    }

    public static int comb(int n, int k) {
        if (k > n || k < 0) return 0;
        return (int)((long)factorial[n] * Inv[k] % MOD * Inv[n - k] % MOD);
    }

    public int countGoodArrays(int n, int m, int k) {
        return (int)((long)m * modPow(m - 1, n - k - 1, MOD) % MOD * comb(n - 1, k) % MOD);
    }
}