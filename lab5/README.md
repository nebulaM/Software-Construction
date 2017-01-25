**CPEN 221: Lab 5**
Abstract Datatypes
====


### Principles of Software Construction

<table class="table">
    <tr><th width="33%">Safe from bugs</th>
        <th>Easy to understand</th>
        <th>Ready for change</th>
    </tr>

    <tr><td>Correct today and correct in the unknown future.</td>
        <td>Communicating clearly with future programmers, including future you.</td>
        <td>Designed to accommodate change without rewriting.</td>
    </tr>
</table>

## Lab Objectives

The goal of this lab activity is to reinforce the concept of abstract datatypes.

**Abstract datatypes are defined by their operations.**

In particular, they are *not* defined by the implementation of those operations.

**Abstract datatypes should prevent representation exposure.**

Instead of allowing other systems to depend on their internal representation, abstract datatypes should enforce representation independence.

## Designing an Abstract Datatype

Let us design an abstract datatype to represent line drawings.

Some examples of the sort of art we'd like to represent:

![Line Art](https://dl.dropboxusercontent.com/u/567187/EECE%20210/Images/Lab6-ADTs/LineArt.jpg?dl=1”)

What are some operations we'd like to have in our datatype? Discuss.

### Implementing the LineArt ADT

Suppose we plan to draw our line art with a pen, and one can use a pen to draw a straight line between two points, or use two additional methods, `pendown()` and `penup()`, that cause the pen to start and stop drawing on subsequent movement. We can call the pen operations `PenCmd`s.

Consider three different representations for this datatype:

+ Rep 1: `LineArt` has a `List` of `Segment`s. A `Segment` has `x1`, `y1` and `x2`, `y2`
+ Rep 2: `LineArt` has a `List` of `PenCmd`s. A `PenCmd` is either `GoToPoint`, `Penup`, or `Pendown`. `GoToPoint` has `x`, `y`.
+ Rep 3: `LineArt` has a `List` of `Component`s. A `Component` has a `List` of `Point`s. A `Point` has `x`, `y`.

Notice that in the course of defining one ADT, we went right ahead and defined a few more!

+ Draw instance diagrams for the different representations using some concrete `LineArt` objects.
+ **Q1: What are the relative merits of these different representations? Why might we choose one over another?**

## Let's look at Git!

This code for this example can be found [here](https://dl.dropboxusercontent.com/u/567187/EECE%20210/git-code.html).

### The Git Object Model (Simplified)
- **Blobs** = Files
- **Trees** = Directories
- **Commits** = Snapshots of repository's state (a repository is just a directory!)
- **Trees** contain **Blobs** and **Trees**
- **Commits** contain one **Tree**

### Git Object Diagram
<img src="http://git-scm.com/figures/18333fig0903-tn.png"></img>

More information can be found **[here](http://git-scm.com/book/en/Git-Internals-Git-Objects)**.

+ **Q2: What are the abstract data types of `git`? What operations does `git` expose for these data types?**
+ **Q3: Discuss which methods are Creators, Producers, Observers, and Mutators. Find places where the representation is exposed.**

## Submission

Answer questions **Q1-Q3** in a file called `lab5.txt` and push it to the repository created for this purpose. Also include a `partners.txt` file to indicate your name and Github id as well as the same information for your lab activity partner.
