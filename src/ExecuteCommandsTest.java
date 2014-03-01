import java.io.IOException;

/**
 * @author Quinn Liu (quinnliu@vt.edu)
 * @version Feb 28, 2014
 */
public class ExecuteCommandsTest extends junit.framework.TestCase {
    private long currentTimeInSecondsSinceMidnightJanuaryFirst1970;
    private long numberOfSecondToRunTradingAlgorithm;
    private long timeToStopProgram;

    private APICommands APICommands;

    public void setUp() {
	this.currentTimeInSecondsSinceMidnightJanuaryFirst1970 = (System
		.currentTimeMillis() / 1000);
	this.numberOfSecondToRunTradingAlgorithm = 5;
	this.timeToStopProgram = currentTimeInSecondsSinceMidnightJanuaryFirst1970
		+ this.numberOfSecondToRunTradingAlgorithm;

	this.APICommands = new APICommands();
    }

    public void testCallingAPICommandsUntilSpecifiedStopTime()
	    throws IOException {
	String[] commandLineArguments = { "172.31.231.85", "17429",
		"onesqueakywheel", "onemanarmy",
		this.APICommands.getCurrentCash() };

	// runs program for this.numberOfSecondToRunTradingAlgorithm
	while (currentTimeInSecondsSinceMidnightJanuaryFirst1970 < timeToStopProgram) {
	    ExchangeClient.main(commandLineArguments);

	    this.updateCurrentTime();
	    this.pauseAllProgramsOneSecond();
	}
    }

    private void updateCurrentTime() {
	this.currentTimeInSecondsSinceMidnightJanuaryFirst1970 = (System
		.currentTimeMillis() / 1000);
    }

    private void pauseAllProgramsOneSecond() {
	try {
	    Thread.sleep(1000);
	} catch (InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
    }
}
