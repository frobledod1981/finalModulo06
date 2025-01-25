package com.frobledo.dto;

import java.util.List;

import com.frobledo.model.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
	private String username;
	private String email;
	private List<Role> roles;

}
