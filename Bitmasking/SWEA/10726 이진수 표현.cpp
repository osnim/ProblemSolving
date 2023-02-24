#include <iostream>
using namespace std;

int main() {
	int T;
	cin >> T;

	for (size_t t = 1; t <= T; t++) {
		int N, M;
		cin >> N >> M;
		int LastNbit = (1 << N) - 1;

		if (LastNbit == (M & LastNbit)) {
			cout << "#" << t << " ON" << endl;
		}
		else {
			cout << "#" << t << " OFF" << endl;
		}
	}
}