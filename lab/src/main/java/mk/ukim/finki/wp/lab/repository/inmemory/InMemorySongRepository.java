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
    public Artist addArtistToSong(Artist artist,Song song){
        if(DataHolder.songs.stream().noneMatch(s -> s.equals(song))){
            return null;
        }
        List<Artist> songArtist = DataHolder.songs.stream().filter(i->i.equals(song)).findFirst().get().getPerformers();
        songArtist.add(artist);
        song.setPerformers(songArtist);
        return artist;
    }
    public Song findById(Long id){
        return DataHolder.songs.stream().filter(s->s.getId().equals(id)).findFirst().orElse(null);
    }
}
