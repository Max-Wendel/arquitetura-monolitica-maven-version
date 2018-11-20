package br.com.emmanuelneri.monolitica.Veiculo;

import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.emmanuelneri.monolitica.model.Veiculo;
import br.com.emmanuelneri.monolitica.service.VeiculoService;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class VeiculoServiceUnitTest {

	@Mock Veiculo veiculo;
	@Mock VeiculoService veiculoService;
	
	@Test
	public void TestaCadastrarVeiculo() {
		veiculoService.save(veiculo);
		Mockito.lenient().when(veiculoService.findById(veiculo.getId())).thenReturn(veiculo);
		verify(veiculoService, atMost(10)).save(veiculo);
	}
}
