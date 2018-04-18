package pl.edu.prz.kia.universityproject.model;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Transient;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;

	@Column(name = "email")
	@Email(message = "*Podaj poprawny adres email")
	@NotEmpty(message = "*Podaj email")
	private String email;

	@Column(name = "password")
	@Length(min = 5, message = "*Haslo musi posiadac conajmniej 5 znakow")
	@NotEmpty(message = "*Podaj haslo")
	@Transient
	private String password;

	@Column(name = "name")
	@NotEmpty(message = "*Podaj imie")
	private String name;

	@Column(name = "last_name")
	@NotEmpty(message = "*Podaj nazwisko")
	private String lastName;

	@Column(name = "active")
	private int active;

	@Column(name = "ankieta")
	@NotEmpty(message = "*Wypelnij ankiete")
	private boolean ankieta;

	@Column(name = "awatar")
	private String Awatar;

	@OneToMany(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "user")
	private Set<UserRole> userrole = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
