package pl.damianradowiecki;

import pl.damianradowiecki.model.From;
import pl.damianradowiecki.model.To;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ConnectionMock implements Connection {

    private final Map<String, Function<?,?>> stubs = new HashMap<>();

    public void stub(String methodName, Function<?,?> method){
        stubs.put(methodName, method);
    }

    @Override
    public void connect() {
        if(stubs.containsKey("connect")){
            stubs.get("connect").apply(null);
        }
    }

    @Override
    public boolean isConnected() {
        if(stubs.containsKey("isConnected")){
            return (boolean) stubs.get("isConnected").apply(null);
        }
        return false;
    }

    @Override
    public void disconnect() {
        if(stubs.containsKey("disconnect")){
            stubs.get("disconnect").apply(null);
        }
    }

    @Override
    public From getFrom() {
        if(stubs.containsKey("getFrom")){
            return (From) stubs.get("getFrom").apply(null);
        }
        return null;
    }

    @Override
    public To getTo() {
        if(stubs.containsKey("getTo")){
            return (To) stubs.get("getTo").apply(null);
        }
        return null;
    }
}
