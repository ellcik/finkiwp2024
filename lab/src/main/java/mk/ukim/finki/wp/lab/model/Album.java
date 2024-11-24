package mk.ukim.finki.wp.lab.model;


import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Data
public class Album {
    private Long id;
    private String name;
    private String genre;
    private String releaseYear;
    List<Song> songs=new ArrayList<>();

    public Album(String name, String genre, String releaseYear) {
        this.id = (long) (Math.random() * 1000);
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
