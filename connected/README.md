# Connected
Suppose you are given a text file containing pairs of city names, one pair per line, with the names
on each line separated by a comma. The file might look something like (provided for illustration
purposes only):

- Philadelphia, Pittsburgh
- Boston, New York
- Hartford, New York
- Los Angeles, San Diego
- New York, Croton-Harmon
- St. Petersburg, Tampa

Each line of the file indicates that it is possible to travel between the two cities named. (More
formally, if we think of the cities as nodes in a graph, each line of the file specifies an edge
between two nodes.) In the example above it is possible to travel between Boston and New York,
and also between Hartford and New York, so it follows that Boston and Hartford are connected.
On the other hand, there is no path between Boston and Tampa, so they are not connected.
Write a java program, called <code>Connected</code> that reads in such a file and outputs whether two specified cities are connected. The program
will be invoked from the command line as:

```java
java Connected <filename> <cityname1> <cityname2>
```
and will output a single line stating ```yes or no```

Here are some sample interactions, assuming the example file above is named
cities.txt

````java
java Connected cities.txt Boston Hartford  
yes  
java Connected cities.txt Boston Tampa  
no  
java Connected cities.txt Boston Ypsilanti  
no
````

### Assumptions
- Commas will not appear within city names in the file. For example, &quot;Washington, D.C.&quot;
will not appear in the file as a city name.
- Your choice of algorithms and data structures should allow the program to handle
arbitrarily large files reasonably efficiently. You can, however, assume that the file will
fit in memory.
- The program is permitted to return any or no output when given a malformed input file or
malformed command line; however it should not crash or otherwise terminate
abnormally.
- The file is considered to be a list of all connections, not all cities; a city not in the file is
connected to no other city.
- Please let us know how to build it (e.g. supply a Makefile) so that we can build and test it
ourselves.
- Multiple source files should be tarred/zipped together.

Note:

- File sample above is provided for illustration purposes only, program
should be able to detect connection where number of edges in the
connectivity graph between cities is bigger than 2
- The code should be production quality

### How to run the program

Pre-requisites:
1. Apache Maven should be installed and the binary should be in PATH
2. Java should be installed and the binaries should be in PATH

Steps to run the program:
1. Extract the code files.
    cd C:\
    unzip Connected.zip
2. cd to the folder location
	cd C:\Connected
3. Build the project
	mvn clean compile
4. Run the program.  To run the program with -cp, make sure you have the classpath added in the PATH.
	```java java -cp C:\Connected\target\classes Connected filename cityName1 cityName2```
	eg: 
```java
java -cp C:\Connected\target\classes Connected "C:\\connected.txt" "Los Angeles" "Portland"
```