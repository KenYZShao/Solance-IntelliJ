package com.solance.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solance.domain.PaymentInstruction;
import com.solance.domain.Transaction;
import com.solance.domain.TransactionStatus;
import com.solance.dto.PaymentRequest;
import com.solance.service.WorkflowService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WorkflowController.class)
public class WorkflowControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private WorkflowService workflowService;

    @Test
    void createPayment_success() throws Exception {
        // 1. 准备测试请求
        PaymentRequest request = new PaymentRequest();
        request.setSourceIban("FR7630006000011234567890189");
        request.setAmountSell(new BigDecimal("1000.00"));
        // ...设置其他必要字段

        // 2. 模拟服务层行为
        when(workflowService.processPayment(any(PaymentRequest.class)))
                .thenReturn(createMockTransaction());

        // 3. 执行并验证请求
        mockMvc.perform(post("/api/workflow/payment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("PROCESSED"));
    }

    private Transaction createMockTransaction() {
        // 创建并返回模拟的交易对象
        PaymentInstruction payment = new PaymentInstruction();
        payment.setId(1L);
        payment.setStatus(TransactionStatus.PROCESSED);
        // ...设置其他必要字段
        return payment;
    }
}