CPEN 221 Example 3: Vancouver Sun Run
========

Your friends, who are participating in the Sun Run, ask you to write a program to determine the average completion time. Team prizes are based on the average completion time for a team. You decide that it may be wise, thinking of extensibility, to record information about the runners as a separate data type. 

For each runner that completes the run, you can maintain a race record. A race record consists of:
* the runner's jersey/bib number;
* the runner's name;
* the runner's completion time (in minutes).

A race record is a data type. The values that a race record can take are triples <a, b, c> where **a** represents the jersey/bib number (it should be an integer >= 0), **b** is a String that represents the runner's name, and **c** is an integer (> 0) that represents the runner's race completion time in minutes.

The methods associated with each race record are the following:
* A method to create a race record given the constituent items (jersey/bib number, runner name, completion time). This method is also called a *constructor*.
* Methods to retrieve the jersey/bib number, runner name and completion time from a race record.
* Methods to update/correct runner name and completion time.

Multiple race records can be linked with a team, and can be manipulated using the provided methods. In this example, multiple race records are stored in an array and the average completion time for the team is computed.

In Java, a data type can be created using the keyword **class**. A **class** can contain individual data items as well as methods associated with the **class**. An instance of a **class** is called an **object**.

This example does not require you to write new code (but do modify and add features to get practice). Run it for a start and  understand the different aspects of the program.

This example illustrates a few essential Java features:
* The use of multiple Java files as part of the same project. The class `RaceRecord` is declared in `RaceRecord.java` and used in `SunRunMain.java`. If two Java files are in the same directory, as is the case in this example, we do not need to include special `import` statements. The Java compiler picks up these dependencies automatically.
* Each `.java` file will ideally have only one class definition. In some cases, a file may involve more than one class but those situations are less common and are not important at this point.
* There is only one class in a project that includes the `main( )` method. In this example, the `main( )` method is part of the `SunRunMain` class.
* The use of the keyword `final` to indicate constants. The `final` keyword is important for correctness of programs but here only the simplest use is illustrated.
* In this example, some elements of a class are also marked `private`. This is an important aspect in representing data types. A data type should be manipulated only with a valid set of well-defined operations and should not be subject to inconsistent manipulation. This discussion (http://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html) will become more relevant in the next week or so.
* The use of a `Scanner` to read input from the console (standard system input) and how to set delimiters for a scanner. Also see:  http://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html. Once you get an understanding of what a **class** is and what an **object** is, most of the code can be interpreted with some ease. In this example, we are creating a `Scanner` object and working with the object that we have created. We will not explicitly cover input/output operations. These will be covered through examples such as this one, and you should read a suitable Java textbook or the documentation at docs.oracle.com for such matters. (I/O is usually a morass of details but does not involve many significant concepts.)

In this example, we have not done explicit input validation or error checking. How would you incorporate such validation? (At least conceptually, if you are not sufficiently familiar with Java.)
