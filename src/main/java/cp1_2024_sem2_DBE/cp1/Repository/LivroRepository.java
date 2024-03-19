package cp1_2024_sem2_DBE.cp1.Repository;

import cp1_2024_sem2_DBE.cp1.Entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByTitleOrAuthorOrCategory(String termTitle, String termAuthor, String termCategory);
}