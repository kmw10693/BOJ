#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

struct TREE {
    int Idx;
    int x;
    int y;
    TREE *Left;
    TREE *Right;
};

void make_binary(TREE *Root, TREE *Child) {
    if(Root -> x > Child -> x) {
        if(Root ->Left == NULL) {
            Root -> Left = Child;
            return;
        }
        make_binary(Root->Left, Child);
    }
    else {
        if(Root -> Right == NULL) {
            Root -> Right = Child;
            return;
        }
            make_binary(Root->Right, Child);

    }
}

void PreOrder(TREE *Root, vector<int> &answer) {
    if(Root == NULL) return;
    answer.push_back(Root->Idx);
    PreOrder(Root->Left, answer);
    PreOrder(Root->Right, answer);
}

void PostOrder(TREE *Root, vector<int> &answer) {
    if(Root == NULL) return;
    PostOrder(Root->Left, answer);
    PostOrder(Root->Right, answer);
    answer.push_back(Root->Idx);
}

bool cmp(TREE A, TREE B) {
    if(A.y >= B.y) {
        if(A.y == B.y) {
            if(A.x < B.x) return true;
            return false;
        }
        return true;
    }
    return false;
}


vector<vector<int>> solution(vector<vector<int>> nodeinfo) {
    vector<vector<int>> answer;
    vector<TREE> tree;
    
    for(int i=0; i<nodeinfo.size(); i++) {
        int x = nodeinfo[i][0];
        int y = nodeinfo[i][1];
        int idx = i + 1;
        tree.push_back({idx, x, y, NULL, NULL});
    }
    sort(tree.begin(), tree.end(), cmp);
    TREE *root = &tree[0];
    for(int i=1; i<tree.size(); i++) make_binary(root, &tree[i]);
    vector<int> preV; PreOrder(root, preV);
    vector<int> PostV; PostOrder(root, PostV);
    answer.push_back(preV);
    answer.push_back(PostV);
    return answer;
}