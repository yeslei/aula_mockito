package jogo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JogoTest {

    private Jogador jogador;
    private Dado dado1;
    private Dado dado2;
    private Jogo jogo;

    @BeforeEach
    public void prepararTeste() {
        jogador = mock(Jogador.class);
        dado1 = mock(Dado.class);
        dado2 = mock(Dado.class);
        jogo = new Jogo(jogador, dado1, dado2);
    }

    @Test
    public void deveGanharQuandoPrimeiraJogadaForSete() {
        when(jogador.lancar(dado1, dado2)).thenReturn(7);

        assertTrue(jogo.jogo());

        verify(jogador, times(1)).lancar(dado1, dado2);
    }

    @Test
    public void deveGanharQuandoPrimeiraJogadaForOnze() {
        when(jogador.lancar(dado1, dado2)).thenReturn(11);

        assertTrue(jogo.jogo());
    }

    @Test
    public void devePerderQuandoPrimeiraJogadaForDois() {
        when(jogador.lancar(dado1, dado2)).thenReturn(2);

        assertFalse(jogo.jogo());
    }

    @Test
    public void devePerderQuandoPrimeiraJogadaForTres() {
        when(jogador.lancar(dado1, dado2)).thenReturn(3);

        assertFalse(jogo.jogo());
    }

    @Test
    public void devePerderQuandoPrimeiraJogadaForDoze() {
        when(jogador.lancar(dado1, dado2)).thenReturn(12);

        assertFalse(jogo.jogo());
    }

    @Test
    public void deveGanharQuandoRepeteOPonto() {
        when(jogador.lancar(dado1, dado2)).thenReturn(6, 5, 6);

        assertTrue(jogo.jogo());

        verify(jogador, times(3)).lancar(dado1, dado2);
    }

    @Test
    public void devePerderQuandoSaiSeteAntesDeRepetirOPonto() {
        when(jogador.lancar(dado1, dado2)).thenReturn(8, 5, 7);

        assertFalse(jogo.jogo());

        verify(jogador, times(3)).lancar(dado1, dado2);
    }
}
