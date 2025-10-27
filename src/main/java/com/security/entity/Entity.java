package com.security.entity;


import com.security.map.Coordinates;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@NoArgsConstructor
abstract public class Entity {
    @Setter @Getter
    private Coordinates coordinates;

    public Entity(Coordinates coordinates){
        this.coordinates = coordinates;
    }
}