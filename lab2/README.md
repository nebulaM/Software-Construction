CPEN 221 Lab 2: Debugging (Some Poetry)
====

### Debugging 

The purpose of this lab activity is **debugging**. You will gain additional experience reading provided code, understanding it, reviewing it, and debugging some problems associated with it.

### Reading Code

For this lab exercise, you need to focus on only two Java files: `Main.java` and `UBCPoet.java`.

> Look at poems for “song”.

There are a variety of ways to determine the quality of source code and to identify “code smells.” Some of these are:

* Don’t repeat yourself.
* Use comments where needed.
* Fail fast.
* Avoid magic numbers.
* One purpose for each variable.
* Use good names.
* Don’t use global variables.
* Use coherent methods.
* Methods should return results, not print them.
* Use whitespace to help in reading.

First, with a partner, read for understanding.
* Take two minutes to read through the code and see what you can figure out.
* Focus on the methods `verse` and `eloquent` – try to maximize your understanding of them while minimizing time spent figuring out other parts of the code.
* This is a good opportunity to familiarize yourself with [ArrayList](http://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html). Also see [this example](http://examples.javacodegeeks.com/core-java/util/arraylist/arraylist-in-java-example-how-to-use-arraylist/).

Then, with your partner, write down a couple things that are:

* Good about how this code is organized, its style, what’s included or missing, …
* Bad about how this code is organized, its style, what’s included or missing, …
* Confusing about this code or individual lines of code.

### First-line Bug
Our poems all have a strange common feature on their first line: [something] metric linear unit. How can we debug the problem?

#### Trace backward
* Click on the return type of a method to see all the places that method might return.
* Click on a variable to highlight all references to that variable
use `F3` to jump to the implementation of a method.
* Hover over a method to see `Javadoc` documentation

#### System.out.println
* One of the most basic and most useful debugging tools. 
* Add unambiguous tags to your output to avoid confusion.

#### Debugger
* Add a breakpoint, then step over and into method calls.
* Inspect values of the variables that are in scope.

We don’t have to understand everything about the code we’re debugging. At the same time, we need to recognize all of our assumptions, and be ready for them to turn out wrong.

> **The most powerful debugging tool at your disposal is clear, logical thinking.**

> You will encounter bugs that require you to understand technical intricacies. But most of good software engineering is about careful, creative, logical thinking: in design, in code, in testing, and in debugging.

When reading code, hope the author has tried their best to communicate with you, not just the machine.
* Grow your understanding of the code in stages: don’t try to understand an entire program at once.
* Over time, develop an intuition about kinds of bugs, how they manifest, and where to hunt them down.

When writing code, try your best to communicate with the reader (maybe future you), not just the machine.

#### What next?
With our understanding of the code so far, is this bug reproducible? If an input noun always produces the same 0th word ID → synset → gloss, the bug is reproducible.

> With your partner, brainstorm a couple different ways you might try to fix this bug.

### Out-of-Bounds Bug

> Look at poems for “gun”, “meter”, and “plank”.

Sometimes, but not always, one of these words will generate an exception. How can we debug the problem?

#### Stack trace
* Click on a `FileName.java:line` link to jump to the source.

#### Debugger
* Run the program under the debugger, let it catch the exception.

#### Don’t ignore, don’t fix, reproduce
* Don’t ignore the bug and hope it doesn’t come back.
* Don’t jump to fix the bug without understanding.

This bug is not always reproducible. We don’t want to guess whether we have a reproducible test case, we want to be sure.

> Discuss how to reproduce the bug and fix it.

### Illegal Argument Bug
> Look at a poem called “babel”.

Is this exception our bug, or a bug in the library throwing the exception?

We can use `println` or the debugger to discover that we call `sense( )` with the empty string. That’s our bug.

If you already know regular expressions, fix the bug. If not — you’ll see them at some point!

### Any program, no matter how small, can have bugs
But if we know we’re going to find another bug every n lines, it would be much better to write a 0.5n–line program than a 50n–line program!

### What should you submit?
Add a few sentences to the file named `lab2.txt` for each of:
* code style and smells;
* the first-line bug;
* the out-of-bounds bug;
* the illegal argument bug.

### Submitting Your Work

Submit your work by committing and pushing the changes to the GitHub repository created for you for this lab. You can work with a partner. **It is sufficient if only one of your pushes your work to GitHub but `lab2.txt` must contain your name and your partner's name.**
