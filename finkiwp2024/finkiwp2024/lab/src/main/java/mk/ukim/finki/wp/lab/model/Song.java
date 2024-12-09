package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String trackId;

    String title;

    String genre;

    int releaseYear;

    @ManyToMany
    List<Artist> performers;

    @ManyToOne
    Album album;

    public Song( String trackId,String title, String genre, int releaseYear,Album album) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers =  new ArrayList<>();
        this.album=album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
