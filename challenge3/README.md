# Challenge Task #3
January 5, 2017  

# Monitoring Roads Through Cameras
Consider a city with *n* crossroads. The city has a simple structure:
If you drive through the city starting at any crossroad, you will eventually
end up at a dead-end. All the roads in our city are two-way, but, starting at any crossroad, the only way to get back to the start crossroad is by driving through the same roads you took but in the reverse direction.

The municipality has decided to install surveillance cameras at crossroads. Each crossroad may have at most
one camera. A camera at a crossroad is guaranteed to return a stream of all
the roads intersecting at the crossroad. In order to minimize the overall
cost, they delegate to you the task of finding the *minimum number of cameras* that need to be installed such that all roads in the city are visible.

You program takes as input a bit-matrix, C, of size *n* * *n* such that C[i,j] = 1 if there is a direct road between crossroads i and j, and C[i,j] = 0 otherwise. You may assume that matrix C respects the simple city structure described above.

Your program should run in time that is **linear** in the number of crossroads, *n*. Write representative test cases for cities with a number of crossroads on the order of 1,000,000 and above, and number of roads that ranges from 0 up to the number of crossroads.
