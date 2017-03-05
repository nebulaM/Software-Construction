CPEN 221 / Fall 2015: Lab 6
Rep Invariants &amp; Interfaces
===

### Representation Invariants

> **Required Reading:** [**Rep Invariants and Abstraction Functions**](https://www.evernote.com/l/AANJ1uLGF1BGm4xXBm1SM75f7X75cuSNdYk)
</p>

The representation invariant (RI) specifies the subset of representation values that are mapped to abstract values.

We will continue with the two examples from [Lab 5](https://github.com/CPEN-221/lab5-fall2015): Line Art and the Git Object Model.

What are some potential representation invariants in our example representations? What happens if the representation invariant is not preserved?

Your choice of representation does not immediately imply your choice of RI.

**Q1.** What are the representation invariants for the three possible representations of `LineArt` that we saw earlier?

**Q2.** What are the representation invariants of git blobs, trees and commits?

### Interfaces

> **Required Reading:** [**Interfaces**](https://www.evernote.com/l/AAP4SkHFIR9NE5MhQDP3qiBHjv-hTxZbd4Q)

Task schedulers are common and they are found in many flavours. Schedulers differ in the manner in which they prioritize tasks. You have been given an `Scheduler` interface that will be used to schedule `Task`s. The tasks can be prioritized using different properties, and this leads to different scheduler implementations. 

Look at the source code in [`src/schedulers`](https://github.com/CPEN-221/lab6-fall2015/tree/master/src/schedulers).

You should implement three different schedulers as follows:

|Name|Policy Description|
|---:|---|
| **SRPT** | This scheduler prioritizes tasks that have the shortest remaining processing time. |
| **EDF** | This scheduler prioritizes tasks that have the earliest absolute deadlines. |
| **DM** | This scheduler prioritizes tasks on the basis of their _relative deadlines_: the shorter the relative deadline the higher the priority. |

These scheduling policies are often adopted by schedulers in operating systems or web servers depending on the needs of applications.

Your implementation should correspond to the provided interface: in Java terminology, you should create three classes that `implement` the `Scheduler` interface.

### Merging Conflicting Changes with Git

One important aspect of using a source code control system is to manage simultaneous updates to the code base and to merge the changes. To familiarize yourselves with this aspect of `git`, read [A Hacker’s Guide to Git](http://wildlyinaccurate.com/a-hackers-guide-to-git/).

To understand how one can resolve conflicts, follow these steps. This task is set up so that one person can complete all the steps (including creating the conflict) although conflicts are more common when multiple people are contributing to a project. This is not the only way to resolve a conflict but it is intended to be a start.

+ Clone your assigned Github repository:
`git clone lab6 https://github.com/CPEN-221/<your-repo> lab6a`
which will clone the repo in a local directory `lab6a`.
+ Change to the `lab6a` directory and create a new branch `b1` and switch to it:
`git branch b1` followed by `git checkout b1`
+ Add an empty file named `README.txt` in the `lab6a` directory and push to Github:
```git
git add README.txt
git commit -m "Added README"
git --set-upstream origin b1
git push
```
+ Now, from the parent directory for `lab6a`, clone branch `b1` of your repository using the command:
`git clone -b b1 https://github.com/CPEN-221/<your-repo> lab6b`
which will clone the repo in a local directory `lab6b`.
(This would allow the two cloned repositories to be on the same machine, if necessary.)
+ In the `lab6b` directory, add the following line to `README.txt`: `Hello from Lab6b`. Then commit and push the change to Github.
+ In the `lab6a` directory, add the following line to `README.txt`: `Hello from Lab6a.` Commit this change and execute a `pull`:
`git pull`
+ Git will indicate that there is a merge conflict.
+ Edit `README.txt` in `lab6a` to have the two lines in the correct order (`Lab6` before `Lab6b`). You will remove the conflict indicators placed by Git.
+ Add, commit and push `README.txt` from `lab6a`.

### Submitting your work

> By **6pm on Oct. 23**, you should:

> Answer the rep invariant questions and include the implementation (source code) of any one of the schedulers, and upload a PDF file with this information to Gradescope.

> You should work with a partner of your choice from the same lab section. You can submit your work as a group to Gradescope.
