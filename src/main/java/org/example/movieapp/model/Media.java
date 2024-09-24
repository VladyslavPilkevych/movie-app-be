package org.example.movieapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.movieapp.utils.MediaContentType;

import java.util.Date;

@Entity
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Title is required")
    @Size(min = 1, message = "Title must not be empty")
    @Column
    private String title;

    @NotNull(message = "Description is required")
    @Column
    private String description;

    @Min(value = 0, message = "Popularity must be non-negative")
    @Column
    private double popularity;

    @NotNull(message = "Year is required")
    @Min(value = 1900, message = "Year must be a valid number")
    @Column
    private int year;

    @Min(value = 1, message = "Duration must be at least 1 minute")
    @Column
    private int duration;

    @NotNull(message = "ContentType is required")
    @Column
    private MediaContentType contentType; // 'movie', 'series', 'tv_show'

    @NotNull(message = "Genre is required")
    @Column
    private String genre;

    @Column
    private boolean isAdult;

    @NotNull(message = "ReleaseDate is required")
    @Column
    private Date releaseDate;

    @NotNull(message = "ImagePath is required")
    @Column
    private String imagePath;

    @NotNull(message = "PosterPath is required")
    @Column
    private String posterPath;

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public MediaContentType getContentType() {
        return contentType;
    }

    public void setContentType(MediaContentType contentType) {
        this.contentType = contentType;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("Media[id=%d, title='%s', description='%s', year=%d]", id, title, description, year);
    }
}
