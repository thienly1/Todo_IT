package se.lexicon.sequencers;

public class TodoItemIdSequencer {

    private static int currentId;
    public static int nextId(){
        currentId++;
        return currentId;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        TodoItemIdSequencer.currentId = currentId;
    }
}
