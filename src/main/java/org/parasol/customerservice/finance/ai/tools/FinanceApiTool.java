package org.parasol.customerservice.finance.ai.tools;

import dev.langchain4j.agent.tool.Tool;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.parasol.customerservice.finance.ai.model.FinanceRecord;
import org.parasol.customerservice.finance.ai.service.FinanceApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@ApplicationScoped
public class FinanceApiTool {

    private static final Logger LOGGER = LoggerFactory.getLogger(FinanceApiTool.class);

    @RestClient
    FinanceApiService financeApiService;

    @Tool(name = "getOrderHistory", value = "Retrieve a customer's order history based on their customer id.")
    public List<FinanceRecord> getOrderHistory(String customerId) {
        LOGGER.info("getOrderHistory Tool invoked for customerId {}", customerId);
        return financeApiService.financialRecords(customerId);
    }

    @Tool(name = "getInvoiceHistory", value = "Retrieve a customer's invoice history based on their customer id.")
    public List<FinanceRecord> getInvoiceHistory(String customerId) {
        LOGGER.info("getInvoiceHistory Tool invoked for customerId {}", customerId);
        return financeApiService.financialRecords(customerId);
    }

    @Tool(name = "startDuplicateChargeDispute", value = "Start the process to dispute a duplicate charge for a customer.")
    public List<FinanceRecord> startDuplicateChargeDispute(String customerId) {
        LOGGER.info("startDuplicateChargeDispute Tool invoked for customerId {}", customerId);
        return financeApiService.financialRecords(customerId);
    }

    @Tool(name = "findMissingReceipt", value = "Start the process to find a lost receipt for a customer.")
    public List<FinanceRecord> findMissingReceipt(String customerId) {
        LOGGER.info("findMissingReceipt Tool invoked for customerId {}", customerId);
        return financeApiService.financialRecords(customerId);
    }
}
