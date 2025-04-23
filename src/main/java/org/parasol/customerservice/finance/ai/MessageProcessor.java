package org.parasol.customerservice.finance.ai;

import dev.langchain4j.service.Result;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.parasol.customerservice.finance.ai.model.FinanceRequestResponse;
import org.parasol.customerservice.finance.ai.model.FinanceRequestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class MessageProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageProcessor.class);

    @Inject
    FinanceAssistant financeAssistant;

    public FinanceRequestResponse process(String message) {
        Result<FinanceRequestResult> result = financeAssistant.handleRequest(message);
        FinanceRequestResult records = result.content();
        return new FinanceRequestResponse(records);
    }
}
