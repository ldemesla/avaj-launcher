package com.flyers;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;
    protected Aircraft(String nme, Coordinates crdt)
    {
        this.name = nme;
        this.coordinates = crdt;
        this.id = nextId();
    }
    private long nextId()
    {
        return (++Aircraft.idCounter);
    }
}