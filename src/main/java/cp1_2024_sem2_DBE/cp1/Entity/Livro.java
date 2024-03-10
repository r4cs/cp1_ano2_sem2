package cp1_2024_sem2_DBE.cp1.Entity;

import javax.persistence.*;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livro_gen")
    @SequenceGenerator(name = "livro_gen", sequenceName = "livro_seq")
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String author;
    private Integer publishYear;
    private String category;


    public Livro() {}

    public Livro(String title, String author, Integer publishYear, String category) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
