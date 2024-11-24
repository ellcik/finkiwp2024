package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.AlbumRepository;
import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;
    private final AlbumRepository albumRepository;

    public SongController(SongService songService, AlbumRepository albumRepository) {
        this.songService = songService;
        this.albumRepository = albumRepository;
    }

    @GetMapping(path={"/listSongs", ""})
    public String listSongs(Model model) {
        model.addAttribute("songs", songService.listSongs());
        return "listSongs";
    }

    @GetMapping("/add-form")
    public String getAddSongPage(Model model) {
        model.addAttribute("albums", albumRepository.findAll());
        model.addAttribute("song", null);
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
            model.addAttribute("albums", albumRepository.findAll());
            return "add-song";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", "Song not found.");
            return "redirect:/songs";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteSong(@PathVariable String id) {
        songService.deleteByTrackId(id);
        return "redirect:/songs";
    }
}
