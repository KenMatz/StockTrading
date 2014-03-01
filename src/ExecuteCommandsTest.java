import java.io.IOException;

/**
 * @author Quinn Liu (quinnliu@vt.edu)
 * @version Feb 28, 2014
 */
public class ExecuteCommandsTest extends junit.framework.TestCase {

    private long numberOfSecondToRunTradingAlgorithm;

    public void setUp() {
	this.numberOfSecondToRunTradingAlgorithm = 5;
    }

    public void testCallingAPICommands() throws IOException {
	long currentTimeInSecondsSinceMidnightJanuaryFirst1970 = (System
		.currentTimeMillis() / 1000);
	long timeToStopProgram = currentTimeInSecondsSinceMidnightJanuaryFirst1970
		+ this.numberOfSecondToRunTradingAlgorithm;

	System.out.println("this is working");

	String[] commandLineArguments = { "172.31.231.85", "17429",
		"onesqueakywheel", "onemanarmy", "MY_CASH" };
	ExchangeClient.main(commandLineArguments);

	System.out
		.println(currentTimeInSecondsSinceMidnightJanuaryFirst1970);
	System.out.println(timeToStopProgram);
    }
}
