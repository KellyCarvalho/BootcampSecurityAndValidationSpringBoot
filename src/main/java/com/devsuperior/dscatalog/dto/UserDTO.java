package com.devsuperior.dscatalog.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.devsuperior.dscatalog.entities.User;
import com.sun.istack.NotNull;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	@NotNull
	@NotEmpty(message ="Field is Required")
	@NotBlank(message="Field can`t be blank")
	@Size(min=5,max=30,message="Name Should have in between 5 to 30 characters ")
	private String firstName;
	@NotNull
	@NotEmpty(message ="Field is Required")
	@NotBlank(message="Field can`t be Blank")
	private String lastName;
	@NotNull
	@NotBlank(message="Field can`t be blank")
	@NotEmpty(message="Field is Required")
	@Email(message="Please type a valid Email")
	private String email;

	Set<RoleDTO> roles = new HashSet<>();

	public UserDTO() {

	}

	public UserDTO(Long id, String firstName, String lastName, String email) {

		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public UserDTO(User entity) {

		id = entity.getId();
		firstName = entity.getFirstName();
		lastName = entity.getLastName();
		email = entity.getEmail();
		entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<RoleDTO> getRoles() {
		return roles;
	}

}
