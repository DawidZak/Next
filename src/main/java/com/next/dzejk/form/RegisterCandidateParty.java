package com.next.dzejk.form;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class RegisterCandidateParty  extends AbstractRegister{
	@NotEmpty
	protected String partyMember;
	public RegisterCandidateParty(){};
}
