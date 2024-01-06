class Solution {
    long M = (long) 1e9 + 7;
	long M1 = 37;
	long[] sh;
	long[] P;
	long[] MI;
	Map<Long, Integer> whs = new HashMap<>();

	public List<Integer> findSubstring(String s, String[] words) {
		int ws = words[0].length();
		int n = words.length;
		sh = new long[s.length() + 1];
		P = new long[s.length() + 1];
		MI = new long[s.length() + 1];
		P[0] = 1;
        MI[0]=1;
		char[] cs = s.toCharArray();
		int i = 1;

		long sum = 0;
		for (char c : cs) {
			sum += P[i - 1] * c;
			sum %= M;
			sh[i] = sum;
			P[i] = P[i - 1] * M1 % M;
			MI[i] = miv(P[i]);
			i++;
		}
		i = 0;
		int j;
		long t;
		for (String w : words) {
			j = 0;
			t = 0;
			for (char c : w.toCharArray()) {
				t += P[j] * c;
				t %= M;
				j++;
			}
			whs.computeIfAbsent(t, key -> 0);
			whs.compute(t, (k, v) -> v + 1);
		}

		Map<Long, Integer> b;
		List<Integer> res = new ArrayList<>();
		for (i = 0; i <= s.length() - n * ws; i++) {
			j = 0;
			b = new HashMap<>();

			while (j < n) {
				t = (sh[i + j * ws + ws] + M - sh[i + j * ws]) % M * MI[i + j * ws] % M;
				b.computeIfAbsent(t, key -> 0);
				b.compute(t, (k, v) -> v + 1);
				if (!whs.containsKey(t) || b.get(t) > whs.get(t))
					break;
				j++;
			}

			if (j == n)
				res.add(i);

		}

		return res;
	}

	public long miv(long a) {
		return power(a, (int) M - 2);
	}

	public long power(long a, int n) {
		if (n == 1)
			return a;
		if (n == 0)
			return 1;
		long t = power(a, n / 2);
		t = t * t % M;
		t *= n % 2 == 1 ? a : 1;
		return t % M;
	}
}
