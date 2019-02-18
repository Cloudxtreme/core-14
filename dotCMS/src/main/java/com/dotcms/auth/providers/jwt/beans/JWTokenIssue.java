package com.dotcms.auth.providers.jwt.beans;

import java.io.Serializable;
import java.net.InetAddress;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.annotation.Generated;
import javax.annotation.Nonnull;

import com.dotcms.repackage.org.apache.commons.net.util.SubnetUtils;
import com.dotmarketing.business.DotStateException;
import com.dotmarketing.util.Logger;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Encapsulates all the different pieces of information make up an 
 * 
 * @author jsanca
 * @version 3.7
 * @since Jun 14, 2016
 */

@JsonDeserialize(builder = JWTokenIssue.Builder.class)
public class JWTokenIssue implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public final String id;
    public final String userId;
    public final String requestingUserId;
    public final String requestingIp;
    public final Date expires;
    public final Date revoked;
    public final String allowFromNetwork;
    public final Date issueDate;
    public final String metaData;
    public final String clusterId;
    public final Date modDate;


    @Generated("SparkTools")
    private JWTokenIssue(Builder builder) {
        this.id = builder.id;
        this.userId = builder.userId;
        this.requestingUserId = builder.requestingUserId;
        this.requestingIp = builder.requestFromIp;
        this.expires = builder.expires;
        this.revoked = builder.revoked;

        this.allowFromNetwork = builder.allowFromNetwork;
        this.issueDate = builder.issueDate;
        this.metaData = builder.metaData;
        this.modDate = builder.modDate;
        this.clusterId = builder.clusterId;
    }


    public boolean isValid() {
        return isValid(null);
    }
    
    public boolean isValid(final String ipAddress) {
        
        if(this.revoked!=null && this.revoked.before(new Date())){
            return false;
        }
        if(this.expires!=null && this.expires.before(new Date())){
            return false;
        }
        if(this.id==null || 
                this.userId==null){
            return false;
        }
        
        if(this.issueDate!=null && this.issueDate.after(new Date())){
            return false;
        }


        if(ipAddress==null || this.allowFromNetwork==null || this.allowFromNetwork.startsWith("0.0.0.0")) {
          return true;
        }
        try {
            if(!new SubnetUtils(this.allowFromNetwork).getInfo().isInRange(ipAddress)) {
                Logger.warn(this.getClass(), "unable to validate ip address :" + ipAddress + " was part of network " + this.allowFromNetwork );
                return false;
            }
        }
        catch(Exception e) {
            Logger.warn(this.getClass(), "unable to validate ip address :" + ipAddress + " was part of network " + this.allowFromNetwork );
            return false;
        }
        return true;
    }
    


        @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((allowFromNetwork == null) ? 0 : allowFromNetwork.hashCode());
        result = prime * result + ((clusterId == null) ? 0 : clusterId.hashCode());
        result = prime * result + ((expires == null) ? 0 : expires.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((issueDate == null) ? 0 : issueDate.hashCode());
        result = prime * result + ((metaData == null) ? 0 : metaData.hashCode());
        result = prime * result + ((modDate == null) ? 0 : modDate.hashCode());
        result = prime * result + ((requestingIp == null) ? 0 : requestingIp.hashCode());
        result = prime * result + ((requestingUserId == null) ? 0 : requestingUserId.hashCode());
        result = prime * result + ((revoked == null) ? 0 : revoked.hashCode());

        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        return result;
    }





    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        JWTokenIssue other = (JWTokenIssue) obj;
        if (allowFromNetwork == null) {
            if (other.allowFromNetwork != null)
                return false;
        } else if (!allowFromNetwork.equals(other.allowFromNetwork))
            return false;
        if (clusterId == null) {
            if (other.clusterId != null)
                return false;
        } else if (!clusterId.equals(other.clusterId))
            return false;
        if (expires == null) {
            if (other.expires != null)
                return false;
        } else if (!expires.equals(other.expires))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (issueDate == null) {
            if (other.issueDate != null)
                return false;
        } else if (!issueDate.equals(other.issueDate))
            return false;
        if (metaData == null) {
            if (other.metaData != null)
                return false;
        } else if (!metaData.equals(other.metaData))
            return false;
        if (requestingIp == null) {
            if (other.requestingIp != null)
                return false;
        } else if (!requestingIp.equals(other.requestingIp))
            return false;
        if (requestingUserId == null) {
            if (other.requestingUserId != null)
                return false;
        } else if (!requestingUserId.equals(other.requestingUserId))
            return false;
        if (revoked == null) {
            if (other.revoked != null)
                return false;
        } else if (!revoked.equals(other.revoked))
            return false;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        return true;
    }





        /**
         * Creates builder to build {@link JWTokenIssue}.
         * @return created builder
         */
        @Generated("SparkTools")
        public static Builder builder() {
            return new Builder();
        }


        /**
         * Creates a builder to build {@link JWTokenIssue} and initialize it with the given object.
         * @param jWTokenIssue to initialize the builder with
         * @return created builder
         */
        @Generated("SparkTools")
        public static Builder from(JWTokenIssue jWTokenIssue) {
            return new Builder(jWTokenIssue);
        }


        /**
         * Builder to build {@link JWTokenIssue}.
         */
        @Generated("SparkTools")
        public static final class Builder {
            private String id;
            private String userId;
            private String requestingUserId;
            private String requestFromIp;
            private Date expires;
            private Date revoked;
            private String allowFromNetwork;
            private Date issueDate;
            private String metaData;
            private Date modDate;
            private String clusterId;
            private Builder() {}

            private Builder(JWTokenIssue jWTokenIssue) {
                this.id = jWTokenIssue.id;
                this.userId = jWTokenIssue.userId;
                this.requestingUserId = jWTokenIssue.requestingUserId;
                this.requestFromIp = jWTokenIssue.requestingIp;
                this.expires = jWTokenIssue.expires;
                this.revoked = jWTokenIssue.revoked;
                this.allowFromNetwork = jWTokenIssue.allowFromNetwork;
                this.issueDate = jWTokenIssue.issueDate;
                this.metaData = jWTokenIssue.metaData;
                this.modDate = jWTokenIssue.modDate;
                this.clusterId=jWTokenIssue.clusterId;
            }

            public Builder withId(@Nonnull String id) {
                this.id = id;
                return this;
            }

            public Builder withUserId(@Nonnull String userId) {
                this.userId = userId;
                return this;
            }

            public Builder withRequestingUserId(@Nonnull String requestingUserId) {
                this.requestingUserId = requestingUserId;
                return this;
            }

            public Builder withRequestingIp(@Nonnull String requestFromIp) {
                this.requestFromIp = requestFromIp;
                return this;
            }

            public Builder withExpires(@Nonnull Date expires) {
                
                this.expires = expires==null ? null :Date.from(expires.toInstant().truncatedTo(ChronoUnit.SECONDS));
                return this;
            }

            public Builder withRevoked(@Nonnull Date revoked) {
                this.revoked = revoked==null ? null : Date.from(revoked.toInstant().truncatedTo(ChronoUnit.SECONDS));
                return this;
            }



            public Builder withAllowFromNetwork(@Nonnull String allowFromNetwork) {
                this.allowFromNetwork = allowFromNetwork;
                return this;
            }

            public Builder withIssueDate(@Nonnull Date issueDate) {
                this.issueDate = issueDate==null ? null :Date.from(issueDate.toInstant().truncatedTo(ChronoUnit.SECONDS));;
                return this;
            }

            public Builder withMetaData(@Nonnull String metaData) {
                this.metaData = metaData;
                return this;
            }
            public Builder withClusterId(@Nonnull String clusterId) {
                this.clusterId = clusterId;
                return this;
            }
            public Builder withModDate(@Nonnull Date modDate) {
                this.modDate =  modDate==null ? null :  Date.from(modDate.toInstant().truncatedTo(ChronoUnit.SECONDS));
                return this;
            }

            public JWTokenIssue build() {

                if (userId == null ||  expires == null) {
                    throw new DotStateException("JWTokenIsse is not valid - needs an userId, a requestingUser and an expires date");
                }


                return new JWTokenIssue(this);
            }
        }


        @Override
        public String toString() {
           
            return "{id:" + this.id + ", userId:" + this.userId + ", issueDate:" + this.issueDate+ ", expires:" + this.expires + ", revoked:" + this.revoked +"}";
        }
    
}

