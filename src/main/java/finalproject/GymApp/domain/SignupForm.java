package finalproject.GymApp.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class SignupForm {

	@NotEmpty
	@Size(min=6, max=30)
	private String username= "";
	
	@NotEmpty
	@Size(min=8, max=30)
	private String password= "";
	
	@NotEmpty
	@Size(min=8, max=30)
	private String passwordCheck= "";
	
	@NotEmpty
	@Size(min=10, max=80)
	private String email = "";
	
	@NotEmpty
	private String role = "USER";

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

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
