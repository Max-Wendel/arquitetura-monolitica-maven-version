package br.com.emmanuelneri.monolitica.ItemPedido;

import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.emmanuelneri.monolitica.model.ItemPedido;
import br.com.emmanuelneri.monolitica.service.ItemPedidoService;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class ItemPedidoServiceUnitTest {
	
	@Mock ItemPedido itemPedido;
	@Mock ItemPedidoService itemPedidoService;
	
	@Test
	public void TestarSalvarItemPedido() {
		itemPedidoService.save(itemPedido);
		when(itemPedidoService.findById(itemPedido.getId())).thenReturn(itemPedido);
		verify(itemPedidoService, atMost(10)).save(itemPedido);
	}
}
