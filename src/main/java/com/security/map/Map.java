package com.security.map;

import com.security.entity.Entity;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Map {
    private final int MAX_X;
    private final int MAX_Y;
    HashMap<Coordinates, Entity> cells = new HashMap<>();
    private int step = 0;

    public void nextStep(){
        step++;
    }

    public Map(int x, int y) {
        MAX_X = x;
        MAX_Y = y;
    }

    public void putEntity(Entity entity, Coordinates coordinates){
        entity.setCoordinates(coordinates);
        cells.put(coordinates, entity);
    }

    public void removeEntity(Coordinates coordinates){
        cells.remove(coordinates);
    }

    public boolean isCellEmpty(Coordinates coordinates){
        return !cells.containsKey(coordinates);
    }

    public Entity getEntity(Coordinates coordinates){
        return cells.get(coordinates);
    }

    public List<Entity> getEntitiesOfType(Class<? extends Entity> type) {
        return cells.values().stream()
                .filter(type::isInstance)
                .collect(Collectors.toList());
    }

    public boolean isWithinBounds(Coordinates coord) {
        return coord.getX() >= 0 && coord.getX() < MAX_X &&
                coord.getY() >= 0 && coord.getY() < MAX_Y;
    }
}
