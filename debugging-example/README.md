# Let's do some debugging

A debugging exercise with MergeSort. The purpose of this exercise is to **find bugs by writing good test cases.** Once you find a bug, you read the implementation code to identify a solution.

## How to Use `git bisect`

`git bisect` allows us to do a variety of things with our commits. As an example, we can identify the commit where a particular bug manifested itself for the first time.

In the case of this repository, what you can do is as follows:

```git
# it may  be good to start with a fresh copy of the repository
git clone https://github.com/CPEN-221/f16-debugging-example

# you should have the new test cases and script to run the test cases

# indicate that you are starting the bisection process
git bisect start

# indicate that things are bad now (bug exists)
git bisect bad HEAD

# indicate when things were good
# I am using the commit id for the very first commit
# this can be obtained using  "git log"
git bisect good 2234c1b7cd0ea21c6be372af7f46775b7992c71c

# now we run the tests at different points to identify the source of the problem
# assuming that you have a bash shell to run the scripts
# easy on Linux, macOS; possibly works with git bash
git bisect run ./runTest.sh

# once you know the commit that was problematic you can see what is different
# you provide the commit ids for the commits to compare
git diff <commit-id-1> <commit-id-2>

# to get back to current state after the git bisect
git bisect reset

```
