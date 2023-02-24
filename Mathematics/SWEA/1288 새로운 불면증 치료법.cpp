#include <iostream>
using namespace std;

int main() {
	int T;
	cin >> T;
	for (int t = 1; t <= T; t++) {
		int N;
		cin >> N;
		int cnt[10] = { 0 }; // �� ���ڰ� ���� Ƚ���� ������ �迭
		int mul = 0; // ���� ���ϴ� ����
		while (true) {
			mul++;
			int num = N * mul; //  ���� ���� ����
			while (num > 0) { // �� �ڸ� ���� Ž���ϸ� cnt �迭 ����
				cnt[num % 10] = 1;
				num /= 10;
			}
			bool all_seen = true; // 0~9���� �����ڸ� �� ���
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