package cp1_2024_sem2_DBE.cp1.Service.Strategy;

import java.util.List;
import cp1_2024_sem2_DBE.cp1.Entity.Livro;

public class ClassificacaoContex {
    private ClassificacaoStrategy strategy;

    public ClassificacaoContex(ClassificacaoStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(ClassificacaoStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Livro> classificarPorTitulo(List<Livro> livros) {
        return strategy.classificarPorTitulo(livros);
    }

    public List<Livro> classificarPorAutor(List<Livro> livros) {
        return strategy.classificarPorAutor(livros);
    }

    public List<Livro> classificarPorAno(List<Livro> livros) {
        return strategy.classificarPorAno(livros);
    }

    public List<Livro> classificarPorCategoria(List<Livro> livros) {
        return strategy.classificarPorCategoria(livros);
    }
}
