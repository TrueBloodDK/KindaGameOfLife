package com.security;

import com.security.entity.Entity;
import lombok.Getter;

import java.util.HashMap;

public class Map {
    @Getter
    private int MAX_X;
    @Getter
    private int MAX_Y;
    HashMap<Coordinates, Entity> cells = new HashMap<>();

    public void setMaxCoordinates(int x, int y){
        this.MAX_X = x;
        this.MAX_Y = y;
    }

    public void putEntity(Entity entity, Coordinates coordinates){
        cells.put(coordinates, entity);
    }
}
