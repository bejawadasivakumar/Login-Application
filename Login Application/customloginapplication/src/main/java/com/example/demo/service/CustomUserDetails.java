package com.example.demo.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

	
	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	private String fullname;
	 private boolean isAccountNonExpired;
	    private boolean isAccountNonLocked;
	    private boolean isCredentialsNonExpired;
	    private boolean isEnabled;
	
	public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities,
			String fullname) {
		
		this.username = username;
		this.password = password;
		this.authorities = authorities;
		this.fullname = fullname;
	}
	
	public String getFullname() {
		return fullname;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	@Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
	
}
