import javax.swing.JFileChooser;

import java.util.StringTokenizer;

import java.util.TreeMap;

public class Project4 {
    public static void main(String[] args) {
    // Create a new file chooser object to allow the user to select a file
    JFileChooser fileChooser = new JFileChooser();

    // Display the file chooser dialog and check if a file has been selected
    if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        // Retrieve the path of the selected file
        String filename = fileChooser.getSelectedFile().getPath();

        // Use the inputFromFile method to read words from the selected file and store them in an array
        String[] words = inputFromFile(filename);

        // Count the frequency of each word in the array and store the results in a TreeMap
        TreeMap<String, Integer> wordCounts = countWordFrequencies(words);

        // Output the word frequencies to the console in alphabetical order
        printWordFrequencies(wordCounts);
    } else {
        // Inform the user that no file was selected if they cancel the file selection
        System.out.println("No file was picked.");
    }
}

    public static String[] inputFromFile(String filename) {
        TextFileInput input = new TextFileInput(filename);
        String[] newList = new String[100]; // Adjust size as needed or use dynamic data structure
        int i = 0;
        String line = input.readLine();

      
 
        while (line != null) {
            
            StringTokenizer myTokens = new StringTokenizer(line, " ,.;!?()-\"\'\n\r\t[]{}<>"); // Tokenize with broader delimiters
            while (myTokens.hasMoreTokens()) {
                String word = myTokens.nextToken().toLowerCase(); // Normalize to lowercase
                if (i >= newList.length) {
                    // Resize array if more space is needed
                    String[] temp = new String[newList.length * 2];
                    System.arraycopy(newList, 0, temp, 0, newList.length);
                    newList = temp;
                }
                newList[i++] = word;
            }
            line = input.readLine();
        }
        input.close();
        // Adjust the final array size to match the actual number of words
        String[] finalList = new String[i];
        System.arraycopy(newList, 0, finalList, 0, i);
        return finalList;
    }

    public static TreeMap<String, Integer> countWordFrequencies(String[] words) {
        // Initialize a TreeMap to store words as keys and their frequencies as values
        TreeMap<String, Integer> wordCounts = new TreeMap<>();
        // Iterate over each word in the input array
        for (String word : words) {
            if (word != null && !word.isEmpty()) {
                 // Increment the word's count in the TreeMap
                // If the word is not already in the map, use 0 as the default value and then add 1
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }
        // Return the TreeMap containing all words and their frequencies
        return wordCounts;
    }

    public static void printWordFrequencies(TreeMap<String, Integer> wordCounts) {
        // Iterate over each word in the TreeMap's key set
        for (String word : wordCounts.keySet()) {
            System.out.println(word + " - " + wordCounts.get(word));
            // Print each word and its corresponding frequency to the console
        // The format is "word - frequency"
        }
    }
}