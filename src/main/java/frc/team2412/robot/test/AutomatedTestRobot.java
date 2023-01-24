package frc.team2412.robot.test;

import edu.wpi.first.hal.simulation.DriverStationDataJNI;
import edu.wpi.first.wpilibj.DriverStation;
import frc.team2412.robot.Robot;

public class RobotTest extends Robot {
	private static void sleep(long durationMillis) {
		try {
			Thread.sleep(durationMillis);
		} catch (InterruptedException interrupt) {
			System.out.println("Interrupted");
		}
	}

	private static RobotTest instance = null;

	public static RobotTest getInstance() {
		if (instance == null) instance = new RobotTest();
		return instance;
	}

	private RobotTest() {
		System.out.println("Robot type: Automated test");
	}

	@Override
	public void startCompetition() {
		try {
			super.startCompetition();
		} catch (Throwable throwable) {
			Throwable cause = throwable.getCause();
			if (cause != null) {
				throwable = cause;
			}
			DriverStation.reportError(
					"Unhandled exception: " + throwable.toString(), throwable.getStackTrace());
			// Sleep was added to original code in
			// https://github.com/robototes/RapidReact2022/pull/43/commits/e9e81bcae76dabe08b6f2d24eb56b55378012565
			// sleep(2000);
			System.exit(-1);
		}
	}

	@Override
	public void robotInit() {
		super.robotInit();
		new Thread(this::runTest).start();
	}

	private void runTest() {
		System.out.println("Waiting two seconds for robot to finish startup");
		sleep(2000);

		System.out.println("Enabling autonomous mode and waiting 10 seconds");
		DriverStationDataJNI.setAutonomous(true);
		DriverStationDataJNI.setEnabled(true);

		sleep(10000);

		System.out.println("Disabling robot and waiting two seconds");
		DriverStationDataJNI.setEnabled(false);

		sleep(2000);

		System.out.println("Ending competition");
		suppressExitWarning(true);
		endCompetition();
	}
}
