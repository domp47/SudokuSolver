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
    bool SolvePuzzle();

private:
    void zero();
    bool generateBoard();
    bool fillBoard(std::mt19937);
    int createPuzzle();
    bool FindNumSolutions();
    std::array<std::array<int, 9>, 9> copyBoard(std::array<std::array<int, 9>, 9>);
    std::array<int,2> searchSmallestCandidate();
    std::vector<int> RemoveFromVector(int n, std::vector<int> vector);
    std::vector<int> GetCandidates(int x, int y);
    std::array<int,2> getUnassignedLocation();
    bool isValid(int x, int y, int number);
private:
    std::array<std::array<int, 9>, 9> sudokuBoard;
    std::array<std::array<int, 9>, 9> cpyOfBoard;
    std::vector<int> candidates;
    int nSolutions;

};


#endif //SUDOKUSOLVER_H
