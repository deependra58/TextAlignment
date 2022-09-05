package cqu.textalignment;

import java.util.LinkedList;

public abstract class AlignmentStrategy {

    public AlignmentStrategy() {
    }

    abstract void align(LinkedList<String> line);
}
