cmake_minimum_required(VERSION 3.9)
project(BacktrackingSudoku)

set(CMAKE_CXX_STANDARD 11)

set(project_sources
        main.cpp
        SudokuSolver.cpp)

set(headers
        SudokuSolver.h)

add_executable(main ${project_sources})
