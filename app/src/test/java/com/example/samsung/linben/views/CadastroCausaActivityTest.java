package com.example.samsung.linben.views;

import com.example.samsung.linben.models.Causa;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Raquel on 08/12/2017.
 */
public class CadastroCausaActivityTest {
    @Test
    public void testTipoSanguineoCorreto(){
        Causa causa = new Causa("Minha prima está internada com leucemia e precisa de doação de sangue", "Josefa Maria da Silva", "A+", "leucemia");
        boolean resultado = causa.validacaoTipoSanguineo();
        assertTrue(resultado);
    }

    @Test
    public void testTipoSanguineoIncorreto(){
        Causa causa= new Causa("Vou fazer uma cirurgia e preciso de doações de sangue", "Maria das Graças", "A", "Cirurgia");
        boolean resultado = causa.validacaoTipoSanguineo();
        assertFalse(resultado);
    }

    @Test
    public void testValidacaoCampoDoenca() {
        Causa causa = new Causa("Meu filho precisa de doação de sangue,pois perdeu muito sangue em um acidente. Conto com a sua colaboração!","José Carlos","O-","" );
        boolean resultado = causa.validacaoCampoDoenca();
        assertFalse(resultado);
    }

    @Test
    public void testValidacaoCamposNulo(){
        Causa causa = new Causa ("","","","");
        boolean resultado = causa.validacaoTodosCamposNulo();
        assertFalse(resultado);
    }

}