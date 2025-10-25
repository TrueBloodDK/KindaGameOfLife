package com.security.entity;


import com.security.map.Coordinates;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
abstract public class Entity {
    private Coordinates coordinates;
}