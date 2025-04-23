package org.parasol.customerservice.finance.ai.model;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.List;

public record FinanceRequestResult(List<String> tools, List<FinanceRecord> records) {

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        if (records != null) {
            JsonArray recordArray = new JsonArray();
            records.stream().map(FinanceRecord::toJson).forEach(recordArray::add);
            json.put("records", recordArray);
        }
        return json;
    }
}
