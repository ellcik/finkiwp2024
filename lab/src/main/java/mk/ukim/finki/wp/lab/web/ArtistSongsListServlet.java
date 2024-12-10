//package mk.ukim.finki.wp.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.wp.lab.service.impl.ArtistServiceImpl;
//import mk.ukim.finki.wp.lab.service.impl.SongServiceImpl;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(name="ArtistSongsListServlet")
//public class ArtistSongsListServlet extends HttpServlet {
//
//    private final ArtistServiceImpl artistService;
//    private final SongServiceImpl songService;
//
//    public ArtistSongsListServlet(ArtistServiceImpl artistService, SongServiceImpl songService) {
//        this.artistService = artistService;
//        this.songService = songService;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req,resp);
//        WebContext webContext = new WebContext(webExchange);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req,resp);
//        WebContext webContext = new WebContext(webExchange);
//    }
//}
