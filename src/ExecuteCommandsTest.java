import java.io.IOException;

/**
 * @author Quinn Liu (quinnliu@vt.edu)
 * @version Feb 28, 2014
 */
public class ExecuteCommandsTest extends junit.framework.TestCase {
    private long currentTimeInSecondsSinceMidnightJanuaryFirst1970;
    private long numberOfSecondsToRunTradingAlgorithm;
    private long timeToStopProgram;

    private APICommands APICommands;

    public void setUp() {
	this.currentTimeInSecondsSinceMidnightJanuaryFirst1970 = (System
		.currentTimeMillis() / 1000);
	this.numberOfSecondsToRunTradingAlgorithm = 60;
	this.timeToStopProgram = currentTimeInSecondsSinceMidnightJanuaryFirst1970
		+ this.numberOfSecondsToRunTradingAlgorithm;

	this.APICommands = new APICommands();
    }

    public void testCallingAPICommandsUntilSpecifiedStopTime()
	    throws IOException {
	String hostIPAddress = "172.31.231.85";
	String portNumber = "17429";
	String teamName = "onesqueakywheel";
	String teamPassword = "onemanarmy";
	String[] commandLineArguments = { hostIPAddress, portNumber, teamName,
		teamPassword, this.APICommands.getCurrentCash() };

	int hours = (int) (numberOfSecondsToRunTradingAlgorithm / 3600);
	int minutes = (int) (numberOfSecondsToRunTradingAlgorithm / 60);
	int seconds = (int) (this.numberOfSecondsToRunTradingAlgorithm - hours
		* 3600 - minutes * 60);

	System.out.println("This program will stop trading in " + hours
		+ " hour(s), " + minutes + " minute(s), and " + seconds
		+ " second(s)");

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
