package org.parasol.customerservice.finance.ai.model;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public record FinanceRequestResponse(FinanceRequestResult result) {

    public boolean toolInvoked() {
        if (result == null) {
            return false;
        }
        return result.tools() != null && !result.tools().isEmpty();
    }

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        if (toolInvoked()) {
            json.put("toolinvoked", true);
            json.put("tools", new JsonArray(result.tools()));
            json.put("result", result.toJson());
        } else {
            json.put("toolinvoked", false);
        }
        return json;
    }

}
