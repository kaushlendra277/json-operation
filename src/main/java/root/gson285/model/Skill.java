package root.gson285.model;

import java.util.Arrays;

public class Skill {
	private String[] technicalSkills;

	public String[] getTechnicalSkills() {
		return technicalSkills;
	}

	public void setTechnicalSkills(String[] technicalSkills) {
		this.technicalSkills = technicalSkills;
	}

	@Override
	public String toString() {
		return "Skill [technicalSkills=" + Arrays.toString(technicalSkills) + "]";
	}
}
