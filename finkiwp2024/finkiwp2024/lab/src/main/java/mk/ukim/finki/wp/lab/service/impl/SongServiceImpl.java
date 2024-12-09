package mk.ukim.finki.wp.lab.service.impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.inmemory.InMemoryAlbumRepository;
import mk.ukim.finki.wp.lab.repository.inmemory.InMemoryArtistRepository;
import mk.ukim.finki.wp.lab.repository.inmemory.InMemorySongRepository;
import mk.ukim.finki.wp.lab.repository.jpa.AlbumRepository;
import mk.ukim.finki.wp.lab.repository.jpa.ArtistRepository;
import mk.ukim.finki.wp.lab.repository.jpa.SongRepository;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;

    public SongServiceImpl(SongRepository songRepository,
                           ArtistRepository artistRepository,
                           AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.artistRepository=artistRepository;
        this.albumRepository=albumRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        song.getPerformers().add(artist);
        songRepository.save(song);

        return artistRepository.save(artist);
    }

    @Override
    public Song findByTrackId(String trackId) {
        return this.songRepository.findSongByTrackId(trackId).orElse(null);
    }

    @Override
    public void deleteByTrackId(Long trackId) {
        songRepository.deleteById(trackId);

    }

    @Transactional
    public void edit(String trackId, String title, String genre, int releaseYear, String albumId) {
        Song song = songRepository.findSongByTrackId(trackId)
                .orElseThrow(() -> new RuntimeException("Song not found"));
            song.setTitle(title);
            song.setGenre(genre);
            song.setReleaseYear(releaseYear);

        Album album = albumRepository.findById(Long.parseLong(albumId))
                .orElseThrow(() -> new RuntimeException("Album not found"));
            song.setAlbum(album);
            songRepository.save(song);
        }

        @Transactional
        public void add(String trackId, String title, String genre, int releaseYear, String albumId) {
            Album album = albumRepository.findById(Long.parseLong(albumId))
                    .orElseThrow(() -> new RuntimeException("Album not found"));

            Song newSong = new Song(trackId,title, genre, releaseYear, album);

            songRepository.save(newSong);
        }
}
