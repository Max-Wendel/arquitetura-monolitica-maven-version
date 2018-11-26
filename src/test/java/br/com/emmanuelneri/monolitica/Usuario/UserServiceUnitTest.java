package br.com.emmanuelneri.monolitica.Usuario;

import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;

import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.emmanuelneri.monolitica.model.Usuario;
import br.com.emmanuelneri.monolitica.service.UsuarioService;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class UserServiceUnitTest{
	
    @Mock UsuarioService usuarioService;
    @Mock Usuario usuario;
    
    ArrayList<Usuario> usuarios;
    
    @Before
    public void setup() {
    	usuarios = new ArrayList<Usuario>();
    	
    	usuario.setEmail("abc@abc.com");
		usuario.setSenha("abc123");
		usuarios.add(usuario);
		
    	usuario.setEmail("email@email.com");
		usuario.setSenha("email");
		usuarios.add(usuario);
    	
		usuario.setEmail("baba@baba.com");
		usuario.setSenha("bababa");
		usuarios.add(usuario);
		
		usuario.setEmail("max@email.com");
		usuario.setSenha("mimimi");
    	usuarios.add(usuario);
    }
    
    
    @Test
    public void testaBuscarPorLogin() {
    	Mockito.lenient().when(usuarioService.buscaParaLogin("max@email.com")).thenReturn(usuarios.get(3));
    	assertTrue(usuarioService.buscaParaLogin("max@email.com").equals(usuarios.get(3)));
    }
    
    @Test
    public void testaSalvarUsuario() {
    	usuario.setEmail("mel@mel.com");
		usuario.setSenha("mel");
		
    	doNothing().when(usuarioService).save(usuario);
    	usuarioService.save(usuario);
    	
    	verify(usuarioService).save(usuario);
    }
    
    @Test
    public void testaAlterarUsuario() {
    	Usuario teste = usuarios.get(1);
    	teste.setEmail(teste.getEmail()+".br");
    	teste.setSenha(teste.getId()+teste.getSenha()+"==");
    	
    	doNothing().when(usuarioService).update(teste);
    	usuarioService.update(teste);
    	
    	verify(usuarioService).update(teste);
    }
    
    
    
    
    
}