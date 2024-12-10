package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;
    String genre;
    int releaseYear;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Artist> performers;

    @ManyToOne
    private Album album;

    public Song(String title, String genre, int releaseYear, List<Artist> performers) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = performers;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void setPerformers(List<Artist> performers) {
        this.performers = performers;
    }
}
