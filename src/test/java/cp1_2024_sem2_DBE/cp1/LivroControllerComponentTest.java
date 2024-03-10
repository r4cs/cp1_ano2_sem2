package cp1_2024_sem2_DBE.cp1;

import com.github.javafaker.Faker;
import cp1_2024_sem2_DBE.cp1.Entity.Livro;
import cp1_2024_sem2_DBE.cp1.Entity.LivroDto;
import cp1_2024_sem2_DBE.cp1.Entity.LivroMapper;
import cp1_2024_sem2_DBE.cp1.Service.LivroService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.print.attribute.standard.Media;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class LivroControllerComponentTest {

    @MockBean
    private LivroService livroService;
    private MockMvc mockMvc;
    private Faker faker = new Faker();

    @Autowired
    public LivroControllerComponentTest(MockMvc mockMvc, TestRestTemplate restTemplate) {
        this.mockMvc = mockMvc;
    }


    @Test
    public void adicionarLivroComSucesso() throws Exception {

        LivroDto livroDto = new LivroDto(
                faker.book().title(),
                faker.book().author(),
                faker.number().numberBetween(1900, 2023),
                faker.book().genre()
        );

        Livro livro = LivroMapper.toEntity(livroDto);

        // Configurando o comportamento do serviço mock para retornar o livro criado
        Mockito.when(livroService.save(any(Livro.class))).thenReturn(livro);

        /*
            .perform() -> perform a request and return a type that allows chaining further actions,
                    such as asserting expectations, on the result.
            Params:
            requestBuilder – used to prepare the request to execute;
                                see static factory methods in org.springframework.test.web.servlet.request.MockMvcRequestBuilders
            Returns:
            an instance of ResultActions (never null)
         */
        // Enviando uma solicitação POST com o objeto LivroDto como conteúdo JSON
        mockMvc.perform(MockMvcRequestBuilders.post("/livros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"" + livroDto.title() + "\",\"author\":\"" + livroDto.author() + "\",\"publishYear\":" + livroDto.publishYear() + ",\"category\":\"" + livroDto.category() + "\"}")
                        .accept(MediaType.APPLICATION_JSON))
                // Verificando se a solicitação foi bem-sucedida
                .andExpect(MockMvcResultMatchers.status().isOk())
                // Verificando se o corpo da resposta contém o objeto LivroDto
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(livroDto.title()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author").value(livroDto.author()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.publishYear").value(livroDto.publishYear()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.category").value(livroDto.category()));
    }

    @Test
    void adicionarLivroSemSucesso() throws Exception {

        // teste 1
        LivroDto livroDto1 = new LivroDto(
                "",
                faker.book().author(),
                faker.number().numberBetween(1500, 2023),
                faker.book().genre()
        );

        Livro livro = LivroMapper.toEntity(livroDto1);

        Mockito.when(livroService.save(any(Livro.class))).thenReturn(livro);

        mockMvc.perform(MockMvcRequestBuilders.post("/livros")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"" + livroDto1.title() + "\",\"author\":\"" + livroDto1.author() + "\",\"publishYear\":" + livroDto1.publishYear() + ",\"category\":\"" + livroDto1.category() + "\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());


        // teste 2
        LivroDto livroDto2 = new LivroDto(
                faker.book().title(),
                "   ",
                faker.number().numberBetween(1500, 2023),
                faker.book().genre()
        );

        Livro livro2 = LivroMapper.toEntity(livroDto2);

        Mockito.when(livroService.save(any(Livro.class))).thenReturn(livro2);

        mockMvc.perform(MockMvcRequestBuilders.post("/livros")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"" + livroDto2.title() + "\",\"author\":\"" + livroDto2.author() + "\",\"publishYear\":" + livroDto2.publishYear() + ",\"category\":\"" + livroDto2.category() + "\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());


        // teste 3
        LivroDto livroDto3 = new LivroDto(
                faker.book().title(),
                faker.book().author(),
                faker.number().numberBetween(1, 1499),
                faker.book().genre()
        );

        Livro livro3 = LivroMapper.toEntity(livroDto3);

        Mockito.when(livroService.save(any(Livro.class))).thenReturn(livro3);

        mockMvc.perform(MockMvcRequestBuilders.post("/livros")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"" + livroDto3.title() + "\",\"author\":\"" + livroDto3.author() + "\",\"publishYear\":" + livroDto3.publishYear() + ",\"category\":\"" + livroDto3.category() + "\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());


        // teste 4
        LivroDto livroDto4 = new LivroDto(
                faker.book().title(),
                faker.book().author(),
                faker.number().numberBetween(1500, 2023),
                "         "
        );

        Livro livro4 = LivroMapper.toEntity(livroDto4);

        Mockito.when(livroService.save(any(Livro.class))).thenReturn(livro);

        mockMvc.perform(MockMvcRequestBuilders.post("/livros")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"" + livroDto4.title() + "\",\"author\":\"" + livroDto4.author() + "\",\"publishYear\":" + livroDto4.publishYear() + ",\"category\":\"" + livroDto4.category() + "\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}