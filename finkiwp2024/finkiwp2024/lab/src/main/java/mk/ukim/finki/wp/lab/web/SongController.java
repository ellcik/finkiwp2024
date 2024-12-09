package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.inmemory.InMemoryAlbumRepository;
import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;
    private final AlbumService albumService;

    public SongController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @GetMapping(path={"/listSongs", ""})
    public String listSongs(Model model) {
        model.addAttribute("songs", songService.listSongs());
        return "listSongs";
    }

    @GetMapping("/add-form")
    public String getAddSongPage(Model model) {
        model.addAttribute("albums", albumService.findAll());
        model.addAttribute("song", new Song());
        return "add-song";
    }

    @PostMapping("/add")
    public String addOrEditSong(
            @RequestParam String trackId,
            @RequestParam String title,
            @RequestParam String genre,
            @RequestParam int releaseYear,
            @RequestParam String albumId,
            @RequestParam(required = false) Long id) {

        if (id == null) {
            songService.add(trackId, title, genre, releaseYear, albumId);
        } else {
            songService.edit(trackId, title, genre, releaseYear, albumId);
        }
        return "redirect:/songs";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditSongForm(@PathVariable String id, Model model) {
        try {
            Song song = songService.findByTrackId(id);
            model.addAttribute("song", song);
            model.addAttribute("albums", albumService.findAll());
            return "add-song";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", "Song not found.");
            return "redirect:/songs";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable Long id) {
        songService.deleteByTrackId(id);
        return "redirect:/songs";
    }
}
