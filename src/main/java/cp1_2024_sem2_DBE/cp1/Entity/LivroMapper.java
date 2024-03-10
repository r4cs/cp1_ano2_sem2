package cp1_2024_sem2_DBE.cp1.Entity;


public class LivroMapper {

    public static LivroDto toDto(Livro livro) {
        return new LivroDto(livro.getTitle(), livro.getAuthor(), livro.getPublishYear(), livro.getCategory());
    }

    public static Livro toEntity(LivroDto livroDto) {
        return new Livro(livroDto.title(),
                         livroDto.author(),
                         livroDto.publishYear(),
                         livroDto.category());
    }
}
