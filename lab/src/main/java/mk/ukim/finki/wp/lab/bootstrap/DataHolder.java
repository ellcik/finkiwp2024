package mk.ukim.finki.wp.lab.bootstrap;
import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.jpa.AlbumRepository;
import mk.ukim.finki.wp.lab.repository.jpa.ArtistRepository;
import mk.ukim.finki.wp.lab.repository.jpa.SongRepository;
import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
public class DataHolder {
    public static List<Artist> artistList;
    public static List<Song> songs;
    public static List<Album> albums;

    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;

    public DataHolder(SongRepository songRepository, ArtistRepository artistRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }


    @PostConstruct
    public void init() {
        artistList = new ArrayList<>();
        artistList.add(new Artist("Ime1", "Prezime1", "bio1"));
        artistList.add(new Artist("Ime2", "Prezime2", "bio2"));
        artistList.add(new Artist("Ime3", "Prezime3", "bio3"));
        artistList.add(new Artist("Ime4", "Prezime4", "bio4"));
        artistList.add(new Artist("Ime5", "Prezime5", "bio5"));

        if (this.artistRepository.count() == 0) {
            this.artistRepository.saveAll(artistList);
        }

        songs = new ArrayList<>();
        songs.add(new Song("Pesna1", "rock", 2017, artistList.stream().filter(a -> a.getFirstName().startsWith("M")).collect(Collectors.toList())));
        songs.add(new Song("Pesna2", "rock", 2019, artistList.stream().filter(a -> a.getFirstName().startsWith("I")).collect(Collectors.toList())));
        songs.add(new Song("Pesna3", "pop", 2014, artistList.stream().filter(a -> a.getFirstName().startsWith("D")).collect(Collectors.toList())));

        albums=new ArrayList<>();
        albums.add(new Album("Album 1", "Rock", "2020"));
        albums.add(new Album("Album 2", "Pop", "2018"));
        albums.add(new Album("Album 3", "Jazz", "2019"));
        albums.add(new Album("Album 4", "Classical", "2021"));
        albums.add(new Album("Album 5", "Electronic", "2022"));

        if (this.albumRepository.count() == 0) {
            this.albumRepository.saveAll(albums);
        }

        Random random = new Random();
        songs.forEach(song -> {
            int randomIndex = random.nextInt(albumRepository.findAll().size());
            Album randomAlbum = albumRepository.findAll().get(randomIndex);
            song.setAlbum(randomAlbum);
        });


        if (this.songRepository.count() == 0) {
            this.songRepository.saveAll(songs);
        }
    }

}
