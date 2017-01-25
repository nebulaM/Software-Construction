CPEN 221 / Fall 2016
Programming Proficiency Test
=========

January 5, 2016

## General Instructions

+ There are two questions that you need to complete.
+ You have 128 minutes (2h 8m) to complete the tasks.
+ You will start at 6:30 p.m. and finish by 8:38 p.m.
+ We will start cloning repositories at **8:40 p.m.** so you should have committed all your work to Github by that time (see submission instructions below).
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

## Question 1: Floor Time
> The skeleton source code for this question is in the package `inventoryManagement`. You have to implement the required method in the class `FloorTime`.

Perishable food items arrive at a warehouse every _a_ time units. The food items are removed from the warehouse floor and transported (assume instantaneously) to a refrigerator every _b_ time units.

You can assume all food arrivals start at time 0 and that the removal of food items from the warehouse also starts at time 0. If food is delivered at time _t_ and a removal is scheduled for time _t_ then the food arriving at _t_ is moved to the refrigerator right away.

Implement a method that determines the average time that food items spend on the warehouse floor (prior to refrigeration) given _a_ and _b_. Your method should compute the average time, which we can call average floor time, as the number of items approaches positive infinity (or over an infinite time horizon). You are effectively computing a limit and this limit always exists. Your method should compute the average floor time to within 10<sup>-8</sup> time units accuracy.

### Test Cases

+ _a_ = 2, _b_ = 4. The average floor time is 1.0.
+ _a_ = 3, _b_ = 5. The average floor time is 2.0.
+ _a_ = 1, _b_ = 6. The average floor time is 2.5.
+ _a_ = 2345, _b_ = 12345. The average floor time is 6170.0

## Question 2: Power-of-4 Game

> The skeleton source code for this question is in the package `exp4game`. You have to implement the method `getWinner` in the `Exp4Game` class.

Consider the two-player game with _n_ tokens. Player 1 starts by removing some number of tokens. Then it is Player 2's turn to remove tokens. Each player can remove a power-of-4 (1, 4, 16, 64, ...) tokens and the game ends when a player cannot remove such a number of tokens.

Given _n_, write a method to return `1` if Player 1 will win and `2` if Player 2 will win. You should assume that each player will play optimally.

### Examples

+ `n=1`. Player 1 will win because she can remove 1 token and Player 2 has no move.
+ `n=2`. Player 2 will win because Player 1 can remove only 1 token.
+ `n=3`. Player 1 will win.

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
