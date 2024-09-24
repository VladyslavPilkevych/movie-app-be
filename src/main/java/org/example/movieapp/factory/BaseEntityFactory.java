package org.example.movieapp.factory;

import org.example.movieapp.model.Media;

public abstract class BaseEntityFactory implements EntityFactory {
    @Override
    public Media createMedia() {
        throw new UnsupportedOperationException("Method createMedia() is not implemented");
    }
}
