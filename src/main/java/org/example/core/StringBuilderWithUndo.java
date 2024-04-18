package org.example.core;

import java.util.LinkedList;
import java.util.List;

public class StringBuilderWithUndo {

    private StringBuilder stringBuilder;
    private LinkedList<String> snapshots;

    public StringBuilderWithUndo(StringBuilder stringBuilder, List<String> snapshots) {
        this.stringBuilder = new StringBuilder();
        this.snapshots = new LinkedList<>();
    }
    public StringBuilderWithUndo append(String str){
        snapshots.add(str);
        stringBuilder.append(str);
        return this;
    }
    public StringBuilderWithUndo undo(){
        if (!snapshots.isEmpty()){
            stringBuilder = new StringBuilder(snapshots.removeLast());
        }
        return this;
    }

    public String toString(){
        return stringBuilder.toString();
    }
}