package com.security.map;

import com.security.entity.Entity;
import lombok.Getter;

import java.util.HashMap;

@Getter
public class Map {
    private final int MAX_X;
    private final int MAX_Y;
    HashMap<Coordinates, Entity> cells = new HashMap<>();

    public Map(int x, int y) {
        MAX_X = x;
        MAX_Y = y;
    }

    public void putEntity(Entity entity, Coordinates coordinates){
        cells.put(coordinates, entity);
    }

    public boolean cellIsEmpty(Coordinates coordinates){
        return !cells.containsKey(coordinates);
    }
}
