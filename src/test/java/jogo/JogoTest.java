package jogo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class JogoTest {

    @Test
    public void testarJogo() {

        Jogador jogador = mock(Jogador.class);
        Dado dado1 = mock(Dado.class);
        Dado dado2 = mock(Dado.class);

        when(jogador.lancar(dado1, dado2)).thenReturn(7);

        Jogo jogo = new Jogo();

        boolean resultado = jogo.jogo();

        assertTrue(resultado);
    }
}