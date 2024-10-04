package com.javaweb.repository.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
	@Column(name = "username", nullable = false, unique = true)
	private String userName;
	
	@Column(name="password", nullable = false)
	private String passWord;
	
	@Column(name = "fullname")
	private String fullName;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "status", nullable = false)
	private Integer status;
	
//	@OneToMany(mappedBy = "user")
//	private List<UserRoleEntity> userRoleEntities = new ArrayList<UserRoleEntity>();

	@ManyToMany
	@JoinTable(name = "user_role",
				joinColumns = @JoinColumn(name = "userid"),
				inverseJoinColumns = @JoinColumn(name = "roleid"))
	private List<RoleEntity> roles;
	

//	public List<UserRoleEntity> getUserRoleEntities() {
//		return userRoleEntities;
//	}
//
//	public void setUserRoleEntities(List<UserRoleEntity> userRoleEntities) {
//		this.userRoleEntities = userRoleEntities;
//	}
	
	public List<RoleEntity> getRoles() {
		return roles;
	}
	
	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
