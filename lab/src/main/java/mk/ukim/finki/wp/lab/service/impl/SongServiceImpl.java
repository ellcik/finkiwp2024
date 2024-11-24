package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.AlbumRepository;
import mk.ukim.finki.wp.lab.repository.ArtistRepository;
import mk.ukim.finki.wp.lab.repository.SongRepository;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;

    public SongServiceImpl(SongRepository songRepository, ArtistRepository artistRepository,AlbumRepository albumRepository) {
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
        return songRepository.addArtistToSong(artist,song);
    }

    @Override
    public Song findByTrackId(String trackId) {
        return this.songRepository.findByTrackId(trackId);
    }

    @Override
    public void deleteByTrackId(String trackId) {
        DataHolder.songs.removeIf(song -> song.getTrackId().equals(trackId));

    }

    public void edit(String trackId, String title, String genre, int releaseYear, String albumId) {
        Song song = this.findByTrackId(trackId);
        if (song != null) {
            song.setTitle(title);
            song.setGenre(genre);
            song.setReleaseYear(releaseYear);
            Album album = DataHolder.albums.stream()
                    .filter(a -> a.getId().toString().equals(albumId))
                    .findFirst()
                    .orElse(null);
            song.setAlbum(album);
        }
    }
        public void add(String trackId, String title, String genre, int releaseYear, String albumId) {
            Album album = DataHolder.albums.stream()
                    .filter(a -> a.getId().toString().equals(albumId))
                    .findFirst()
                    .orElse(null);

            Song newSong = new Song(trackId, title, genre, releaseYear, album);
            DataHolder.songs.add(newSong);
        }
}
