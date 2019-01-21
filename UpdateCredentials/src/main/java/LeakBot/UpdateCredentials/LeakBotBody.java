package LeakBot.UpdateCredentials;

public class LeakBotBody {
	public static String bodypostUpdate(String Token, String Account, String Mobile, String Telephone, String Lastname, String Username, String SMS, String Email, String Mail, String Firstname)
	{
	String UpdateBody="{\r\n" + 
			"\r\n" + 
			"\"token\":\""+Token+"\",\r\n" + 
			"\r\n" + 
			"\"account_id\":\""+Account+"\",\r\n" + 
			"\r\n" + 
			"\"mobile_number\":\""+Mobile+"\",\r\n" + 
			"\r\n" + 
			"\"home_tel_number\":\""+Telephone+"\",\r\n" + 
			"\r\n" + 
			"\"last_name\":\""+Lastname+"\",\r\n" + 
			"\r\n" + 
			"\"username\":\""+Username+"\",\r\n" + 
			"\r\n" + 
			"\"sms_allowed\" : \""+SMS+"\",\r\n" + 
			"\r\n" + 
			"\"email_allowed\" : \""+Email+"\",\r\n" + 
			"\r\n" + 
			"\"mail_allowed\" : \""+Mail+"\",\r\n" + 
			"\r\n" + 
			"\"first_name\":\""+Firstname+"\"\r\n" + 
			"\r\n" + 
			"}";
	return UpdateBody;
	}
}
