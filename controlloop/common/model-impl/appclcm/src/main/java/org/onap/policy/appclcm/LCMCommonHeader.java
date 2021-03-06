/*-
 * ============LICENSE_START=======================================================
 * appclcm
 * ================================================================================
 * Copyright (C) 2017 AT&T Intellectual Property. All rights reserved.
 * ================================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ============LICENSE_END=========================================================
 */

package org.onap.policy.appclcm;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.google.gson.annotations.SerializedName;

public class LCMCommonHeader implements Serializable {

    private static final long serialVersionUID = 6581963539127062114L;

    @SerializedName(value="timestamp")
    private Instant timeStamp = Instant.now();

    @SerializedName(value="api-ver")
    private String apiVer="2.00";

    @SerializedName(value="originator-id")
    private String originatorId;

    @SerializedName(value="request-id")
    private UUID requestId;

    @SerializedName(value="sub-request-id")
    private String subRequestId;

    @SerializedName(value="flags")
    private Map<String, String> flags = new HashMap<>();

    public LCMCommonHeader() {

    }

    /**
     * Used to copy a common header.
     * 
     * @param commonHeader
     *            a header that is defined by the lcm api guide that contains
     *            information about the request (requestId, flags, etc.)
     */
    public LCMCommonHeader(LCMCommonHeader commonHeader) {
        this.originatorId = commonHeader.originatorId;
        this.requestId = commonHeader.requestId;
        this.subRequestId = commonHeader.subRequestId;
        if (commonHeader.flags != null) {
            this.flags.putAll(commonHeader.flags);
        }
    }  

    /**
     * @return the timeStamp
     */
    public Instant getTimeStamp() {
        return timeStamp;
    }

    /**
     * @param timeStamp the timeStamp to set
     */
    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * @return the apiVer
     */
    public String getApiVer() {
        return apiVer;
    }

    /**
     * @param apiVer the apiVer to set
     */
    public void setApiVer(String apiVer) {
        this.apiVer = apiVer;
    }

    /**
     * @return the originatorId
     */
    public String getOriginatorId() {
        return originatorId;
    }

    /**
     * @param originatorId the originatorId to set
     */
    public void setOriginatorId(String originatorId) {
        this.originatorId = originatorId;
    }

    /**
     * @return the requestId
     */
    public UUID getRequestId() {
        return requestId;
    }

    /**
     * @param requestId the requestId to set
     */
    public void setRequestId(UUID requestId) {
        this.requestId = requestId;
    }

    /**
     * @return the subRequestId
     */
    public String getSubRequestId() {
        return subRequestId;
    }

    /**
     * @param subRequestId the subRequestId to set
     */
    public void setSubRequestId(String subRequestId) {
        this.subRequestId = subRequestId;
    }

    /**
     * @return the flags
     */
    public Map<String, String> getFlags() {
        return flags;
    }

    /**
     * @param flags the flags to set
     */
    public void setFlags(Map<String, String> flags) {
        this.flags = flags;
    }

    @Override
    public String toString() {
        return "CommonHeader [timeStamp=" + timeStamp + ", apiVer=" + apiVer + ", originatorId=" + originatorId
                + ", requestId=" + requestId + ", subRequestId=" + subRequestId + ", flags=" + flags + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((apiVer == null) ? 0 : apiVer.hashCode());
        result = prime * result + ((flags == null) ? 0 : flags.hashCode());
        result = prime * result + ((originatorId == null) ? 0 : originatorId.hashCode());
        result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
        result = prime * result + ((subRequestId == null) ? 0 : subRequestId.hashCode());
        result = prime * result + ((timeStamp == null) ? 0 : timeStamp.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        LCMCommonHeader other = (LCMCommonHeader) obj;
        if (apiVer == null) {
            if (other.apiVer != null) {
                return false;
            }
        } else if (!apiVer.equals(other.apiVer)) {
            return false;
        }
        if (flags == null) {
            if (other.flags != null) {
                return false;
            }
        } else if (!flags.equals(other.flags)) {
            return false;
        }
        if (originatorId == null) {
            if (other.originatorId != null) {
                return false;
            }
        } else if (!originatorId.equals(other.originatorId)) {
            return false;
        }
        if (requestId == null) {
            if (other.requestId != null) {
                return false;
            }
        } else if (!requestId.equals(other.requestId)) {
            return false;
        }
        if (subRequestId == null) {
            if (other.subRequestId != null) {
                return false;
            }
        } else if (!subRequestId.equals(other.subRequestId)) {
            return false;
        }
        if (timeStamp == null) {
            if (other.timeStamp != null) {
                return false;
            }
        } else if (!timeStamp.equals(other.timeStamp)) {
            return false;
        }
        return true;
    }

}
