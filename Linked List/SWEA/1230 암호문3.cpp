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

// 1. I(����) x, y, s : �տ������� x�� ��ġ �ٷ� ������ y���� ���ڸ� �����Ѵ�. 
// s�� ������ ���ڵ��̴�.[ ex) I 3 2 123152 487651 ]
void insert(Node*& head, int pos, int addCnt) {
	Node* prev = nullptr;
	Node* cur = head;
	for (int i = 0; i < pos && cur; i++) { // cir �� nullptr�� �ƴҶ��� ����
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

// 2. D(����) x, y : �տ������� x�� ��ġ �ٷ� �������� y���� ���ڸ� �����Ѵ�.[ ex) D 4 4 ]
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

// A(�߰�) y, s : ��ȣ���� �� �ڿ� y���� ���ڸ� �����δ�. s�� ������ ���ڵ��̴�. 
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