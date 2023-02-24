#include <iostream>
using namespace std;

int main() {
	int T;
	cin >> T;
	for (int t = 1; t <= T; t++) {
		int N;
		cin >> N;
		int cnt[10] = { 0 }; // 각 숫자가 나온 횟수를 저장할 배열
		int mul = 0; // 현재 곱하는 숫자
		while (true) {
			mul++;
			int num = N * mul; //  현재 곱한 숫자
			while (num > 0) { // 각 자리 수를 탐색하며 cnt 배열 갱신
				cnt[num % 10] = 1;
				num /= 10;
			}
			bool all_seen = true; // 0~9까지 모든숫자를 본 경우
			for (int i = 0; i < 10; i++) {
				if (cnt[i] == 0) {
					all_seen = false;
					break;
				}
			}
			if (all_seen) {
				cout << "#" << t << " " << mul * N << endl;
				break;
			}
		}
	}
	return 0;
}