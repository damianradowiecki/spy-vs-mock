package pl.damianradowiecki;

import pl.damianradowiecki.model.From;
import pl.damianradowiecki.model.To;
import pl.damianradowiecki.spy.MethodCallHistoryEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ConnectionSpy implements Connection {

    private final Connection delegate;
    private final List<MethodCallHistoryEntry> history;
    private final Map<String, Function<?,?>> stubs = new HashMap<>();


    public ConnectionSpy(Connection delegate) {
        this.delegate = delegate;
        this.history = new ArrayList<>();
    }

    public void stub(String methodName, Function<?,?> method){
        stubs.put(methodName, method);
    }

    public long checkHowManyTimesHaveBeenCalled(String methodName){
        return history.stream()
                .filter(methodCallHistoryEntry -> methodCallHistoryEntry.getName().equals(methodName))
                .count();
    }

    @Override
    public void connect() {
        history.add(MethodCallHistoryEntry.create("connect"));
        if(stubs.containsKey("connect")){
            stubs.get("connect").apply(null);
            return;
        }
        delegate.connect();
    }

    @Override
    public boolean isConnected() {
        history.add(MethodCallHistoryEntry.create("isConnected"));
        if(stubs.containsKey("isConnected")){
            return (boolean) stubs.get("isConnected").apply(null);
        }
        return delegate.isConnected();
    }

    @Override
    public void disconnect() {
        history.add(MethodCallHistoryEntry.create("disconnect"));
        if(stubs.containsKey("disconnect")){
            stubs.get("disconnect").apply(null);
            return;
        }
        delegate.disconnect();
    }

    @Override
    public From getFrom() {
        history.add(MethodCallHistoryEntry.create("getFrom"));
        if(stubs.containsKey("getFrom")){
            return (From) stubs.get("getFrom").apply(null);
        }
        return delegate.getFrom();
    }

    @Override
    public To getTo() {
        history.add(MethodCallHistoryEntry.create("getTo"));
        if(stubs.containsKey("getTo")){
            return (To) stubs.get("getTo").apply(null);
        }
        return delegate.getTo();
    }
}
