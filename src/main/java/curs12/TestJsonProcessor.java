package curs12;

public class TestJsonProcessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonFileProcessor obj = new JsonFileProcessor();
		
		obj.writeJson();
		obj.readJson ("email");
		obj.readJson ("lista obiecte");
		obj.updateJson("name","Tester Automat1");
		obj.deleteJson("email");
		
	}

}
