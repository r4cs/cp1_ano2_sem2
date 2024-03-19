package cp1_2024_sem2_DBE.cp1.Service.Strategy;

import cp1_2024_sem2_DBE.cp1.Entity.Livro;

import java.util.Comparator;
import java.util.List;

public class ClassificarPorAtributoStrategy implements ClassificacaoStrategy {

    @Override
    public List<Livro> classificarPorTitulo(List<Livro> livros) {
        livros.sort(Comparator.comparing(Livro::getTitle));
        return livros;
    }

    @Override
    public List<Livro> classificarPorAutor(List<Livro> livros) {
        livros.sort(Comparator.comparing(Livro::getAuthor));
        return livros;
    }

    @Override
    public List<Livro> classificarPorAno(List<Livro> livros) {
        livros.sort(Comparator.comparingInt(Livro::getPublishYear).reversed());
        return livros;
    }

    @Override
    public List<Livro> classificarPorCategoria(List<Livro> livros) {
        livros.sort(Comparator.comparing(Livro::getCategory));
        return livros;
    }


}
