//
// Created by dom on 1/8/18.
//

#include "SudokuSolver.h"
#include <iostream>
#include <random>
#include <climits>

SudokuSolver::SudokuSolver() {

    for (int i = 1; i <= sudokuBoard.size(); ++i) {
        candidates.push_back(i);
    }

    zero();
    std::cout << "Filling Board." << std::endl;
    bool success = generateBoard();
    if(success){
        std::cout << "Generating puzzle." << std::endl;
        createPuzzle();
        std::cout << "Puzzle to be solved: " << std::endl;
        PrintBoard();
    }else{
        std::cout << "Cannot generate puzzle." << std::endl;
    }
}

void SudokuSolver::PrintBoard(){
    std::cout << std::endl << "##################################" << std::endl;
    for(int y = 0; y < sudokuBoard.size(); y++) {
        for (int x = 0; x < sudokuBoard.at(y).size(); x++) {

            if(sudokuBoard[y][x]==0){
                std::cout << " ";
            }else{
                std::cout << sudokuBoard.at(y).at(x);
            }

            if ((x + 1) < sudokuBoard.at(y).size() && (x + 1) % 3 == 0)
                std::cout << " # ";
            else if ((x + 1) < sudokuBoard.at(y).size())
                std::cout << " | ";
        }

        if ((y + 1) < sudokuBoard.size() && (y + 1) % 3 == 0) {
            std::cout << std::endl << "##################################" << std::endl;
        } else if ((y + 1) < sudokuBoard.size())
            std::cout << std::endl << "----------#-----------#-----------" << std::endl;
    }
    std::cout << std::endl << "##################################" << std::endl;
}

void SudokuSolver::zero() {
    for(int y = 0; y < sudokuBoard.size(); y++) {
        for (int x = 0; x < sudokuBoard.at(y).size(); x++) {
            sudokuBoard.at(y).at(x) = 0;
        }
    }
}

bool SudokuSolver::fillBoard(std::mt19937 gen) {
    std::array<int,2> locOfSmallest = searchSmallestCandidate();

    if(locOfSmallest[0]==-1&&locOfSmallest[1]==-1){
        return true;
    }

    std::vector<int> candidates = GetCandidates(locOfSmallest[0], locOfSmallest[1]);

    while(!candidates.empty()){
        std::uniform_int_distribution<> dis(0,(int)(candidates.size()-1));
        int val = candidates.at(dis(gen));

        sudokuBoard[locOfSmallest[1]][locOfSmallest[0]] = val;

        if(fillBoard(gen)){
            return true;
        }else{
            RemoveFromVector(val, candidates);
            sudokuBoard[locOfSmallest[1]][locOfSmallest[0]] = 0;
        }
    }

    return false;
}

bool SudokuSolver::generateBoard() {

    std::random_device rd;
    std::mt19937 gen(rd());
    std::uniform_int_distribution<> dis(1,9);


    //Generate top left square
    int randomNine[9];
    for(int i = 0; i < 9; i++) {
        bool isInBuffer;
        int rand;

        do{
            isInBuffer = false;
            rand = dis(gen);


            for (int num: randomNine) {
                if (rand == num) {
                    isInBuffer = true;
                }
            }
        }while(isInBuffer);

        randomNine[i] = rand;
    }

    for(int y = 0; y < 3; y++) {
        for (int x = 0; x < 3; x++) {
            sudokuBoard.at(y).at(x) = randomNine[x+(y*3)];
        }
    }

    bool successfulFill = fillBoard(gen);
    if(successfulFill)
        std::cout << "Board filled successfully." << std::endl;
    else
        std::cout << "Error filling board." << std::endl;
    return successfulFill;
}

std::array<int, 2> SudokuSolver::searchSmallestCandidate() {
    int bestX = -1;
    int bestY = -1;
    int lowestNumCandidates = INT_MAX;

//    std::vector<int> candidates;

    for(int y = 0; y < sudokuBoard.size(); y++) {
        for (int x = 0; x < sudokuBoard.at(y).size(); x++) {

            if(sudokuBoard[y][x]==0) {

                std::vector<int> copyCandidate(candidates);

                for (int xx = 0; xx < sudokuBoard.at(y).size(); xx++) {
                    copyCandidate = RemoveFromVector(sudokuBoard[y][xx], copyCandidate);
                }
                for (int yy = 0; yy < sudokuBoard.size(); yy++) {
                    copyCandidate = RemoveFromVector(sudokuBoard[yy][x], copyCandidate);
                }

                int yQuad = y / 3;
                int xQuad = x / 3;

                for (int yy = 0; yy < 3; yy++) {
                    for (int xx = 0; xx < 3; xx++) {
                        int xPosToRemove = (xQuad * 3) + xx;
                        int yPosToRemove = (yQuad * 3) + yy;

                        copyCandidate = RemoveFromVector(sudokuBoard[yPosToRemove][xPosToRemove], copyCandidate);
                    }
                }

                if (copyCandidate.size() < lowestNumCandidates) {
                    lowestNumCandidates = (int) copyCandidate.size();
                    bestX = x;
                    bestY = y;
                }
            }

        }
    }

    std::array<int,2> arr{{bestX, bestY}};

    return arr;
}

