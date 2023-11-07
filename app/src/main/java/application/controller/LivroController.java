package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.GeneroRepository;
import application.model.Livro;
import application.model.LivroRepository;

@Controller
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    private LivroRepository livroRepo;
    @Autowired
    private GeneroRepository generoRepo;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("livros", livroRepo.findAll());
        return "livro/list";
    }

    @RequestMapping("/insert")
    public String insert(Model model) {
        model.addAttribute("generos", generoRepo.findAll());
        return "livro/insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(
        @RequestParam("titulo") String titulo,
        @RequestParam("isbn") String isbn,
        @RequestParam("genero") int idGenero
    ) {
        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setIsbn(isbn);
        livro.setGenero(generoRepo.findById(idGenero).get());

        livroRepo.save(livro);

        return "redirect:/livro/list";
    }
 }
