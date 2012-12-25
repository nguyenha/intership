package com.home.qh.model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * This class is used to represent the Common Code with CodeId and description.
 * @author Quynh Nguyen
 */
@Entity
@Table(name = "ccode")
public class CommonCode extends BaseObject implements Serializable {
    private static final Log log = LogFactory.getLog(CommonCode.class);
    private CodeId id;
    private String description;
    private static final long serialVersionUID = -1393312947037639590L;

    @EmbeddedId
    public CodeId getId() {
        return id;
    }

    public void setId(CodeId id) {
        this.id = id;
    }
    @Column(length = 250)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommonCode that = (CommonCode) o;

        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CommonCode");
        sb.append("{id = ").append((id != null) ? id : "").append('\n');
        sb.append("description = ").append((description != null) ? description : "");
        sb.append('}');
        return sb.toString();
    }
}
