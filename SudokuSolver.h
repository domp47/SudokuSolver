//
// Created by dom on 1/8/18.
//

#ifndef SUDOKUSOLVER_H
#define SUDOKUSOLVER_H

#include <array>
#include <vector>
#include <random>

class SudokuSolver {
public:
    SudokuSolver();
    void PrintBoard();

private:
    void zero();
    void generateBoard();
    bool fillBoard(std::mt19937 );
    std::array<int,2> searchSmallestCandidate();
    std::vector<int> RemoveFromVector(int n, std::vector<int> vector);
    std::vector<int> GetCandidates(int x, int y);
private:
    std::array<std::array<int, 9>, 9> sudokuBoard;
    std::vector<int> candidates;

};


#endif //SUDOKUSOLVER_H
