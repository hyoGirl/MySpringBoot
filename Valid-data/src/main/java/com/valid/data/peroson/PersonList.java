package com.valid.data.peroson;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;

public class PersonList {

	@Valid
	@NotEmpty
	private List<Person> persons;
}
