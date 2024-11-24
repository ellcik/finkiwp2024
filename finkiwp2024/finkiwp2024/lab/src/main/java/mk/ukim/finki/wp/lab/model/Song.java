package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Data
public class Song {

    private Long id;
    String trackId;
    String title;
    String genre;
    int releaseYear;
    List<Artist> performers;
    private Album album;

    public Song(String trackId, String title, String genre, int releaseYear,Album album) {
        this.id= (long) (Math.random()*1000);
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers =  new ArrayList<>();
        this.album=album;
    }

    public String getTrackId() {
        return trackId;
    }

    public List<Artist> getPerformers() {
        return performers;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
