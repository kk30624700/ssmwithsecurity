package com.boottest.dao;

import com.boottest.domain.UserSecurity;

public interface UserSecurityDao {
	public UserSecurity getSecurityInfo(String username);
}
