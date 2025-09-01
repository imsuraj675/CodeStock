#include <vector>
#include <string>
#include <algorithm>
/*
	(c) Aritro 'sortira' Shome
*/
void backtrack(std::string &s, std::string &path, std::vector<bool> &used, std::vector<std::string> &result) {
    if (path.length() == s.length()) {
        result.push_back(path);
        return;
    }
    for (size_t i = 0; i < s.length(); ++i) {
        if (used[i]) continue;
        used[i] = true;
        path.push_back(s[i]);
        backtrack(s, path, used, result);
        path.pop_back();
        used[i] = false;
    }
}

std::vector<std::string> generatePermutations(std::string s) {
    std::vector<std::string> result;
    std::string path;
    std::vector<bool> used(s.size(), false);
    backtrack(s, path, used, result);
    return result;
}

// Example usage:
#include <iostream>

int main() {
    std::vector<std::string> permutations = generatePermutations("abc");
    for (const auto &perm : permutations) {
        std::cout << perm << std::endl;
    }
    return 0;
}
