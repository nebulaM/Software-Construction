CPEN 221 Example 1: Printing Strings
======

### Reading the source code for the program

Here is our first Java program. Let us discuss the source code (which is in `FirstProgram.java`) here:

```java
    public class FirstProgram {
        // Let us print two strings.
         public static void main(String[] args) {		
	        System.out.println( "Welcome to CPEN 221!” );
	        System.out.println( "Was that not easy?" );
        }
    }
```

First observe that all code in Java belongs to a class. Further, each class is typically described in its own file. Therefore the class `FirstProgram` is in the file `FirstProgram.java`. In this example, the program has only one class and this class contains the method `main( )`. Every Java program has one class (and no more than one class) that contains the `main( )` method. You may also notice that we use the term _method_ rather than the term _function_.

This program does something extremely simple: it displays two strings on the screen. To write to the standard output device (in this case, the monitor/screen for your computer), one would typically use the `System.out.println( )` method.

Java code tends to be somewhat verbose. If we were to use a different language, we might be able to achieve the same effect with fewer lines of code. In Python, for example, we would only need:

```python
print ("Welcome to CPEN 221!\n)"
print ("Was that not easy?\n)"
```

`public` and `static` are keywords in Java and we will discuss their meaning in detail later. The keyword `void` that precedes the declaration of the `main( )` method indicates that this method does not return any value.

The use of `//` indicates that the text that follows on that line is a comment. (Why do we use comments?)

### Running the program

First, you will have to install Java, Eclipse and Git if you do not have these tools installed already.

To obtain the source code for this example, open up a terminal (on macOS or a Unix-based system) or git-bash (on Windows) and change to the Eclipse workspace directory using the [`cd` command](https://en.wikipedia.org/wiki/Cd_(command)). 

Clone this repository using the command:

```
git clone https://github.com/CPEN-221/example1
```

To run `example1` on your own computer (assuming that you have the Eclipse IDE and Java 8 installed), perform these steps:

* Start `Eclipse`.
* Select the menu option to create a new Java project (look at the drop-down menus).
* In the `New Java Project` dialog window, select the directory where the files were stored (where you cloned the repository in the earlier step) as the project location. Once this is done, click on `Finish`.
* You should now be able to see the new project in the left pane of the Eclipse IDE. If you double-click on the project, you will be able to find the source file `FirstProgram.java`. 
* Double-click on the source file to open it in Eclipse. Eclipse should, by default, build (or compile) your project when you open it.
* From Eclipse's `Run` menu select `Run` and you should see the program output in the bottom of the Eclipse window in the Console pane.