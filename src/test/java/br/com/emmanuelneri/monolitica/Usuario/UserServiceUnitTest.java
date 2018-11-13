package br.com.emmanuelneri.monolitica.Usuario;

import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.emmanuelneri.monolitica.model.Usuario;
import br.com.emmanuelneri.monolitica.service.UsuarioService;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class UserServiceUnitTest{
	
    @Mock UsuarioService usuarioService;
    @Mock Usuario usuario;
    
    @Test
    public void testaCadastrarUsuario() {
    	usuarioService.save(usuario);
    	when(usuarioService.buscaParaLogin(usuario.getEmail())).thenReturn(usuario);
    	verify(usuarioService, atMost(10)).save(usuario);
    }
    
    
    
}