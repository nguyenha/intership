package com.home.qh.model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.annotations.Index;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * This class is used to represent the Code Id with groupID and code information.
 * @author Quynh Nguyen
 */
@Embeddable
public class CodeId implements Serializable {
    private static final Log log = LogFactory.getLog(CodeId.class);
    private String groupId;
    private String code;
    private static final long serialVersionUID = -8171654605396444321L;
    
    @Column(length = 50)
    @Index(name="idx_ccode_groupId")
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Column(length = 10)
    @Index(name="idx_ccode_code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CodeId codeId = (CodeId) o;

        if (code != null ? !code.equals(codeId.code) : codeId.code != null) return false;
        if (groupId != null ? !groupId.equals(codeId.groupId) : codeId.groupId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupId != null ? groupId.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CodeId");
        sb.append("{groupId = ").append((groupId != null) ? groupId : "").append('\n');
        sb.append("code = ").append((code != null) ? code : "");
        sb.append('}');
        return sb.toString();
    }
}
