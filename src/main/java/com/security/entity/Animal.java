package com.security.entity;

import com.security.map.Coordinates;
import com.security.map.Map;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

abstract public class Animal extends Entity {
    @Getter
    private final int speed;
    @Getter @Setter
    private int hp;

    public Animal(int speed, int hp){
        this.speed = speed;
        this.hp = hp;
    }

    public abstract void makeMove(Map map);

    protected void moveInDirection(Map map, Direction direction) {
        Coordinates newPosition = getCoordinates().shift(direction);

        if (map.isWithinBounds(newPosition) && map.isCellEmpty(newPosition)) {
            map.removeEntity(getCoordinates());
            map.putEntity(this, newPosition);
        }
    }

    protected void tryRandomMove(Map map) {
        List<Direction> directions = Arrays.asList(Direction.values());
        Collections.shuffle(directions);

        for (Direction direction : directions) {
            Coordinates newPosition = getCoordinates().shift(direction);
            if (map.isWithinBounds(newPosition) && map.isCellEmpty(newPosition)) {
                map.removeEntity(getCoordinates());
                map.putEntity(this, newPosition);
                break;
            }
        }
    }

    protected Direction findDirectionToTarget(Map map, Class<? extends Entity> targetType) {
        Coordinates currentPos = getCoordinates();

        List<Entity> targets = map.getEntitiesOfType(targetType);
        if (targets.isEmpty()) {
            return getRandomDirection();
        }

        Entity closestTarget = findClosestEntity(currentPos, targets);
        return calculateDirection(currentPos, closestTarget.getCoordinates());
    }

    protected Entity findClosestEntity(Coordinates from, List<Entity> entities) {
        Entity closest = entities.get(0);
        double minDistance = Double.MAX_VALUE;

        for (Entity entity : entities) {
            double distance = calculateDistance(from, entity.getCoordinates());
            if (distance < minDistance) {
                minDistance = distance;
                closest = entity;
            }
        }
        return closest;
    }

    protected double calculateDistance(Coordinates a, Coordinates b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }

    protected Direction calculateDirection(Coordinates from, Coordinates to) {
        int dx = to.getX() - from.getX();
        int dy = to.getY() - from.getY();

        if (Math.abs(dx) > Math.abs(dy)) {
            return dx > 0 ? Direction.RIGHT : Direction.LEFT;
        } else {
            return dy > 0 ? Direction.DOWN : Direction.UP;
        }
    }

    protected Direction getRandomDirection() {
        Direction[] directions = Direction.values();
        return directions[(int) (Math.random() * directions.length)];
    }

    protected boolean isDead(){
        return hp <= 0;
    }
}
