package com.clark.online_edu.store;

import java.util.Collection;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.clark.online.edu.entity.uc.UC_User;
/**
 * 包装org.springframework.security.core.userdetails.User类
 * @author 大仙
 *
 */
public class BaseUserDetail implements UserDetails, CredentialsContainer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 用户
	 */
	private final UC_User baseUser;
	private final User user;

	public BaseUserDetail(UC_User baseUser, User user) {
		this.baseUser = baseUser;
		this.user = user;
	}

	@Override
	public void eraseCredentials() {
		user.eraseCredentials();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return user.getAuthorities();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return user.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return user.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return user.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return user.isEnabled();
	}

	public UC_User getBaseUser() {
		return baseUser;
	}
}
