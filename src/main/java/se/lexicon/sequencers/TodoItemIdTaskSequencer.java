package se.lexicon.sequencers;

public class TodoItemIdTaskSequencer {

    private static int currentId;
    public static int nextId(){
        currentId++;
        return currentId;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        TodoItemIdTaskSequencer.currentId = currentId;
    }
}
