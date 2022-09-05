package cqu.textalignment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Paragraph {

    private int lineLength = 20;
    private String text = " ";
    private String space = " ";
    private String visibleSpace = "^";
    private AlignmentStrategy strategy;

    public Paragraph(AlignmentStrategy strategy) {
        this.strategy = strategy;
    }

    public String alignText() {
        //convert the text to list of lines. Each line is a linked list of words and spacing.
        List<LinkedList<String>> lines = textToLines();
        System.out.println(lines);
        //align each line according to the alignment strategy
        for (LinkedList<String> line : lines)
            strategy.align(line);
        //convert the list of lines back to a string to be returned (so that it can be displayed)
        return linesToText(lines);
    }

    public void alignAndAugmentText() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String linesToText(List<LinkedList<String>> lines) {
        StringBuilder sb = new StringBuilder();
        for (LinkedList<String> line : lines) {
            for (String s : line)
                sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }

    public List<LinkedList<String>> textToLines() {
        //Text is the original text-this splits it into words
        String[] words = text.split("\\s+");
        //Lines will be a list of linked lists
        List<LinkedList<String>> lines = new ArrayList<>();
        //Count to track the number of characters in the linked list of words and spaces so far
        int n = 0;
        //Recognise if it is the first word on a line
        boolean firstWord = true;
        //Creates the first linked list
        LinkedList<String> line = new LinkedList<>();

        //Iterate through the array of words building the lines
        for (String w : words) {

            if (firstWord) {
                // check length compared to lineLength without counting a preceding space
                if (n + w.length() >= lineLength) {
                    line.addFirst(w);
                    lines.add(line);
                    line = new LinkedList<>();
                    n = 0;
                } else {
                    line.addFirst(w);
                    n = w.length();
                    firstWord = false;
                }
            } else {// not the first word, so check if there is room for the word and the preceding space
                if (n + space.length() + w.length() > lineLength) { // no room for this word on current line
                    if (n < lineLength)
                        line.addLast(space.repeat(lineLength - n));
                    // add the completed line to the list of lines
                    lines.add(line);
                    //make a new linked list for the next line
                    line = new LinkedList<>();
                    //add w to the start of this next line
                    line.addFirst(w);
                    //set n to the length of w
                    n = w.length();
                } else if (n + space.length() + w.length() == lineLength) {
                    // it fits exactly – so the next word must be first on a new line
                    line.add(space); // add preceding space to the linked list (i.e. to the line we are building)
                    //add the word w to the line
                    line.add(w);
                    //add the line to the list of lines
                    lines.add(line);
                    // create a new linked list for the next line
                    line = new LinkedList<>();
                    //set firstWord to true
                    firstWord = true;
                    n = 0;
                } else { // add the current word to the line (and still space in the line to try to add next word)
                    line.add(space);
                    line.add(w);
                    n = w.length() + space.length();
                }
            }
        }
        // complete the last line when we leave the loop and add it to the lines array
        line.addLast(space.repeat(lineLength - n));
        lines.add(line);
        return lines;
    }
}
