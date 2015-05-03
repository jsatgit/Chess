package com.chess.app;
import java.util.List;
import java.util.ArrayList;

public class Moves {
    private List<Location> forCapuring;
    private List<Location> forPassing;

    public Moves() {
        this.forCapuring = new ArrayList();
        this.forPassing = new ArrayList();
    }

    public void clear() {
        forCapuring.clear(); 
        forPassing.clear(); 
    }

    public void addCapturing(Location location) {
        forCapuring.add(location); 
    }

    public void addPassing(Location location) {
        forPassing.add(location); 
    }

    public List<Location> getCapturing() {
        return forCapuring;
    }

    public List<Location> getPassing() {
        return forPassing;
    }
}
