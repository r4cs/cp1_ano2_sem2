package cp1_2024_sem2_DBE.cp1.Entity;


import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;


/**
 * DTO for {@link Livro}
 */
@Validated
public record LivroDto(
//        @NotNull
        @NotBlank
        String title,
//        @NotNull
        @NotBlank
        String author,
        @Digits(integer = 4, fraction = 0)
        @Min(1500)
        @Max(2023)
        Integer publishYear,
//        @NotNull
        @NotBlank
        String category) {

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "title = " + title + ", " +
                "author = " + author + ", " +
                "publishYear = " + publishYear + ", " +
                "category = " + category + ")";
    }
}