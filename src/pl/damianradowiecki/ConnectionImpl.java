package pl.damianradowiecki;

import pl.damianradowiecki.model.From;
import pl.damianradowiecki.model.To;

public class ConnectionImpl implements Connection {

    private boolean connected = false;
    private From from;
    private To to;

    public ConnectionImpl(From from, To to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void connect() {
        this.connected = true;
    }

    @Override
    public boolean isConnected() {
        return this.connected;
    }

    @Override
    public void disconnect() {
        this.connected = false;
    }

    @Override
    public From getFrom() {
        return from;
    }

    @Override
    public To getTo() {
        return to;
    }
}
