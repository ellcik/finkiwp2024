package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;

import java.util.List;

public interface SongService {

    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    Song findByTrackId(String trackId);

    void deleteByTrackId(Long trackId);

    void edit(String trackId, String title, String genre, int releaseYear, String albumId);
    void add(String trackId, String title, String genre, int releaseYear, String albumId);

}
