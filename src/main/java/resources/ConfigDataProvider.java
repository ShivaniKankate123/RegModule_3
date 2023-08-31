package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties Pro;

	public ConfigDataProvider() throws IOException {
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		//
		try {
			FileInputStream fis = new FileInputStream(src);
			Pro = new Properties();
			Pro.load(fis);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	public String getBrowser() {
		return Pro.getProperty("Browser");
	}

	public String getBaseUrl() {
		return Pro.getProperty("QABaseUrl");
	}

	public String getWATBaseUrl() {
		return Pro.getProperty("WATBaseUrl");
	}

	public String getProdBaseUrl() {
		return Pro.getProperty("ProdBaseUrl");
	}

	public String getPassWord() {
		return Pro.getProperty("Password");
	}

	public String getUserSponsorCa() {
		return Pro.getProperty("UserSponsorCa");

	}

	public String getUserSponsorCa2() {
		return Pro.getProperty("UserSponsorCa2");

	}

	public String getUserSponsorWs() {
		return Pro.getProperty("UserSponsorWS");
	}

	public String getUserSponsorWs2() {
		return Pro.getProperty("UserSponsorWS2");
	}

	public String getUserSponsorNS2() {
		return Pro.getProperty("UserSponsorNS2");
	}

	public String getUserSponsorQc() {
		return Pro.getProperty("UserSponsorQc");
	}

	public String getUserSponsorNs() {
		return Pro.getProperty("UserSponsorNS");
	}

	public String getUserMMCa() {
		return Pro.getProperty("UnameMMCa");
	}

	public String getUserMMQc() {
		return Pro.getProperty("UnameMMQc");
	}

	public String getUserMMNs() {
		return Pro.getProperty("UnameMMNS");
	}

	public String getUserFSACa() {
		return Pro.getProperty("UnameFSACa");
	}

	public String getUserFSAQc() {
		return Pro.getProperty("UnameFSAQc");
	}

	public String getUserFSANs() {
		return Pro.getProperty("UnameFSANS");
	}

	public String getUserEACa() {
		return Pro.getProperty("UnameEACa");
	}

	public String getUserEAQc() {
		return Pro.getProperty("UnameEAQc");
	}

	public String getUserEANs() {
		return Pro.getProperty("UnameEANS");
	}

	public String getARusername() {
		return Pro.getProperty("UnameEANS");
	}

	public String QABaseUrl() {
		// TODO Auto-generated method stub
		return null;
	}

}
