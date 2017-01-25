CPEN 221 / Fall 2016
Programming Proficiency Test
=========

Ocober 12, 2016

## General Instructions

+ There are two questions that you need to complete.
+ You have 128 minutes (2h 8m) to complete the tasks.
+ You will start at 5:12 p.m. and finish by 7:20 p.m.
+ We will start cloning repositories at **7:25 p.m.** so you should have committed all your work to Github by that time (see submission instructions below).
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

## Question 1: Addition Closure

> The skeleton source code for this question is in the package `additionClosure`. You have to implement the methods _isClosed_.

You are given a `List` of `Integer`s, `listInt`, and another integer `n`. We will define *closure under addition* for `listInt` to mean that for two distinct values of `i` and `j`, `(listInt[i]+listInt[j]) % n` is in `listInt` or `k * n + (listInt[i]+listInt[j]) % n` (for some int `k`) is in `listInt`.

Your goal is to determine if a given `List` of `Integer`s is closed under addition for some modulus `n`. You will implement a method, _isClosed_, that will return `true` if a `List` is closed under addition for a given `n` and `false` otherwise.

### Examples

+ input list: [-1, 0, 1]; `n` = 2
	+ Returns: `true`
	+ `(-1 + 0) % 2 = -1; (-1 + 1) % 2 = 0, (0 + 1) % 2 = 1`.

+ input list: [-2, 3]; `n` = 4
	+ Returns: `false`

+ input list: [1, 1, 0]; `n` = 2
	+ Returns: `true`

+ input list: [1, 1]; `n` = 3
	+ Returns: `false`

+ input list: [1, 1, 2]; `n` = 2
	+ Returns: `true`

+ input list: [0, 1, 1, 2]; `n` = 2
	+ Returns: `true`

+ input list: [0, 1, 100, 50, 50], `n` = 100
	+ Return: `false`

+ input list: [0, 1, 100, 50, 50], `n` = 50
	+ Return: `true`

## The `AABBB` Language

> The skeleton source code for this question is in the package `aabbbstrings`. You have to implement the methods _countStrings_ and _getWords_ in the class _AABBBString_.

In language `AABBB`, all words consist of `aa`s or `bbb`s or some combination of these two patterns.

Implement two methods:

1. One that will compute the number of words of length `n` in this language. By default, there are no words of 0-length and this language has no words of length 1. You may assume that `n >= 0`.

2. One that will return all valid words of a given length `n`. You may assume `n >= 0` but you should throw a `TooManyWordsException` for `n > 30`. Consider using `StringBuilder`s.

### Examples

+ `n` = 0
	+ Returns: 0
	+ By definition.
+ `n` = 1
	+ Returns: 0 for number of words
+ `n` = 2
	+ Returns: 1 for number of words
	+ The only possible word is `aa`.
+ `n` = 3
	+ Returns: 1 for number of words
	+ The only possible word is `bbb`.
+ `n` = 4
	+ Returns: 1 for number of words
	+ The only possible word is `aaaa`.
+ `n` = 5
	+ Returns: 2 for number of words
	+ The possible words are `aabbb` and `bbbaa`.
+ `n` = 12
	+ Returns 12 for number of words
+ `n` = 45
	+ Returns 128801 for number of words

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
