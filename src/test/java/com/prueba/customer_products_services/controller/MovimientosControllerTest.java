package com.prueba.customer_products_services.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.customer_products_services.repository.entity.Cuenta;
import com.prueba.customer_products_services.repository.entity.Movimientos;
import com.prueba.customer_products_services.service.MovimientosService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

public class MovimientosControllerTest {

    private MockMvc mockMvc;

    @Mock
    private MovimientosService movimientosService;

    @Mock
    private RabbitTemplate rabbitTemplate;

    @InjectMocks
    private MovimientosController movimientosController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(movimientosController).build();
    }

    @Test
    public void testCreate() throws Exception {
        Movimientos movimientos = new Movimientos();
        movimientos.setCuenta(new Cuenta());
        movimientos.getCuenta().setCuentaId(1L);
        movimientos.setSaldo(new BigDecimal(1000));

        when(movimientosService.save(any(Movimientos.class))).thenReturn(movimientos);

        mockMvc.perform(MockMvcRequestBuilders.post("/movimientos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(movimientos)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.saldo").value(1000));

        verify(rabbitTemplate, times(1)).convertAndSend(eq("myQueue"), any(Movimientos.class));
    }

    @Test
    public void testUpdate() throws Exception {
        Movimientos movimientos = new Movimientos();
        movimientos.setMovimientoId(1L);
        movimientos.setCuenta(new Cuenta());
        movimientos.getCuenta().setCuentaId(1L);
        movimientos.setSaldo(new BigDecimal(2000));

        when(movimientosService.update(any(Movimientos.class))).thenReturn(movimientos);

        mockMvc.perform(MockMvcRequestBuilders.put("/movimientos/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(movimientos)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.saldo").value(2000));
    }

    @Test
    public void testDelete() throws Exception {
        doNothing().when(movimientosService).delete(1L);

        mockMvc.perform(MockMvcRequestBuilders.delete("/movimientos/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(movimientosService, times(1)).delete(1L);
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
