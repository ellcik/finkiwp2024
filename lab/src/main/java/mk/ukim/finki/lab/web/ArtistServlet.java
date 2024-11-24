package mk.ukim.finki.lab.web;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.service.impl.ArtistServiceImpl;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;


@WebServlet(name="ArtistServlet", urlPatterns = "/artist")
public class ArtistServlet extends HttpServlet {

    private final ArtistServiceImpl artistService;
    private final SpringTemplateEngine springTemplateEngine;

    public ArtistServlet(ArtistServiceImpl artistService, SpringTemplateEngine springTemplateEngine) {

        this.artistService = artistService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req,resp);
        WebContext context = new WebContext(webExchange);

        context.setVariable("artists", artistService.listArtists());

        springTemplateEngine.process("artistsList.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String trackId;

        if (req.getParameter("songRadio") != null) {
            trackId = req.getParameter("songRadio");
        } else {
            trackId = "-";
        }
        IWebExchange iWebExchange = JakartaServletWebApplication
                .buildApplication(req.getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(iWebExchange);

        context.setVariable("trackId", trackId);
        context.setVariable("artistList", artistService.listArtists());

        springTemplateEngine.process("artistsList.html", context, resp.getWriter());

    }
}
