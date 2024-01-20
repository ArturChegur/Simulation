package main.algorithm;

import main.model.Entity;

public class Node<T extends Entity> {
    private T entity;

    public Node(T entity) {
        this.entity = entity;
    }

    public T getEntity() {
        //todo what should be returned?
        return entity;
    }
}
