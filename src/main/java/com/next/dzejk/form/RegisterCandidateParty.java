package com.next.dzejk.form;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;


public class RegisterCandidateParty  extends AbstractRegister{
	@NotEmpty
	protected String partyMember;
	public RegisterCandidateParty(){}
	public String getPartyMember() {
		return partyMember;
	}
	public void setPartyMember(String partyMember) {
		this.partyMember = partyMember;
	};
}
