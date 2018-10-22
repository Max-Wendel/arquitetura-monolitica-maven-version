package br.com.emmanuelneri.monolitica.util.anotations;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.FIELD;


@Qualifier
@Retention(RUNTIME)
@Target({METHOD, TYPE, FIELD})
public @interface UsuarioLogado {
}