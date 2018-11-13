package br.com.emmanuelneri.monolitica.Pedido;

import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.emmanuelneri.monolitica.model.Pedido;
import br.com.emmanuelneri.monolitica.service.PedidoService;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class PedidoServiceUnitTest {
	
	@Mock Pedido pedido;
	@Mock PedidoService pedidoService;
	
	@Test
	public void TestaSalvarPedido() {
		pedidoService.save(pedido);
		when(pedidoService.findById(pedido.getId())).thenReturn(pedido);
		verify(pedidoService, atMost(10)).save(pedido);
	}
}
