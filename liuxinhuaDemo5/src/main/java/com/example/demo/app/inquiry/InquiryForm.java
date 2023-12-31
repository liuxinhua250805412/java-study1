package com.example.demo.app.inquiry;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//根据form.html写的表单类
public class InquiryForm {  
	
	@Size (min = 1,max = 20,message = "please input 20characters or less")
   private String name;
	
   
	@NotNull
	@Email(message ="Invalid E-mail Format")
	private String email;

	@NotNull
	private String contents;
	

	public InquiryForm() {
	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}

}
