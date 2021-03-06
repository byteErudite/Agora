package com.vaibhav.Agora.Entities;

import com.vaibhav.Agora.Common.Constants.AssignedRole;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "role")
public class Role extends BaseEntity  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    private UUID roleId;

    @Enumerated(EnumType.STRING)
    private AssignedRole role;

    public Role() {
    }

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public AssignedRole getRole() {
        return role;
    }

    public void setRole(AssignedRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Role{");
        sb.append("roleId=").append(roleId);
        sb.append(", role=").append(role);
        sb.append('}');
        return sb.toString();
    }
}
