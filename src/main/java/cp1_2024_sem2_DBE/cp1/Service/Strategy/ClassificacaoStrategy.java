package cp1_2024_sem2_DBE.cp1.Service.Strategy;

import java.util.List;
import cp1_2024_sem2_DBE.cp1.Entity.Livro;

public interface ClassificacaoStrategy {
    List<Livro> classificarPorTitulo(List<Livro> livros);
    List<Livro> classificarPorAutor(List<Livro> livros);
    List<Livro> classificarPorAno(List<Livro> livros);
    List<Livro> classificarPorCategoria(List<Livro> livros);
}