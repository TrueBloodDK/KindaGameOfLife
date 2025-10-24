package com.security;

import com.security.entity.Entity;

import java.util.HashMap;

public class Map {
    HashMap<Coordinates, Entity> cells = new HashMap<>();

    public void putEntity(Entity entity, Coordinates coordinates){
        cells.put(coordinates, entity);
    }
}
