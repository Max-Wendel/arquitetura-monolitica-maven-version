package br.com.emmanuelneri.monolitica.Veiculo;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.emmanuelneri.monolitica.model.Modelo;
import br.com.emmanuelneri.monolitica.model.Veiculo;
import br.com.emmanuelneri.monolitica.service.VeiculoService;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class VeiculoServiceUnitTest {

	@Mock Veiculo veiculo;
	@Mock VeiculoService veiculoService;
	@Mock Modelo modelo;
	
	ArrayList<Veiculo> veiculos;
	HashMap<Modelo, Collection<Veiculo>> teste;
	
	@Before
	public void setUp() {
		veiculos = new ArrayList<Veiculo>();
		
		veiculo.setNome("aaaa");
		veiculo.setModelo(modelo);
		veiculos.add(veiculo);
		
		veiculo.setNome("bbbb");
		veiculo.setModelo(modelo);
		veiculos.add(veiculo);
		
		veiculo.setNome("ccc");
		veiculo.setModelo(modelo);
		veiculos.add(veiculo);
		
		teste = new HashMap<Modelo,Collection<Veiculo>>();
		teste.put(modelo, veiculos);
	}
	
	@Test
	public void TestaCadastrarVeiculo() {
		Mockito.lenient().doNothing().when(veiculoService).save(veiculo);
		veiculoService.save(veiculo);
		verify(veiculoService,atMost(2)).save(veiculo);
	}
	
	@Test
	public void TestafindVeiculosPorModeloNaoNulo() {
		Mockito.lenient().when(veiculoService.findVeiculosPorModelo()).thenReturn(teste);
		assertNotNull(veiculoService.findVeiculosPorModelo());
	}
	
}
