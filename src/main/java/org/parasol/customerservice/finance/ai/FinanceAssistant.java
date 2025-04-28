package org.parasol.customerservice.finance.ai;

import dev.langchain4j.service.Result;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.enterprise.context.ApplicationScoped;
import org.parasol.customerservice.finance.ai.model.FinanceRequestResult;

@RegisterAiService()
@ApplicationScoped
public interface FinanceAssistant {

    @SystemMessage("You are an expert tool calling, review the user message and call the best matching tool")
    @UserMessage("""
            This is the user request. It contains the customerId and the user request. If you called a tool, add the function name to the response.
            Request: {request}
            """)
    Result<FinanceRequestResult> handleRequest(String request);

}
