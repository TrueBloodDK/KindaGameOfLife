package com.security.map;

import com.security.entity.Direction;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Coordinates {
    private int x;
    private int y;
    
    public Coordinates shift(Direction direction) {
        return switch (direction) {
            case UP -> new Coordinates(x, y - 1);
            case DOWN -> new Coordinates(x, y + 1);
            case LEFT -> new Coordinates(x - 1, y);
            case RIGHT -> new Coordinates(x + 1, y);
        };
    }
}
