package ca.dss.csd.cct.project.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;


@Document(collection = "users")
public class MongoUser {

    @MongoId
    private ObjectId id;
    @Indexed(unique = true)
    @NotBlank(message = "Please, provide user name")
    private String username;
    @NotBlank(message = "Please, provide a password")
    private String password;
    private Set<GrantedAuthority> roles;

    public MongoUser() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Set<GrantedAuthority> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof MongoUser)) {
            return false;
        }
        MongoUser user = (MongoUser) obj;
        return user.getUsername().equals(this.username);
    }
}
