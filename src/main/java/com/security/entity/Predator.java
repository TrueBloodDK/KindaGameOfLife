package com.security.entity;

import com.security.map.Coordinates;
import com.security.map.Map;
import lombok.Getter;

import java.util.List;

public class Predator extends Animal{
    @Getter
    private final int attackPower;


    public Predator(int speed, int hp, int attackPower) {
        super(speed, hp);
        this.attackPower = attackPower;
    }

    @Override
    public void makeMove(Map map) {
        Herbivore target = findNearesHerbivore(map);

        if (canAttack(target)) {
            attack(map, target);
        } else {
            Direction directionToHerbivore = calculateDirection(getCoordinates(), target.getCoordinates());
            moveInDirection(map, directionToHerbivore);
        }
    }

    private Herbivore findNearesHerbivore(Map map){
        List<Entity> herbivores = map.getEntitiesOfType(Herbivore.class);
        if (herbivores.isEmpty()) {
            tryRandomMove(map);
            return null;
        }

        return (Herbivore) findClosestEntity(getCoordinates(), herbivores);
    }

    private boolean canAttack(Herbivore herbivore){
        Coordinates predatorPos = getCoordinates();
        Coordinates herbivorePos = herbivore.getCoordinates();

        int dx = Math.abs(predatorPos.getX() - herbivorePos.getX());
        int dy = Math.abs(predatorPos.getY() - herbivorePos.getY());

        return (dx == 1 && dy == 0) || (dx == 0 && dy == 1);
    }

    private void attack(Map map, Herbivore herbivore){
        herbivore.takeDamage(attackPower);

        if (herbivore.isDead()){
            map.removeEntity(herbivore.getCoordinates());
        }
    }
}
