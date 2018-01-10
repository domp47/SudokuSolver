#include <iostream>
#include <chrono>
#include "SudokuSolver.h"

int main() {

    std::chrono::high_resolution_clock::time_point before = std::chrono::high_resolution_clock::now();
    SudokuSolver ss;
    std::chrono::high_resolution_clock::time_point after = std::chrono::high_resolution_clock::now();

    auto duration = std::chrono::duration_cast<std::chrono::milliseconds>( after - before).count();

    std::cout << "Time to create puzzle: " << duration << "ms." << std::endl;

    before = std::chrono::high_resolution_clock::now();
    ss.SolvePuzzle();
    after = std::chrono::high_resolution_clock::now();
    duration = std::chrono::duration_cast<std::chrono::milliseconds>( after - before).count();

    ss.PrintBoard();
    std::cout << "Time to solve puzzle: " << duration << "ms." << std::endl;


    return 0;
}