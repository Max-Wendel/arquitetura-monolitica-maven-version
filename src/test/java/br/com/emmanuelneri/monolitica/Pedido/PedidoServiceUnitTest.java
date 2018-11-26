package br.com.emmanuelneri.monolitica.Pedido;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
public class PedidoUnitTests {

	@Mock
	Pedido pedido;
	@Mock
	PedidoService pedidoService;
	@Mock
	Usuario usuario;

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
		Mockito.doNothing().when(pedidoService).salvar(pedido);

		pedidoService.salvar(pedido);

		verify(pedidoService, times(1)).salvar(pedido);
	}

	@Test
	public void TestarSave() throws ValidationException {
		Mockito.doNothing().when(pedidoService).save(pedido);

		pedidoService.save(pedido);

		verify(pedidoService, times(1)).save(pedido);
	}

	@Test
	public void findPedidoCompletoByIdTest() throws ValidationException {
		Mockito.lenient().when(pedidoService.findById((long) 2)).thenReturn(pedidos.get(1));
		verify(pedidoService, atMost(10)).update(pedido);
	}

	@Test
	public void finalizarTest() {
		Mockito.doNothing().when(pedidoService).finalizar(pedidos.get(1));

		pedidoService.finalizar(pedidos.get(1));

		verify(pedidoService, atMost(10)).finalizar(pedidos.get(1));
	}

	@Test
	public void FindPedidoCompletoByIdTest() {
		Mockito.lenient().when(pedidoService.findPedidoCompletoById(pedido.getId())).thenReturn(pedido);
		verify(pedidoService, atMost(10)).findPedidoCompletoById(pedido.getId());
	}

	@Test
	public void TestaFindAllNaoNulo() {
		Mockito.lenient().when(pedidoService.findAll()).thenReturn(pedidos);
		assertNotNull(pedidoService.findAll());
	}

	public void TestaAlgo() {

	}

}
