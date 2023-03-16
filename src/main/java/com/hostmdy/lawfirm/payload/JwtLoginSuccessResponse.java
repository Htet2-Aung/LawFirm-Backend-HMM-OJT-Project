package com.hostmdy.lawfirm.payload;



import com.hostmdy.lawfirm.domain.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtLoginSuccessResponse {
	
	private boolean success;
	private String token;
	private User user;

}
