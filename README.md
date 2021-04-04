# Mobiuqity Assignment : Package Challenge

A packer implementation has been realised as a library project by using technologies below.

### Dependencies
* Java 11
* Maven 3.6.3
* Apache Commons 3.12
* Junit 5

## About the Packer

Packer library has a static API ```pack``` that takes ```filePath``` as absolute path of input file
and returns ```output``` as a string.
```
public static String pack(String filePath) throws APIException
```

### Solver Algorithm
The dynamic programming solution is based on the recursive 0-1 Knapsack problem is applied to solve packer challange.
```
https://en.wikipedia.org/wiki/Knapsack_problem#Dynamic_programming_in-advance_algorithm
```

Pseudocode for recursive solution
```javascript
// Input:
// Values (stored in array v)
// Weights (stored in array w)
// Number of distinct items (n)
// Knapsack capacity (W)
// NOTE: The array "v" and array "w" are assumed to store all relevant values starting at index 1.

Define value[n, W]

Initialize all value[i, j] = -1

Define m:=(i,j)         // Define function m so that it represents the maximum value we can get under the condition: use first i items, total weight limit is j
{
if i == 0 or j <= 0 then:
value[i, j] = 0
return

    if (value[i-1, j] == -1) then:     // m[i-1, j] has not been calculated, we have to call function m
        value[i-1, j] = m(i-1, j)

    if w[i] > j then:                      // item cannot fit in the bag
        value[i, j] = value[i-1, j]
    else: 
        if (value[i-1, j-w[i]] == -1) then:     // m[i-1,j-w[i]] has not been calculated, we have to call function m
            value[i-1, j-w[i]] = m(i-1, j-w[i])
        value[i, j] = max(value[i-1,j], value[i-1, j-w[i]] + v[i])
}

Run m(n, W)
```

### Input File Format

Each line contains the weight that the package can take (before the colon) and the list of items you need
to choose. Each item is enclosed in parentheses where the 1st number is a item’s index number, the 2nd
is its weight and the 3rd is its cost. E.g.

```
81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)
8 : (1,15.3,€34)
75 : (1,85.31,€29) (2,14.55,€74) (3,3.98,€16) (4,26.24,€55) (5,63.69,€52) (6,76.25,€75) (7,60.02,€74) (8,93.18,€35) (9,89.95,€78)
56 : (1,90.72,€13) (2,33.80,€40) (3,43.15,€10) (4,37.97,€16) (5,46.81,€36) (6,48.77,€79) (7,81.80,€45) (8,19.36,€79) (9,6.76,€64)
```

### Output Format

For each set of items that you put into a package provide a new row in the output string (items’ index
numbers are separated by comma). E.g.

```
4
-
2,7
8,9
```

### Exceptions
```APIException``` with a detail message and stacktrace will be thrown when an error occured while parsing, formatting, io operations, etc.

### Constraints
- The test file will be in UTF-8 format.
- Max weight that a package can take is ≤ 100
- There might be up to 15 items you need to choose from
- Max weight and cost of an item is ≤ 100



## How to Use

### Clone Source Code
``` 
https://github.com/sinangoker/mobiquity-packer.git
```

### Build the Project
Clean and build the project with the command below
``` 
mvn clean install
```

### Library Jar 

```mobiquity-packer-1.0.0.jar``` will be creted under target.

You can import the library to classpath and use.


#### Questions and Comments:
```
sinangoker12@gmail.com
github.com/sinangoker
```