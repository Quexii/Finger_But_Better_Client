package dev.shoroa.finger.fingerbutbetterclient.client.event;

public class Event {
    private boolean state;
    public void disable() {
        state = false;}
    public void enable() {
        state = true;}
    public void toggle() {
        state = !state;}
}
