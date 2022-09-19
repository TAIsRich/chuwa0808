package com.example.demo.entity.security;
import com.example.demo.entity.Transaction;

import javax.persistence.*;
import javax.persistence.UniqueConstraint;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"})
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;

    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL)
    List<Transaction> transactionList;

    public List<Transaction> getTransactionList() {
        return transactionList;
    }


    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public User(long id, String name, String password, Set<Role> roles, List<Transaction> transactionList) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.roles = roles;
        this.transactionList = transactionList;
    }

    public User() {
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
