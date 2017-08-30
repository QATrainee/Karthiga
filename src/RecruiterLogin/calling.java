package RecruiterLogin;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class calling {

	BaseClass i = new BaseClass();
	implement ii = new implement();

	@BeforeTest
	public void f() throws Exception {
		i.browserOpen();
		i.logIn();

	}

	@Test
	public void g() throws Exception {
//		ii.dashBoard();
//		ii.postJob();
//		ii.jobResponse();
		ii.fetchResume();
//		ii.jobs();
//		ii.myAccount();
	}

	@AfterTest
	public void h() throws Exception {

		//i.logOut();
		//i.browserClose();

	}
}