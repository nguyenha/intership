package com.home.qh.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class MessageDetail extends BaseObject {
	private String messageId;
	private String fromPartyId;
	private String toPartyId;

    @Column(name="message_id", length = 50)
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
    @Column(name="from_party_id", length = 50)
	public String getFromPartyId() {
		return fromPartyId;
	}
	public void setFromPartyId(String fromPartyId) {
		this.fromPartyId = fromPartyId;
	}
    @Column(name="to_party_id", length = 50)
	public String getToPartyId() {
		return toPartyId;
	}
	public void setToPartyId(String toPartyId) {
		this.toPartyId = toPartyId;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}
}
