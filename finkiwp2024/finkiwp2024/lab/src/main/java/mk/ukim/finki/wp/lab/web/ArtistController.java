package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.service.impl.ArtistServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Controller
@RequestMapping("/artists")
public class ArtistController {

    private final ArtistServiceImpl artistService;
    private final SpringTemplateEngine springTemplateEngine;

    // Constructor-based dependency injection
    public ArtistController(ArtistServiceImpl artistService, SpringTemplateEngine springTemplateEngine) {
        this.artistService = artistService;
        this.springTemplateEngine = springTemplateEngine;
    }

    // Handle GET request to show list of artists


    @GetMapping
    public String listArtists(Model model) {
        //model.addAttribute(trackId);
        model.addAttribute("artists", artistService.listArtists());
        return "artistsList"; // Refers to artistsList.html template
    }

    // Handle POST request to add artist to a song
    @PostMapping("/add-to-song")
    public String addArtistToSong(
            @RequestParam(required = false) String songRadio,
            Model model) {

        String trackId = (songRadio != null) ? songRadio : "-";
        model.addAttribute("trackId", trackId);
        model.addAttribute("artistList", artistService.listArtists());

        // Returns the updated HTML page
        return "artistsList"; // Refers to artistsList.html template
    }
}
