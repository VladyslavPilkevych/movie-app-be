package org.example.movieapp.factory;

import org.example.movieapp.model.Media;

public class MediaFactory extends BaseEntityFactory {
    @Override
    public Media createMedia() { return new Media(); }
}
