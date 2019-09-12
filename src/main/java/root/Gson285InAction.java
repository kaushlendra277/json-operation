package root;

import com.google.gson.Gson;

import root.gson285.Gson285Utils;
import root.gson285.model.Skill;
import root.gson285.model.Student;

public class Gson285InAction {
	public static void main(String[] args) {
		// preparing pojo
		Student student = new Student();
		student.setId("ksc");
		student.setName("Kaushlendra");
		Skill skill = new Skill();
		skill.setTechnicalSkills(new String[] {"java", "spring"});
		student.setSkill(skill);
		
		// Creating gson object, it does all the to and from conversion
		Gson gson = new Gson();
		// from-pojo-to-json
		String jsonObjectString = gson.toJson(student);
		
		// from json-to-any-specified-pojo
		Student afterDesiralzing = Gson285Utils.toObject(jsonObjectString, Student.class);
		System.out.println(afterDesiralzing);
	}		
}
