package com.example.email.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document

public class EmailModel {

	@Id
	private String id;
	private Long clienteId;
	private String owner;
	private String from;
	private String to;
	private String title;
	private String subject;
	private String text;
	private LocalDateTime sendDate;
	private StatusEmail statusEmail;
}
