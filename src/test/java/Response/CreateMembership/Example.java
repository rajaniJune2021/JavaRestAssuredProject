package Response.CreateMembership;


import Response.ErrorDetails;
import com.fasterxml.jackson.annotation.*;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "isRegistrationSuccessful",
        "errorDetails"
})

public class Example {

    @JsonProperty("isRegistrationSuccessful")
    private Boolean isRegistrationSuccessful;
    @JsonProperty("errorDetails")
    private ErrorDetails errorDetails;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("isRegistrationSuccessful")
    public Boolean getIsRegistrationSuccessful() {
        return isRegistrationSuccessful;
    }

    @JsonProperty("isRegistrationSuccessful")
    public void setIsRegistrationSuccessful(Boolean isRegistrationSuccessful) {
        this.isRegistrationSuccessful = isRegistrationSuccessful;
    }

    @JsonProperty("errorDetails")
    public ErrorDetails getErrorDetails() {
        return errorDetails;
    }

    @JsonProperty("errorDetails")
    public void setErrorDetails(ErrorDetails errorDetails) {
        this.errorDetails = errorDetails;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
