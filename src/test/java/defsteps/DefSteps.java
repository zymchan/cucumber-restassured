package defsteps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class DefSteps extends BaseStep{


    @Given("^i input \"([^\"]*)\" and \"([^\"]*)\"$")
    public void sendRequest(String protocol, String url, String para, String head){
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


    @Given("^i input \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iInputAnd(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
