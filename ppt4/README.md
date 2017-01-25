CPEN 221 / Fall 2016
Programming Proficiency Test
=========

December 23, 2016

## General Instructions

+ There are two questions that you need to complete.
+ You have 128 minutes (2h 8m) to complete the tasks.
+ You will start at 2:05 p.m. and finish by 4:13 p.m.
+ We will start cloning repositories at **4:15 p.m.** so you should have committed all your work to Github by that time (see submission instructions below).
+ Take your time to read the questions.
+ Skeleton code can be obtained by cloning this repository. Add JUnit to your build path in Eclipse.
+ Best of luck!

## Submission Instructions

+ Submit your work to the Github classroom repository that was created for your.
+ **Do not alter the directory/folder structure. You should retain the structure as in this repository.**
+ Do not wait until the last minute to push your work to Github. It is a good idea to push your work at intermediate points as well. _I would recommend that you get your Git and Github workflow set up at the start._

## Honour Code

By submitting your work to Github you agree to the following:

+ You did not consult with any other person in completing the examination.
+ You did not aid any other person in the class in completing their examination.
+ If you consulted any external sources, such as resources available on the World Wide Web, in completing the examination then you have cited the source. (You do not need to cite class notes or Sun/Oracle Java documentation.)
+ You are not aware of any infractions of the honour code for this examination.

> Violations of this honour code will be treated as a case of academic misconduct and will dealt with under UBC policies governing such issues. A consequence of this may be to nullify this exam for everyone that submits work for grading!

## Question 1: Periodic Strings
> The skeleton source code for this question is in the package `periodicStrings`. You have to implement the required methods in the class `PeriodicStrings`.

[Louise Banks has realized that the heptapods](https://en.wikipedia.org/wiki/Arrival_(film)) like strings that are *periodic*. A string of length `l` has a period `p` if the `i`-th character is the same as the `i+p`-th character for all `i` in the range `[0, l-p-1]`.

Some examples of periodic strings are:

+ `CATCATC` with a period of 3;
+ `CATCAT` with a period of 3;
+ `ACT` with a period of 3;
+ `TATA` with a period of 2;
+ `CATTCA` with a period of 4.

The heptapods communicate information by providing strings that may or may not be periodic. There is some information to be obtained by determining the minimum number of changes needed to make a string periodic (given a maximum period).

Help Louise by implementing a method to determine the smallest number of changes needed to make a given string periodic. Implement the method `minChanges` in the class `PeriodicStrings`. This method takes the string `hiddenMsg` and an `int` `maxPeriod` as arguments.

For simplicity, we will consider only strings that contain the letters A, C, T and G. (There is something genetic that is involved.)

### Test Cases

+ `hiddenMsg = "ATAGATA"` and `maxPeriod = 3` should return `1`. (We need to replace `G` with a `T` to obtain `ATATATA` which has a period of 2.)
+ `hiddenMsg = "ACGTGCA"` and `maxPeriod = 2` should return 3. (`ACACACA` has a period of 2 and needs three replacements.)
+ `hiddenMsg = "ACGCTGACAGATT"` and `maxPeriod = 13` should return 0. (A string of length 13 is already periodic with period 13 so no changes are needed.)
+ `hiddenMsg = "AAAATTTCCG"` and `maxPeriod = 1` should return 6. (All the non-`A` letters will become `A`s.)
+ `hiddenMsg = "ACGTATAGCATGACAACAGATATTATGACAGATGTAGCAGTAACCAGAC"` and `maxPeriod = 12` should return `20`.


## Question 2: Drone Landing

> The skeleton source code for this question is in the package `drones`. You have to implement the method `timeToLand` in the `DroneLandings` class.

Amazon is experimenting with a landing algorithm for drones. If a drone is at position **(x, y)**, where **y** is the height from the surface of the earth and **x** is the position along the left-right axis from a viewer's perspective, it starts descending at the rate of one unit per second until **y=0**.

In this (not-so) futuristic world, the drones may encounter floating platforms that act as landing obstacles. A floating platform is described by three parameters: **y1, x1, x2**. **y1** is its height from the surface of the earth and **x1** and **x2** represent its width. A drone descending from (x, y) will encounter the platform at (y1, x1, x2) if y1 <= y and x1 <= x <= x2 (assuming x2 >= x1).

When the drone encounters a platform, it will travel right (towards the higher x endpoint of the platform) and go past the platform by a small amount, delta (0 < delta < 1), before descending again. The drone will travel right at the speed of one unit per second.

Given the initial position of the drone and the position of many floating platforms, the goal is to determine how long it will take the drone to land.

The parameters of the floating platforms are provided as an array of strings. Each string consists of exactly three integer values that represent y, x1 and x2 for a platform (and in that order although x2 is not always greater than x1). The other arguments to the method to implement are the starting coordinates of the drone.

Note that that delta is not a necessary parameter because all inputs are integer values. We can treat it as being close to 0 and we can also treat the drone as a point-sized object for simplicity.

### Examples

+ Given the platforms as `{"5 10 20"}` and the starting position of the drone as (15, 10), the drone will land after 15 seconds. It will descend first for 5 seconds, encounter the obstacle and travel right for 5 seconds, and then descend again for 5 seconds.
+ Given the platforms as `{"10 10 20","15 10 20","5 20 50"}` and the starting position as (15, 12), the drone will land in 47 seconds. The drone hits the platform at y = 10 and moves to (20,10). From there it continues to descend until it hits the platform at y = 5. Finally, it descends to the x-axis at (50,0).
+ A drone starting at (50, 85) and with platforms `{"20 1 100","10 100 100", "5 100 200"}` will land in 235 seconds after encountering all the platforms.
+ A drone at (10, 1000) and with an empty set of platforms `{}` will land in 1000 seconds.
+ A drone initially at (400, 800) and with platforms as `{"800 1 500","400 1 499","401 501 999"}` will land in 900 seconds.

**For this task, there are no unit tests provided. You can use the examples above and write tests for preliminary testing.**

## What Should You Implement / Guidelines

+ You should implement all the methods that are indicated with `TODO`.
+ Passing the provided tests is the minimum requirement. Use the tests to identify cases that need to be handled. Passing the provided tests is *not sufficient* to infer that your implementation is complete and that you will get full credit. Additional tests will be used to evaluate your work. The provided tests are to guide you.
+ You can implement additional helper methods if you need to but you should keep these methods `private` to the appropriate classes.
+ You do not need to implement new classes.
+ You can use additional standard Java libraries by importing them.
+ Do not throw new exceptions unless the specification for the method permits exceptions.

## Answers to FAQs

#### Can I consult Java documentation and other Internet-based sources?

Yes, you can. The point of this test is not to demonstrate mastery over syntax but that you can solve a problem in a reasonable amount of time with reasonable resources.

*If you find useful information online outside the official Java documentation and the course material, you must cite the source. You should do so by adding comments in your source code.*

Naturally you are expected to adhere to all of the course and UBC policies on academic integrity.

#### Isn't two hours too short to produce working implementations?

The questions are straightforward, and these are not very different from what one might sometimes encounter on a job interview (for example). The difference is that you get less time during an interview (10-15 minutes) with no access to additional resources. So the time alloted is reasonable in that regard and I am expecting that most of you will be clear this bar. And you will have to keep working until you clear this bar. The goal is that it is possible to say, at a minimal level, what everyone who completes this course can achieve.

#### Why am I not guaranteed full credit if my implementation passes all the provided tests?

It is easy to develop an implementation that passes the provided tests and not much else. A good-faith implementation that passes all the provided tests is very likely to pass other tests too.
