#include <iostream>
#include <sstream>
using namespace std;

struct Node {
	int data;
	Node* next;

	Node(int data) {
		this->data = data;
		this->next = nullptr;
	}
};

// 1. I(삽입) x, y, s : 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입한다. 
// s는 덧붙일 숫자들이다.[ ex) I 3 2 123152 487651 ]
void insert(Node*& head, int pos, int addCnt) {
	Node* prev = nullptr;
	Node* cur = head;
	for (int i = 0; i < pos && cur; i++) { // cir 이 nullptr이 아닐때만 만족
		prev = cur;
		cur = cur->next;
	}
	for (int i = 0; i < addCnt; i++) {
		int valToAdd;
		cin >> valToAdd;
		Node* newNode = new Node(valToAdd);
		if (prev) prev->next = newNode;
		newNode->next = cur;
		if (!prev)head = newNode;
		prev = newNode;
	}
}

// 2. D(삭제) x, y : 앞에서부터 x의 위치 바로 다음부터 y개의 숫자를 삭제한다.[ ex) D 4 4 ]
void remove(Node*& head, int pos, int numToRemove) {
	Node* prev = nullptr;
	Node* cur = head;
	for (int i = 0; i < pos && cur; i++) {
		prev = cur;
		cur = cur->next;
	}
	for (int i = 0; i < numToRemove && cur; i++) {
		Node* temp = cur;
		cur = cur->next;
		delete temp;
	}
	if (prev) prev->next = cur;
	else head = cur;

}

// A(추가) y, s : 암호문의 맨 뒤에 y개의 숫자를 덧붙인다. s는 덧붙일 숫자들이다. 
// [ ex) A 2 421257 796813 ]
void add(Node*& head, int numToAdd) {
	Node* prev = nullptr;
	Node* cur = head;
	while (cur) {
		prev = cur;
		cur = cur->next;
	}
	for (int i = 0; i < numToAdd; i++) {
		int valToAdd;
		cin >> valToAdd;
		Node* newNode = new Node(valToAdd);
		if (prev) prev->next = newNode;
		else head = newNode;
		prev = newNode;
	}
}

void printList(Node* head) {
	for (int i = 0; i < 10 && head; i++) {
		cout << head->data << " ";
		head = head->next;
	}
	cout << endl;
}

int main() {
	for (int t = 1; t <= 10; t++) {
		int n, M;
		cin >> n;
		Node* head = nullptr;
		for (int i = 0; i < n; i++) {
			int val;
			cin >> val;
			Node* newNode = new Node(val);
			if (head) {
				Node* cur = head;
				while (cur->next) {
					cur = cur->next;
				}
				cur->next = newNode;
			}
			else {
				head = newNode;
			}
		}
		cin >> M;
		while (M--) {
			char cmd;
			cin >> cmd;
			if (cmd == 'I') {
				int pos, numToAdd;
				cin >> pos >> numToAdd;
				insert(head, pos, numToAdd);
			}
			else if (cmd == 'D') {
				int pos, numToRemove;
				cin >> pos >> numToRemove;
				remove(head, pos, numToRemove);
			}
			else if (cmd == 'A') {
				int numToAdd;
				cin >> numToAdd;
				add(head, numToAdd);
			}
		}
		cout << "#" << t << " ";
		printList(head);
	}
	return 0;
}