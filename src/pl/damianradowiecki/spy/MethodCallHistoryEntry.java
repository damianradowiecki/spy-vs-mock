package pl.damianradowiecki.spy;

public class MethodCallHistoryEntry {
    private final String name;
    private final Object[] arguments;

    public static MethodCallHistoryEntry create(String name, Object... arguments){
        return new MethodCallHistoryEntry(name, arguments);

    }

    private MethodCallHistoryEntry(String name, Object... arguments) {
        this.name = name;
        this.arguments = arguments;
    }

    public String getName() {
        return name;
    }

    public Object[] getArguments() {
        return arguments;
    }
}
