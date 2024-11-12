package com.mini.tutorial.mockito.service;

import com.mini.tutorial.mockito.entity.Autor;
import com.mini.tutorial.mockito.repository.AutorRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // Habilita Mockito para trabajar con JUnit 5
public class AutorServiceTest {

    @Mock
    AutorRepository autorRepository; // Mock del repositorio para simular interacciones con la base de datos

    @InjectMocks
    AutorService autorService; // Instancia del servicio bajo prueba, con dependencias mockeadas inyectadas

    @Test
    void testGuardarAutor() {
        // Creamos un objeto Autor para ser guardado
        Autor autor = new Autor();
        autor.setNombre("Juan Rulfo");
        autor.setEmail("jrulfo@servidor.com");

        // Configuramos el mock para que devuelva el autor cuando se llame al método save
        // cuando (algo sea invocado) vas a regresar (esto de aquí)
        when(autorRepository.save(any(Autor.class))).thenReturn(autor);

        // Llamamos al método guardar del servicio y capturamos el resultado
        Autor resultado = autorService.guardar(autor);

        // Verificamos que el resultado sea igual al autor original
        assertEquals("Juan Rulfo", resultado.getNombre());

        // Verificamos que el método save del repositorio fue llamado una vez con el autor dado
        verify(autorRepository, times(1)).save(autor);
    }

    @Test
    void testObtenerTodos() {
        // Configuramos el mock para que devuelva una lista vacía cuando se llame a findAll
        when(autorRepository.findAll()).thenReturn(Collections.emptyList());

        // Llamamos al método obtenerTodos del servicio y verificamos que la lista esté vacía
        List<Autor> autorList = autorService.obtenerTodos();
        assertTrue(autorList.isEmpty());

        // Verificamos que el método findAll del repositorio fue llamado una vez
        verify(autorRepository, times(1)).findAll();
    }

    @Test
    void testEliminarAutor() throws Exception {
        // Configuramos el mock para que no haga nada al llamar a deleteById
        doNothing().when(autorRepository).deleteById(anyLong());

        // Llamamos al método eliminar del servicio con un ID específico
        autorService.eliminar(1L);

        // Verificamos que el método deleteById fue llamado una vez con el ID proporcionado
        verify(autorRepository, times(1)).deleteById(1L);
    }

    @Test
    void testEliminarAutorConExcepcion() {
        // Configuramos el mock para que lance una excepción cuando se llame a deleteById
        doThrow(new RuntimeException("ID inválido para eliminación")).when(autorRepository).deleteById(1L);

        // Verificamos que la excepción se lanza al llamar el método para eliminar
        RuntimeException exception = assertThrows(RuntimeException.class, () -> autorService.eliminar(1L));
        assertEquals("ID inválido para eliminación", exception.getMessage());

        // Verificamos que el método deleteById fue llamado solo una vez con el ID recibido
        verify(autorRepository, times(1)).deleteById(1L);
    }

    @Test
    void testEliminarAutorConExcepcionPorValidacion() {
        // Verificamos que la excepción se lanza al llamar el método para eliminar con un ID inválido
        RuntimeException exception = assertThrows(RuntimeException.class, () -> autorService.eliminar(-1L));
        assertEquals("ID inválido para eliminación", exception.getMessage());

        // Verificamos que el método deleteById fue llamado solo una vez con el ID recibido
        verify(autorRepository, never()).deleteById(-1L);
    }
}

