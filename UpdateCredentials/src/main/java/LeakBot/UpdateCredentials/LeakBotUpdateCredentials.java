package LeakBot.UpdateCredentials;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class LeakBotUpdateCredentials {
	private static Logger Log=LogManager.getLogger(LeakBotUpdateCredentials.class.getName());
	Properties prop=new Properties();
	@BeforeTest
	public void getdata() throws IOException
	{
		
		FileInputStream fis=new FileInputStream("C:\\Users\\welcome\\eclipse-workspace\\UpdateCredentials\\src\\main\\java\\LeakBot\\UpdateCredentials\\LeakBotURI.properties");
		prop.load(fis);
		}
	@Test(dataProvider="User_Details")
	public void testmethod(String Token,String Account,String Mobile,String Telephone,String Lastname,String Username,String SMS,String Email,String Mail,String Firstname)
	{
		String HOST=prop.getProperty("URI");
		Log.info("Host Information : "+HOST);
	RestAssured.baseURI=HOST;
	Response res=given().
	header("Content-Type","application/json").
	body(LeakBotBody.bodypostUpdate(Token,Account,Mobile,Telephone,Lastname,Username,SMS,Email,Mail,Firstname)).
	when().
	post(LeakBotResources.Update()).
	then().assertThat().statusCode(200).log().all().extract().response();
	String Respon=res.asString();
	Log.info("JSON Response :"+Respon);
	JsonPath js=new JsonPath(Respon);
	String O_Token=js.get("Token");
	String O_Account=js.get("Account");
	Log.info("Token for which User details are updated :"+O_Token);
	Log.info("Account for which User details are updated :"+O_Account);
	}
	@DataProvider(name="User_Details")
	public Object[][] Multiple_Data()
	{
		Object[][] data=new Object[1][10];
		data[0][0]="b4444924ec456699e23024f2881282dd72419d30";data[0][1]="2032";data[0][2]="004455555777";data[0][3]="004455555777";
	    data[0][4]="Jones";data[0][5]="one.two@homeserve.com";data[0][6]="1";data[0][7]="1";data[0][8]="0";data[0][9]="Anne";
	    	    
	return data;
	}

		}

