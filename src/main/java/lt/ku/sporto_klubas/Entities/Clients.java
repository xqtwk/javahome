package lt.ku.sporto_klubas.Entities;

import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Entity
@Table(name = "clients")
public class Clients implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 64)
    @Length(min = 3, max = 20, message = "Vardas turi būti ilgesnis nei 3 simboliai ir ne ilgesnis nei 20 simboliai")
    @NotNull @NotEmpty(message = "Vardas privalomas")
    private String name;
    @Column(nullable = false, length = 64)
    @Length(min = 3, max = 20, message = "Pavarde turi būti ilgesnis nei 3 simboliai ir ne ilgesnis nei 20 simboliai")
    @NotNull @NotEmpty(message = "Pavarde privaloma")
    private String surname;
    @Column(nullable = false, length = 64)
    @Email(message = "El-paštas turi būti įvestas tinkamu formatu") @NotNull @NotEmpty(message = "El-paštas privalomas")
    private String email;
    @Column(length = 64)
    @Length(max = 15, message = "Telefonas turi būti ne ilgesnis nei 15 simboliu")
    private String phone;
    @Column(nullable = false, unique = true)
    @NotEmpty
    private String username;
    @NotEmpty
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    @NotEmpty
    private String type = "user";


    public Clients(){}
    public Clients(String name, String surname, String email, String phone, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        HashSet<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(this.type));
        return auth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
