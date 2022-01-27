package com.codejam.idols.custom.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorTypes {

	private String dateTime;

	private String module;

	private String message;

}
