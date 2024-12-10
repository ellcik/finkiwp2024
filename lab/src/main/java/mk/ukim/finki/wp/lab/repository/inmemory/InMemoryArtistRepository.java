package mk.ukim.finki.wp.lab.repository.inmemory;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class InMemoryArtistRepository {

    public List<Artist> findAll(){
        return DataHolder.artistList;
    }
    public Artist findById(Long id){
        return DataHolder.artistList.stream().filter(i->i.getId().equals(id)).findFirst().orElse(null);
    }
}
