#include <cstdio>

int N, n, min = 1000000, max = 2;

int main() {
#ifdef _WIN32
	freopen("input.txt", "r", stdin);
#endif // _WIN32
	scanf("%d", &N);
	while (N--) {
		scanf("%d", &n);
		if (n < min) min = n;
		if (n > max) max = n;
	}

	printf("%d\n", min * max);
	return 0;
}