import java.util.*;

class Fancy {

    long MOD = 1000000007;
    List<Long> list;
    long mul = 1;
    long add = 0;

    public Fancy() {
        list = new ArrayList<>();
    }

    public void append(int val) {

        long x = (val - add + MOD) % MOD;
        x = (x * modInverse(mul)) % MOD;

        list.add(x);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {

        if (idx >= list.size()) return -1;

        long val = list.get(idx);
        val = (val * mul + add) % MOD;

        return (int) val;
    }

    private long modPow(long x, long n) {

        long res = 1;

        while (n > 0) {

            if ((n & 1) == 1)
                res = (res * x) % MOD;

            x = (x * x) % MOD;
            n >>= 1;
        }

        return res;
    }

    private long modInverse(long x) {
        return modPow(x, MOD - 2);
    }
}