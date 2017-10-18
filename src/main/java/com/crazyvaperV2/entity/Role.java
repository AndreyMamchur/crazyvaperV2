package com.crazyvaperV2.entity;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;

    @ManyToOne(optional=false)
    @JoinColumn(name="email",referencedColumnName="email", insertable = false, updatable = false)
    private User user;

    @Column(name = "roleEnum")
    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum = RoleEnum.ROLE_USER;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RoleEnum getRoleEnum() {
        return roleEnum;
    }

    public void setRoleEnum(RoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }
}
