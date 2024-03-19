package cp1_2024_sem2_DBE.cp1.Service;

import cp1_2024_sem2_DBE.cp1.Entity.Livro;
import cp1_2024_sem2_DBE.cp1.Repository.LivroRepository;
import cp1_2024_sem2_DBE.cp1.Service.Strategy.ClassificarPorAtributoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LivroService {
    private final LivroRepository livroRepository;
    private static ClassificarPorAtributoStrategy classificarPorAtributoStrategy;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }
    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Livro findById(Long id) {
        return livroRepository.findById(id).orElse(null);
    }

    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro update(Long id, Map<String, Object> updates) {
        Optional<Livro> existingLivroOptional = livroRepository.findById(id);
        if (existingLivroOptional.isPresent()) {
            Livro existingLivro = existingLivroOptional.get();
            updates.forEach((field, value) -> {
                switch (field) {
                    case "title":
                        existingLivro.setTitle((String) value);
                        break;
                    case "author":
                        existingLivro.setAuthor((String) value);
                        break;
                    case "publishYear":
                        existingLivro.setPublishYear((Integer) value);
                        break;
                    case "category":
                        existingLivro.setCategory((String) value);
                        break;
                    default:
                        // Ignorar campos desconhecidos
                        break;
                }
            });
            return livroRepository.save(existingLivro);
        } else {
            throw new IllegalArgumentException("Livro não encontrado com o ID fornecido: " + id);
        }
    }

    public void deleteById(Long id) {
        livroRepository.deleteById(id);
    }

    public List<Livro> search(String term, String orderBy) {
        List<Livro> livros = livroRepository.findByTitleOrAuthorOrCategory(term, term, term);

        // Ordena a lista de livros de acordo com a estratégia especificada
        switch (orderBy) {
            case "titulo":
                classificarPorAtributoStrategy.classificarPorTitulo(livros);
                break;
            case "ano":
                classificarPorAtributoStrategy.classificarPorAno(livros);
                break;
            case "categoria":
                classificarPorAtributoStrategy.classificarPorCategoria(livros);
                break;
            default:
                // Caso não seja especificada uma estratégia válida, mantém a lista sem ordenação
                break;
        }
        return livros;
    }
}
