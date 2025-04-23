package org.parasol.customerservice.finance.ai.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.parasol.customerservice.finance.ai.model.FinanceRecord;

import java.util.List;

@RegisterRestClient(configKey = "finance")
@Path("/finance/v1")
public interface FinanceApiService {

    @GET
    @Path("/record/{customerId}")
    List<FinanceRecord> financialRecords(@PathParam("customerId") String customerId);

}
