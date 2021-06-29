import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

import resources.util.Library;

public class demo_responseCodes extends Library{
	public static void main(String[] args) throws ClientProtocolException, IOException {
		int respCode = Request.Get(readConfigFile("url")).execute().returnResponse().getStatusLine().getStatusCode();
		System.out.println(respCode);
	}

}
