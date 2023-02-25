#include <iostream>
#include <vector>
using namespace std;

int T, N, M, L;
char cmd;

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> T;
	for (int t = 1; t <= T; t++) {
		cin >> N >> M >> L;
		vector<int> v(N);
		
		for (int i = 0; i < N; i++) {
			cin >> v[i];
		}

		for (int i = 0; i < M; i++) {
			cin >> cmd;
			if (cmd == 'I') {
				int idx, val;
				cin >> idx >> val;
				v.insert(v.begin() + idx, val);
			}
			else if (cmd == 'D') {
				int idx;
				cin >> idx;
				v.erase(v.begin() + idx);
			}
			else if (cmd == 'C') {
				int idx1, val;
				cin >> idx1 >> val;
				v[idx1] = val;
			}
		}

		if (v.size() < L+1) {
			cout << "#" << t << " " << -1 << endl;
		}
		else {
			cout << "#" << t << " " << v[L] << endl;
		}
	}
	return 0;
}
