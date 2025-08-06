/*
package com.solance.web;
import org.junit.jupiter.api.Test; // 唯一使用的Test注解
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solance.dto.PaymentRequest;
import com.solance.service.WorkflowService;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static reactor.core.publisher.Mono.when;

@WebMvcTest(WorkflowController.class)
public class WorkflowControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private WorkflowService workflowService;

    @Test
    void processPayment_success() throws Exception {
        PaymentRequest request = new PaymentRequest();
        request.setSourceIban("TEST123");
        request.setAmountSell(BigDecimal.valueOf(100.00));

        when(workflowService.processPayment(any(PaymentRequest.class)))
                .thenReturn(TestData.createMockTransaction());

        mockMvc.perform(post("/api/workflow/payment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }
}*/

