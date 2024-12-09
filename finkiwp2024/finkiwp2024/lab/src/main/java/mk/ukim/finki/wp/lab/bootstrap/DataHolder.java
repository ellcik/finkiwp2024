package mk.ukim.finki.wp.lab.bootstrap;
import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Artist> artists = new ArrayList<>();
    public static List<Song> songs = new ArrayList<>();
    public static List<Album> albums=new ArrayList<>();

    @PostConstruct
      public void init(){
//        artists = new ArrayList<>();
//        songs = new ArrayList<>();
//        albums = new ArrayList<>();
//
//        artists.add(new Artist("Axl", "Rose", "Lead singer of Guns N' Roses"));
//        artists.add(new Artist("Jon Bon", "Jovi", "Frontman of Bon Jovi"));
//        artists.add(new Artist("David", "Bowie", "British rock legend"));
//        artists.add(new Artist("Freddie", "Mercury", "Vocalist of Queen"));
//        artists.add(new Artist("Stevie", "Nicks", "Singer in Fleetwood Mac"));
//
//        Album album1=new Album("Thriller", "Pop", "1982");
//        Album album2=new Album("Back in Black", "Rock", "1980");
//        Album album3=new Album("Dark Side of the Moon", "Progressive Rock", "1973");
//        Album album4=new Album("The Bodyguard", "Soundtrack", "1992");
//        Album album5=new Album("Rumours", "Rock", "1977");
//
//        albums.add(album1);
//        albums.add(album2);
//        albums.add(album3);
//        albums.add(album4);
//        albums.add(album5);
//
//
//        songs.add(new Song("001", "Bohemian Rhapsody", "Rock", 1975,album1));
//        songs.add(new Song("002", "Billie Jean", "Pop", 1982,album2));
//        songs.add(new Song("003", "Hotel California", "Rock", 1976,album3));
//        songs.add(new Song("004", "Imagine", "Pop", 1971,album4));
//        songs.add(new Song("005", "Smells Like Teen Spirit", "Grunge", 1991,album5));
//
//        album1.addSong(songs.get(0));
//        album2.addSong(new Song("002", "Billie Jean", "Pop", 1982,album2));
//        album3.addSong(new Song("003", "Hotel California", "Rock", 1976,album3));
//        album4.addSong(new Song("004", "Imagine", "Pop", 1971,album4));
//        album5.addSong(new Song("005", "Smells Like Teen Spirit", "Grunge", 1991,album5));



    }

}