import java.io.IOException;

/**
 * @author Quinn Liu (quinnliu@vt.edu)
 * @version Feb 28, 2014
 */
public class ExecuteCommandsTest extends junit.framework.TestCase {
    private String hostIPAddress;
    private String portNumber;

    private String onesqueakywheelTeam;
    private String onesqueakywheelTeamPassword;

    private String houseOfCardsTeam;
    private String houseOfCardsTeamPassword;

    private long currentTimeInSecondsSinceMidnightJanuaryFirst1970;
    private long numberOfSecondsToRunTradingAlgorithm;
    private long timeToStopProgram;

    private APICommands APICommands;

    public void setUp() {
	this.hostIPAddress = "172.31.231.85";
	this.portNumber = "17429";

	this.onesqueakywheelTeam = "onesqueakywheel";
	this.onesqueakywheelTeamPassword = "onemanarmy";

	this.houseOfCardsTeam = "houseofcards";
	this.houseOfCardsTeamPassword = "kevinspacey";

	this.currentTimeInSecondsSinceMidnightJanuaryFirst1970 = (System
		.currentTimeMillis() / 1000);
	this.numberOfSecondsToRunTradingAlgorithm = 1;
	this.timeToStopProgram = currentTimeInSecondsSinceMidnightJanuaryFirst1970
		+ this.numberOfSecondsToRunTradingAlgorithm;

	this.APICommands = new APICommands();

	this.printToConsoleProgramRuntime();
    }

    public void testCallingAPICommandsUntilSpecifiedStopTime()
	    throws IOException {

	// runs program for this.numberOfSecondToRunTradingAlgorithm
	while (currentTimeInSecondsSinceMidnightJanuaryFirst1970 < timeToStopProgram) {
	    // GAME PLAN
	    // team A and team B
	    // 1) find 2 stocks that is increasing FB & Ea
	    // 2) A buy EA & B buys FB
	    // 3) few second later A sell EA & B sells FB
	    // 4) immediately A buys FB & B buys EA
	    String[] teamACommandLineArguments = { this.hostIPAddress,
			this.portNumber, this.houseOfCardsTeam,
			this.houseOfCardsTeamPassword,
			this.APICommands.getCurrentCash() };

	    ExchangeClient.main(teamACommandLineArguments);

	    this.pauseAllProgramsOneSecond();
	    this.updateCurrentTime();
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

    private void printToConsoleProgramRuntime() {
	int hours = (int) (numberOfSecondsToRunTradingAlgorithm / 3600);
	int minutes = (int) (numberOfSecondsToRunTradingAlgorithm / 60);
	int seconds = (int) (this.numberOfSecondsToRunTradingAlgorithm - hours
		* 3600 - minutes * 60);

	System.out.println("This program will stop trading in " + hours
		+ " hour(s), " + minutes + " minute(s), and " + seconds
		+ " second(s)");
    }
}
