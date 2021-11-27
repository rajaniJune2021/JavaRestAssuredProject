package Response.GetListOfPolicies;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "policyType",
        "policySubType",
        "policyNumber",
        "effectiveDate",
        "expirationDate",
        "authorizedToViewDetails",
        "authorizedPolicyActions",
        "serviceSolution"
})

public class InsurancePolicy {

    @JsonProperty("policyType")
    private String policyType;
    @JsonProperty("policySubType")
    private String policySubType;
    @JsonProperty("policyNumber")
    private String policyNumber;
    @JsonProperty("effectiveDate")
    private String effectiveDate;
    @JsonProperty("expirationDate")
    private String expirationDate;
    @JsonProperty("authorizedToViewDetails")
    private Boolean authorizedToViewDetails;
    @JsonProperty("authorizedPolicyActions")
    private List<String> authorizedPolicyActions = null;
    @JsonProperty("serviceSolution")
    private String serviceSolution;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("policyType")
    public String getPolicyType() {
        return policyType;
    }

    @JsonProperty("policyType")
    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    @JsonProperty("policySubType")
    public String getPolicySubType() {
        return policySubType;
    }

    @JsonProperty("policySubType")
    public void setPolicySubType(String policySubType) {
        this.policySubType = policySubType;
    }

    @JsonProperty("policyNumber")
    public String getPolicyNumber() {
        return policyNumber;
    }

    @JsonProperty("policyNumber")
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    @JsonProperty("effectiveDate")
    public String getEffectiveDate() {
        return effectiveDate;
    }

    @JsonProperty("effectiveDate")
    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @JsonProperty("expirationDate")
    public String getExpirationDate() {
        return expirationDate;
    }

    @JsonProperty("expirationDate")
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @JsonProperty("authorizedToViewDetails")
    public Boolean getAuthorizedToViewDetails() {
        return authorizedToViewDetails;
    }

    @JsonProperty("authorizedToViewDetails")
    public void setAuthorizedToViewDetails(Boolean authorizedToViewDetails) {
        this.authorizedToViewDetails = authorizedToViewDetails;
    }

    @JsonProperty("authorizedPolicyActions")
    public List<String> getAuthorizedPolicyActions() {
        return authorizedPolicyActions;
    }

    @JsonProperty("authorizedPolicyActions")
    public void setAuthorizedPolicyActions(List<String> authorizedPolicyActions) {
        this.authorizedPolicyActions = authorizedPolicyActions;
    }

    @JsonProperty("serviceSolution")
    public String getServiceSolution() {
        return serviceSolution;
    }

    @JsonProperty("serviceSolution")
    public void setServiceSolution(String serviceSolution) {
        this.serviceSolution = serviceSolution;
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
