package mk.ukim.finki.wp.lab.repository.inmemory;


import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemorySongRepository {

    public List<Song> findAll(){
        return DataHolder.songs;
    }

    public Song findByTrackId(String trackId){
        return DataHolder.songs.stream()
                .filter(s->s.getId().equals(Long.parseLong(trackId)))
                .findFirst().orElse(null);
    }
    public Artist addArtistToSong(Artist artist, Song song){
        for (Song s : DataHolder.songs) {
            if (s.getId().equals(song.getId())) {
                s.getPerformers().add(artist);
                return artist;
            }
        }
        return null;
    }
    public boolean deleteByTrackId(String trackId) {
        return DataHolder.songs.removeIf(song -> song.getTrackId().equals(trackId));
    }


}
