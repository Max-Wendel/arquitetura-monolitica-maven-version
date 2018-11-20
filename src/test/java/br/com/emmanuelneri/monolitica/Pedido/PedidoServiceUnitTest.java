package br.com.emmanuelneri.monolitica.Pedido;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.emmanuelneri.monolitica.exception.ValidationException;
import br.com.emmanuelneri.monolitica.model.Pedido;
import br.com.emmanuelneri.monolitica.model.Usuario;
import br.com.emmanuelneri.monolitica.service.PedidoService;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class PedidoServiceUnitTest {

	@Mock Pedido pedido;
	@Mock PedidoService pedidoService;
	@Mock Usuario usuario;

	ArrayList<Pedido> pedidos;

	@Before
	public void setup() {
		pedidos = new ArrayList<Pedido>();
		
		usuario.setEmail("abc@abc.com");
		usuario.setSenha("abc123");
		pedidos.add(new Pedido(usuario));
		
		usuario.setEmail("email@email.com");
		usuario.setSenha("email");
		pedidos.add(new Pedido(usuario));
		
		usuario.setEmail("baba@baba.com");
		usuario.setSenha("bababa");
		pedidos.add(new Pedido(usuario));
	}

	@Test
	public void SalvarTest() throws ValidationException {
		pedidoService.salvar(pedido);
		when(pedidoService.findById((long)1)).thenReturn(pedidos.get(0));
		assertTrue(pedidoService.findById((long)1).equals(pedidos.get(0)));
		verify(pedidoService, atMost(10)).save(pedido);
	}

	@Test
	public void findPedidoCompletoByIdTest() throws ValidationException {
		Mockito.lenient().when(pedidoService.findById((long)2)).thenReturn(pedidos.get(1));		
		verify(pedidoService, atMost(10)).update(pedido);
	}

	@Test
	public void finalizarTest() {
		verify(pedidoService, atMost(10)).finalizar(pedido);
	}

	@Test
	public void FindPedidoCompletoByIdTest() {
		Mockito.lenient().when(pedidoService.findPedidoCompletoById(pedido.getId())).thenReturn(pedido);
		verify(pedidoService, atMost(10)).findPedidoCompletoById(pedido.getId());
	}

}
