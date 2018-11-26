package br.com.emmanuelneri.monolitica.ItemPedido;

import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.emmanuelneri.monolitica.model.ItemPedido;
import br.com.emmanuelneri.monolitica.model.Veiculo;
import br.com.emmanuelneri.monolitica.service.ItemPedidoService;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class ItemPedidoServiceUnitTest {
	
	@Mock ItemPedido itemPedido;
	@Mock ItemPedidoService itemPedidoService;
	@Mock Veiculo veiculo;
	
	ArrayList<ItemPedido> itens;
	
	@Before
	public void setup() {
		itens = new ArrayList<ItemPedido>();
		itens.add(new ItemPedido(new BigDecimal("10"), 4, veiculo));
		itens.add(new ItemPedido(new BigDecimal("11"), 5, veiculo));
		itens.add(new ItemPedido(new BigDecimal("12"), 6, veiculo));
		itens.add(new ItemPedido(new BigDecimal("13"), 7, veiculo));
	}
	
	
	@Test
	public void TestarSalvarItemPedido() {
		ItemPedido item = mock(ItemPedido.class);
		
		doNothing().when(itemPedidoService).save(item);
		itemPedidoService.save(item);
		
		verify(itemPedidoService, times(1)).save(item);
	}
	
	@Test
	public void TestarGetters() {
		ItemPedido item = itens.get(0);
		
		int qtd = item.getQuantidade();
		BigDecimal v_unitario = item.getValorUnitario();
		BigDecimal v_total = item.getValorTotal();
		Veiculo veiculo = item.getVeiculo();
		
		doNothing().when(itemPedidoService).save(itemPedido);
		itemPedidoService.save(new ItemPedido(v_unitario.add(v_total), qtd+1, veiculo));
		
		verify(itemPedidoService, times(1)).save(new ItemPedido(v_unitario.add(v_total), qtd+1, veiculo));
	
		
		
	}
	
	@Test
	public void TestarBuscarItemPedido() {
		Mockito.when(itemPedidoService.findById((long) 1)).thenReturn(itens.get(0));
		assertEquals(itemPedidoService.findById((long) 1), itens.get(0));
	}
	
	@Test
	public void TestarFindAllNaoNulo() {
		Mockito.when(itemPedidoService.findAll()).thenReturn(itens);
		assertNotNull(itemPedidoService.findAll());
	}
}
