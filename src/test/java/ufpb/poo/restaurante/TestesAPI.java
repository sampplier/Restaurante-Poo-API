package ufpb.poo.restaurante;
import static com.fasterxml.jackson.core.io.NumberInput.parseLong;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Random;

import org.junit.jupiter.api.Test;
import ufpb.poo.restaurante.restaurante.controller.RestauranteController;
import ufpb.poo.restaurante.restaurante.dto.RestauranteDTO;
import ufpb.poo.restaurante.restaurante.facade.RestauranteFacade;
import ufpb.poo.restaurante.restaurante.repoJPA.RepoJPA;

public class TestesAPI {
    private RestauranteFacade restauranteFacade = new RestauranteFacade();
    private RestauranteController restauranteController = new RestauranteController();

    @Test
    public void testaPost() throws Exception {
        RestauranteDTO restauranteTeste = new RestauranteDTO(1, "example.jpg", "Restaurante Teste", "Descrição do Restaurante Teste", 25.99);
        assertThrows(Exception.class, () -> {
            restauranteController.criar(restauranteTeste, new HashMap<String, String>());
        });

    }
    @Test
    public void testaGet() {
        try {
            // URL da API que você deseja acessar
            String url = "https://restaurante-poo-api.up.railway.app/restaurante";
            // Abre uma conexão HTTP
            HttpURLConnection conexão = (HttpURLConnection) new URL(url).openConnection();
            // Configura o método de requisição (GET, POST, etc.)
            conexão.setRequestMethod("GET");
            // Lê a resposta da API
            BufferedReader leitor = new BufferedReader(new InputStreamReader(conexão.getInputStream()));
            String linha;
            StringBuilder resposta = new StringBuilder();

            while ((linha = leitor.readLine()) != null) {
                resposta.append(linha);
            }
            leitor.close();
            // Imprime a resposta da API
            assertNotNull(resposta.toString());
            // Fecha a conexão
            conexão.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testaDelete() throws Exception {
        Random random = new Random();
        Long id = random.nextLong();
        RestauranteDTO restauranteTeste = new RestauranteDTO(1, "example.jpg", "Restaurante Teste", "Descrição do Restaurante Teste", 25.99);
        assertThrows(Exception.class, () -> {
            restauranteController.atualizar(id, restauranteTeste,new HashMap<String, String>() );
        });

    }
}