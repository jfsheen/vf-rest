package cc.aisc.commons.base;

import cc.aisc.commons.type.ValuedEnum;

import javax.persistence.MappedSuperclass;

/**
 * Created by sjf on 16-10-25.
 */
@Deprecated
@MappedSuperclass
public abstract class CommonTreeNodeWithStatus<E extends ValuedEnum>  extends CommonTreeNode {
    private E status;

    public CommonTreeNodeWithStatus() {
    }

    public E getStatus() {
        return status;
    }

    public void setStatus(E status) {
        this.status = status;
    }
}