std::vector<int> SudokuSolver::RemoveFromVector(int n, std::vector<int> vector) {

    for(int i = 0; i < vector.size(); i++){
        if(vector[i]==n){
            vector.erase(vector.begin()+i);
        }
    }

    return vector;
}

std::vector<int> SudokuSolver::GetCandidates(int x, int y) {
    std::vector<int> candidates;

    for (int i = 1; i <= sudokuBoard.size(); ++i) {
        candidates.push_back(i);
    }


    for(int xx = 0; xx < sudokuBoard[y].size(); xx++){
        candidates = RemoveFromVector(sudokuBoard[y][xx], candidates);
    }
    for(int yy = 0; yy < sudokuBoard.size(); yy++){
        candidates = RemoveFromVector(sudokuBoard[yy][x], candidates);
    }

    int yQuad = y / 3;
    int xQuad = x / 3;

    for(int yy = 0; yy < 3; yy++){
        for(int xx = 0; xx < 3; xx++){
            int xPosToRemove = (xQuad*3)+xx;
            int yPosToRemove = (yQuad*3)+yy;

            candidates = RemoveFromVector(sudokuBoard[yPosToRemove][xPosToRemove], candidates);
        }
    }

    return candidates;
}

bool SudokuSolver::SolvePuzzle() {
    std::array<int,2> unassignedCords = getUnassignedLocation();

    if(unassignedCords[0]==-1&&unassignedCords[1]==-1){
        return true; //Solved
    }

    for(int number = 1; number <= 9; number++){
        if(isValid(unassignedCords[0],unassignedCords[1],number)){
            sudokuBoard[unassignedCords[1]][unassignedCords[0]] = number;

            if(SolvePuzzle()){
                return true;
            }

            sudokuBoard[unassignedCords[1]][unassignedCords[0]] = 0;
        }
    }
    return false;
}

std::array<int, 2> SudokuSolver::getUnassignedLocation() {
    for(int y = 0; y < sudokuBoard.size(); y++) {
        for (int x = 0; x < sudokuBoard.at(y).size(); x++) {
            if(sudokuBoard[y][x]==0){
                std::array<int,2> array = {{x, y}};
                return  array;
            }
        }
    }

    std::array<int,2> array = {{-1,-1}};
    return array;
}

bool SudokuSolver::isValid(int x, int y, int number) {
    for(int col = 0; col < sudokuBoard.size(); col++){
        if(sudokuBoard[col][x]==number){
            return false;
        }
    }
    for(int row = 0; row < sudokuBoard[y].size(); row++){
        if(sudokuBoard[y][row]==number){
            return false;
        }
    }

    int yQuad = y / 3;
    int xQuad = x / 3;

    for(int yy = 0; yy < 3; yy++) {
        for (int xx = 0; xx < 3; xx++) {
            int xPos = (xQuad*3)+xx;
            int yPos = (yQuad*3)+yy;

            if(sudokuBoard[yPos][xPos]==number){
                return false;
            }
        }
    }
    return true;
}

int SudokuSolver::createPuzzle() {
    int failCounter = 0;


    std::random_device rd;
    std::mt19937 gen(rd());
    std::uniform_int_distribution<> dis(0,8);

    while(failCounter<10){
        int xRand = dis(gen);
        int yRand = dis(gen);
        int inversexRand = 8 - xRand;
        int inverseyRand = 8 - yRand;

        int numToRemove = sudokuBoard[yRand][xRand];
        int inverseNumToRemove = sudokuBoard[inverseyRand][inversexRand];

        if(numToRemove!=0||inverseNumToRemove!=0){
            sudokuBoard[yRand][xRand] = 0;
            sudokuBoard[inverseyRand][inversexRand] = 0;
            cpyOfBoard = copyBoard(sudokuBoard);

            nSolutions = 0;
            FindNumSolutions();

            if(nSolutions!=1){
                sudokuBoard = copyBoard(cpyOfBoard);
                sudokuBoard[yRand][xRand] = numToRemove;
                sudokuBoard[inverseyRand][inversexRand] = inverseNumToRemove;
                failCounter++;
            }else{
                sudokuBoard = copyBoard(cpyOfBoard);
                failCounter = 0;
            }
        }
    }
}

std::array<std::array<int, 9>, 9> SudokuSolver::copyBoard(std::array<std::array<int, 9>, 9> src) {
    std::array<std::array<int, 9>, 9> dst;

    for(int y = 0; y < 9; y++){
        for(int x = 0; x < 9; x++){
            dst[y][x] = src[y][x];
        }
    }

    return dst;
}

bool SudokuSolver::FindNumSolutions() {
    std::array<int,2> unassignedCords = getUnassignedLocation();

    if(unassignedCords[0]==-1&&unassignedCords[1]==-1){
        return true; //Solved
    }

    for(int number = 1; number <= 9; number++){
        if(isValid(unassignedCords[0],unassignedCords[1],number)){
            sudokuBoard[unassignedCords[1]][unassignedCords[0]] = number;

            if(FindNumSolutions()){
                nSolutions++;
            }

            sudokuBoard[unassignedCords[1]][unassignedCords[0]] = 0;
        }
    }
    return false;
}
