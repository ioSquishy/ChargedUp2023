package frc.team2412.robot.test;

import edu.wpi.first.wpilibj.RobotBase;

public final class AutomatedTestMain {
	public static void main(String[] args) {
		RobotBase.startRobot(RobotTest::getInstance);
	}
}
