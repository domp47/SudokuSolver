# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.9

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /home/dom/clion-2017.3.1/bin/cmake/bin/cmake

# The command to remove a file.
RM = /home/dom/clion-2017.3.1/bin/cmake/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/dom/Projects/BacktrackingSudoku

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/dom/Projects/BacktrackingSudoku/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/BacktrackingSudoku.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/BacktrackingSudoku.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/BacktrackingSudoku.dir/flags.make

CMakeFiles/BacktrackingSudoku.dir/main.cpp.o: CMakeFiles/BacktrackingSudoku.dir/flags.make
CMakeFiles/BacktrackingSudoku.dir/main.cpp.o: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/dom/Projects/BacktrackingSudoku/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/BacktrackingSudoku.dir/main.cpp.o"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/BacktrackingSudoku.dir/main.cpp.o -c /home/dom/Projects/BacktrackingSudoku/main.cpp

CMakeFiles/BacktrackingSudoku.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/BacktrackingSudoku.dir/main.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /home/dom/Projects/BacktrackingSudoku/main.cpp > CMakeFiles/BacktrackingSudoku.dir/main.cpp.i

CMakeFiles/BacktrackingSudoku.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/BacktrackingSudoku.dir/main.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /home/dom/Projects/BacktrackingSudoku/main.cpp -o CMakeFiles/BacktrackingSudoku.dir/main.cpp.s

CMakeFiles/BacktrackingSudoku.dir/main.cpp.o.requires:

.PHONY : CMakeFiles/BacktrackingSudoku.dir/main.cpp.o.requires

CMakeFiles/BacktrackingSudoku.dir/main.cpp.o.provides: CMakeFiles/BacktrackingSudoku.dir/main.cpp.o.requires
	$(MAKE) -f CMakeFiles/BacktrackingSudoku.dir/build.make CMakeFiles/BacktrackingSudoku.dir/main.cpp.o.provides.build
.PHONY : CMakeFiles/BacktrackingSudoku.dir/main.cpp.o.provides

CMakeFiles/BacktrackingSudoku.dir/main.cpp.o.provides.build: CMakeFiles/BacktrackingSudoku.dir/main.cpp.o


# Object files for target BacktrackingSudoku
BacktrackingSudoku_OBJECTS = \
"CMakeFiles/BacktrackingSudoku.dir/main.cpp.o"

# External object files for target BacktrackingSudoku
BacktrackingSudoku_EXTERNAL_OBJECTS =

BacktrackingSudoku: CMakeFiles/BacktrackingSudoku.dir/main.cpp.o
BacktrackingSudoku: CMakeFiles/BacktrackingSudoku.dir/build.make
BacktrackingSudoku: CMakeFiles/BacktrackingSudoku.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/dom/Projects/BacktrackingSudoku/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable BacktrackingSudoku"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/BacktrackingSudoku.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/BacktrackingSudoku.dir/build: BacktrackingSudoku

.PHONY : CMakeFiles/BacktrackingSudoku.dir/build

CMakeFiles/BacktrackingSudoku.dir/requires: CMakeFiles/BacktrackingSudoku.dir/main.cpp.o.requires

.PHONY : CMakeFiles/BacktrackingSudoku.dir/requires

CMakeFiles/BacktrackingSudoku.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/BacktrackingSudoku.dir/cmake_clean.cmake
.PHONY : CMakeFiles/BacktrackingSudoku.dir/clean

CMakeFiles/BacktrackingSudoku.dir/depend:
	cd /home/dom/Projects/BacktrackingSudoku/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/dom/Projects/BacktrackingSudoku /home/dom/Projects/BacktrackingSudoku /home/dom/Projects/BacktrackingSudoku/cmake-build-debug /home/dom/Projects/BacktrackingSudoku/cmake-build-debug /home/dom/Projects/BacktrackingSudoku/cmake-build-debug/CMakeFiles/BacktrackingSudoku.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/BacktrackingSudoku.dir/depend

