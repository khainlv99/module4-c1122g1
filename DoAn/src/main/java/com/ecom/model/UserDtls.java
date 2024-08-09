package com.ecom.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_dtls")
public class UserDtls {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@Column(name = "mobile_number", length = 15)
	private String mobileNumber;

	@Column(name = "email", unique = true, nullable = false, length = 100)
	private String email;

	@Column(name = "address", length = 255)
	private String address;

	@Column(name = "city", length = 50)
	private String city;

	@Column(name = "state", length = 50)
	private String state;

	@Column(name = "pincode", length = 10)
	private String pincode;

	@Column(name = "password", nullable = false, length = 255)
	private String password;

	@Column(name = "profile_image", length = 255)
	private String profileImage;

	@Column(name = "role", length = 50)
	private String role;

	@Column(name = "is_enable")
	private Boolean isEnable;

	@Column(name = "account_non_locked")
	private Boolean accountNonLocked;

	@Column(name = "failed_attempt")
	private Integer failedAttempt;

	@Column(name = "lock_time")
	private Date lockTime;

	@Column(name = "reset_token", length = 255)
	private String resetToken;

}
