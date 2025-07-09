package utils;

public class CreateUserPayload {
		
		public static String Postpayload(String Name, String email, String gender, String Status) {
			
			return " {\r\n"
					+ "    \"name\": \""+Name+"\",\r\n"
					+ "    \"email\": \""+email+"\",\r\n"
					+ "    \"gender\": \""+gender+"\",\r\n"
					+ "    \"status\": \""+Status+"\"\r\n"
					+ "  }";
			
		}
		
	public static String Putpayload(String PatchField, String PatchValue) {
			
			return "{\r\n"
					+ "    \""+PatchField+"\": \""+PatchValue+"\" \r\n"
					+ "}";
			
		}
	

}


