import java.io.IOException;

public class ExecuteCommandsTest extends junit.framework.TestCase {

    public void setUp() {

    }

    public void testCallingAPICommands() throws IOException {
	System.out.println("this is working");

	String[] commandLineArguments = { "172.31.231.85", "17429",
		"onesqueakywheel", "onemanarmy", "MY_CASH" };
	ExchangeClient.main(commandLineArguments);
    }
}
