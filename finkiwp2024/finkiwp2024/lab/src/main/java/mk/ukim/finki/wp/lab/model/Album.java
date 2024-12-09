package mk.ukim.finki.wp.lab.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Data
@Entity
@NoArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String genre;

    private String releaseYear;
    @OneToMany(mappedBy = "album")
    List<Song> songs=new ArrayList<>();

    public Album(String name, String genre, String releaseYear) {
        this.name = name;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.songs=new ArrayList<>();
    }

    public void addSong(Song song){
        songs.add(song);
        song.setAlbum(this);
    }
}
