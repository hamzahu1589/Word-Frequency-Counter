# Word Frequency Counter

This project is a Java application that allows users to select a text file and calculates the frequency of each word in the file. It then outputs the word frequencies to the console in alphabetical order.

## Features

- Allows users to select a file using a graphical file chooser.
- Reads and tokenizes words from the selected file.
- Counts the frequency of each word.
- Outputs the word frequencies in alphabetical order.

## Requirements

- Java Development Kit (JDK) 8 or higher

## Setup

1. **Compile the Project**

   Ensure you have JDK installed. Compile the Java file using the `javac` command:

   ```bash
   javac Project4.java
Run the Program

After compiling, run the program using the java command:

bash
Copy code
java Project4
A file chooser dialog will appear, allowing you to select a text file. The program will then process the file and display word frequencies in the console.

Code Overview
Main Method

The main method initiates the file chooser dialog and processes the selected file. It uses the methods inputFromFile, countWordFrequencies, and printWordFrequencies to perform its tasks.

inputFromFile Method

Reads words from the selected file and returns them as an array. Words are tokenized using various delimiters, and the array dynamically resizes if needed.

countWordFrequencies Method

Counts the frequency of each word in the array and stores the results in a TreeMap, which maintains the words in alphabetical order.

printWordFrequencies Method

Outputs the word frequencies to the console in the format word - frequency.

Example
Run the Program

After running the program, select a text file when prompted.

Output

The console will display the word frequencies in alphabetical order. For example:

plaintext
Copy code
apple - 5
banana - 3
orange - 2
