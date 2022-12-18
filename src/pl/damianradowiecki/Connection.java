package pl.damianradowiecki;

import pl.damianradowiecki.model.From;
import pl.damianradowiecki.model.To;

public interface Connection{
    void connect();
    boolean isConnected();
    void disconnect();
    From getFrom();
    To getTo();
}
