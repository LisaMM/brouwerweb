package be.vdab.web;

import javax.validation.constraints.*;

class BrouwersOpNaamForm {
	@NotNull
	@Size(min=1, max=50, message="{Size.naam}")
	private String beginnaam;
	
	BrouwersOpNaamForm() {}
	
	BrouwersOpNaamForm(String beginnaam) {
		this.beginnaam = beginnaam.trim();
	}

	public String getBeginnaam() {
		return beginnaam;
	}

	public void setBeginnaam(String beginnaam) {
		this.beginnaam = beginnaam;
	}
}
