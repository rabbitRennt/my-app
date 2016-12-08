package com.rabbit.vm;

import javax.validation.constraints.Size;

/**
 * View Model extending the UserDTO, which is meant to be used in the user
 * management UI.
 */
public class ManagedUserVM extends UserDTO {

	public static final int PASSWORD_MIN_LENGTH = 4;
	public static final int PASSWORD_MAX_LENGTH = 100;

	private Long id;

	private String createdBy;

	private String lastModifiedBy;

	@Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH)
	private String password;

	public ManagedUserVM() {
	}

	public ManagedUserVM(User user) {
		super(user);
		this.id = user.getId();
		this.createdBy = user.getCreatedBy();
		this.lastModifiedBy = user.getLastModifiedBy();
		this.password = null;
	}

	public ManagedUserVM(Long id, String login, String password, String firstName, String lastName, String email,
			boolean activated, String langKey, String createdBy, String lastModifiedBy) {
		super(login, firstName, lastName, email, activated, langKey);
		this.id = id;
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "ManagedUserVM{" + "id=" + id + ", createdBy=" + createdBy + ", " + ", lastModifiedBy='" + lastModifiedBy
				+ '\'' + ", " + "} " + super.toString();
	}
}
