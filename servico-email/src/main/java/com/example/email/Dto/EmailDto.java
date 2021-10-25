package com.example.email.Dto;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;



import lombok.Data;

@Data
public class EmailDto {
	
	@NotBlank
	private String owner;
	@NotBlank
	@Email
	private String from;
	@NotBlank
	@Email
	private String to;
	@NotBlank
	private String title;
	@NotBlank
	private String subject;
	@NotBlank
	private String text;
	
}
