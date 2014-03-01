import java.io.IOException;

/**
 * @author Quinn Liu (quinnliu@vt.edu)
 * @version Feb 28, 2014
 */
public class ExecuteCommandsTest extends junit.framework.TestCase {
    private long currentTimeInSecondsSinceMidnightJanuaryFirst1970;
    private long numberOfSecondToRunTradingAlgorithm;
    private long timeToStopProgram;

    public void setUp() {
	this.currentTimeInSecondsSinceMidnightJanuaryFirst1970 = (System
		.currentTimeMillis() / 1000);
	this.numberOfSecondToRunTradingAlgorithm = 5;
	this.timeToStopProgram = currentTimeInSecondsSinceMidnightJanuaryFirst1970
		+ this.numberOfSecondToRunTradingAlgorithm;
    }

    public void updateCurrentTime() {
	this.currentTimeInSecondsSinceMidnightJanuaryFirst1970 = (System
		.currentTimeMillis() / 1000);
    }

    public void pauseAllProgramsOneSecond() {
	try {
	    Thread.sleep(1000);
	} catch (InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
    }

    public void testCallingAPICommands() throws IOException {

	System.out.println("this is working");

	String[] commandLineArguments = { "172.31.231.85", "17429",
		"onesqueakywheel", "onemanarmy", "MY_CASH" };
	ExchangeClient.main(commandLineArguments);

	System.out.println(currentTimeInSecondsSinceMidnightJanuaryFirst1970);
	System.out.println(timeToStopProgram);

	while (currentTimeInSecondsSinceMidnightJanuaryFirst1970 < timeToStopProgram) {
	    ExchangeClient.main(commandLineArguments);

	    this.pauseAllProgramsOneSecond();
	    this.updateCurrentTime();
	}
    }
}
