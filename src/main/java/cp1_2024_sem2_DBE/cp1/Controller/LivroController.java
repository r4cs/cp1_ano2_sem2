package cp1_2024_sem2_DBE.cp1.Controller;

import cp1_2024_sem2_DBE.cp1.Entity.Livro;
import cp1_2024_sem2_DBE.cp1.Entity.LivroDto;
import cp1_2024_sem2_DBE.cp1.Entity.LivroMapper;
import cp1_2024_sem2_DBE.cp1.Service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public ResponseEntity<List<LivroDto>> findAll() {
        List<Livro> livros = livroService.findAll();
        List<LivroDto> livrosDto = livros.stream().map(LivroMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(livrosDto);
    }


    @GetMapping("/{id}")
    public ResponseEntity<LivroDto> findById(@PathVariable Long id) {
        Livro livro = livroService.findById(id);
        return livro != null ? ResponseEntity.ok(LivroMapper.toDto(livro)) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<LivroDto> save(@RequestBody @Valid LivroDto livroDto) {
        Livro livro = LivroMapper.toEntity(livroDto);
        Livro savedLivro = livroService.save(livro);
        return ResponseEntity.ok(LivroMapper.toDto(savedLivro));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<LivroDto> patch(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Livro updatedLivro = livroService.update(id, updates);
        return ResponseEntity.ok(LivroMapper.toDto(updatedLivro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        livroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    // exemplo no postman: http://localhost:8080/livros/search?term=Fundação?orderby=Ano
    public ResponseEntity<List<LivroDto>> search(@RequestParam String term, @RequestParam String orderBy) {
        List<Livro> livros = livroService.search(term, orderBy);
        List<LivroDto> livrosDto = livros.stream().map(LivroMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(livrosDto);
    }

}
