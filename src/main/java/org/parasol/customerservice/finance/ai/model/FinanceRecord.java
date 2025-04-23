package org.parasol.customerservice.finance.ai.model;

import io.vertx.core.json.JsonObject;

import java.math.BigDecimal;
import java.time.LocalDate;

public record FinanceRecord(int id, String customer, LocalDate orderDate, LocalDate shippedDate, String status, BigDecimal value) {

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.put("id", id);
        json.put("customer_id", customer);
        json.put("order_date", orderDate);
        json.put("shipped_date", shippedDate);
        json.put("status", status);
        json.put("value", value);
        return json;
    }
}
