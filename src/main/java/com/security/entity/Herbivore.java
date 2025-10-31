package com.security.entity;

import com.security.map.Coordinates;
import com.security.map.Map;

public class Herbivore extends Animal{
    public Herbivore(int speed, int hp) {
        super(speed, hp);
    }

    @Override
    public void makeMove(Map map) {
        for (Direction direction : Direction.values()) {
            Coordinates nearbyPosition = getCoordinates().shift(direction);
            if (map.isWithinBounds(nearbyPosition)) {
                Entity entity = map.getEntity(nearbyPosition);
                if (entity instanceof Grass) {
                    map.putEntity(this, nearbyPosition);
                    setHp(getHp() + 10);
                    return;
                }
            }
        }

        Direction directionToGrass = findDirectionToTarget(map, Grass.class);
        moveInDirection(map, directionToGrass);
    }

    public void takeDamage(int damage){
        setHp(getHp() - damage);
    }

}
