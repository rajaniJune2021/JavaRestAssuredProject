package Response.LoginMembership;

import com.fasterxml.jackson.annotation.*;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "access_token",
            "token_type",
            "scope",
            "id_token",
            "refresh_token",
            "email",
            "userName",
            "memberNumber",
            "customerId",
            "memberZipCode",
            "lastName",
            "firstName",
            "clubCode",
            "status",
            "statusMessage",
            "expires_in"
    })

    public class LoginMembership {

        @JsonProperty("access_token")
        private String accessToken;
        @JsonProperty("token_type")
        private String tokenType;
        @JsonProperty("scope")
        private String scope;
        @JsonProperty("id_token")
        private String idToken;
        @JsonProperty("refresh_token")
        private String refreshToken;
        @JsonProperty("email")
        private String email;
        @JsonProperty("userName")
        private String userName;
        @JsonProperty("memberNumber")
        private String memberNumber;
        @JsonProperty("customerId")
        private String customerId;
        @JsonProperty("memberZipCode")
        private String memberZipCode;
        @JsonProperty("lastName")
        private String lastName;
        @JsonProperty("firstName")
        private String firstName;
        @JsonProperty("clubCode")
        private String clubCode;
        @JsonProperty("status")
        private String status;
        @JsonProperty("statusMessage")
        private String statusMessage;
        @JsonProperty("expires_in")
        private String expiresIn;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("access_token")
        public String getAccessToken() {
            return accessToken;
        }

        @JsonProperty("access_token")
        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        @JsonProperty("token_type")
        public String getTokenType() {
            return tokenType;
        }

        @JsonProperty("token_type")
        public void setTokenType(String tokenType) {
            this.tokenType = tokenType;
        }

        @JsonProperty("scope")
        public String getScope() {
            return scope;
        }

        @JsonProperty("scope")
        public void setScope(String scope) {
            this.scope = scope;
        }

        @JsonProperty("id_token")
        public String getIdToken() {
            return idToken;
        }

        @JsonProperty("id_token")
        public void setIdToken(String idToken) {
            this.idToken = idToken;
        }

        @JsonProperty("refresh_token")
        public String getRefreshToken() {
            return refreshToken;
        }

        @JsonProperty("refresh_token")
        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        @JsonProperty("email")
        public String getEmail() {
            return email;
        }

        @JsonProperty("email")
        public void setEmail(String email) {
            this.email = email;
        }

        @JsonProperty("userName")
        public String getUserName() {
            return userName;
        }

        @JsonProperty("userName")
        public void setUserName(String userName) {
            this.userName = userName;
        }

        @JsonProperty("memberNumber")
        public String getMemberNumber() {
            return memberNumber;
        }

        @JsonProperty("memberNumber")
        public void setMemberNumber(String memberNumber) {
            this.memberNumber = memberNumber;
        }

        @JsonProperty("customerId")
        public String getCustomerId() {
            return customerId;
        }

        @JsonProperty("customerId")
        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        @JsonProperty("memberZipCode")
        public String getMemberZipCode() {
            return memberZipCode;
        }

        @JsonProperty("memberZipCode")
        public void setMemberZipCode(String memberZipCode) {
            this.memberZipCode = memberZipCode;
        }

        @JsonProperty("lastName")
        public String getLastName() {
            return lastName;
        }

        @JsonProperty("lastName")
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @JsonProperty("firstName")
        public String getFirstName() {
            return firstName;
        }

        @JsonProperty("firstName")
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        @JsonProperty("clubCode")
        public String getClubCode() {
            return clubCode;
        }

        @JsonProperty("clubCode")
        public void setClubCode(String clubCode) {
            this.clubCode = clubCode;
        }

        @JsonProperty("status")
        public String getStatus() {
            return status;
        }

        @JsonProperty("status")
        public void setStatus(String status) {
            this.status = status;
        }

        @JsonProperty("statusMessage")
        public String getStatusMessage() {
            return statusMessage;
        }

        @JsonProperty("statusMessage")
        public void setStatusMessage(String statusMessage) {
            this.statusMessage = statusMessage;
        }

        @JsonProperty("expires_in")
        public String getExpiresIn() {
            return expiresIn;
        }

        @JsonProperty("expires_in")
        public void setExpiresIn(String expiresIn) {
            this.expiresIn = expiresIn;
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
