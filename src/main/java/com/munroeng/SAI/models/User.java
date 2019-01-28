package com.munroeng.SAI.models;

import javax.persistence.*;

@Entity(name="User")
@Table(name="Users")
public class User {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long user_id;
	
	@Column(nullable= false)
	private String name;
	
	@Column(nullable= false)
	private String username;

	@Column(nullable= false)
	private String password;
	
	//Roles used to determine permissions and button visibility
	//1 for administrator
	//2 for standard user
	@Column(nullable= false)
	private int role;
	
	public int getRole() {
		return role;
	}
	
	//Takes a string and sets Role dependent on input
	
	public void setRole(String role) {
		if(role.equals("Administrator")) {
			this.role = 1;
		}
		else if(role.equals("User")) {
			this.role = 2;
		}
	}
	
	//Used for updating user credentials
	public void setRole(int role) {
		this.role = role;
	}
	
	public long getUserId() {
		return user_id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
	
	public void setPassword(String pw) {
		this.password = pw;
	}
	
}
