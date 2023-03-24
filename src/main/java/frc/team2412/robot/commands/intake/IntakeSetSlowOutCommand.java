package frc.team2412.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2412.robot.subsystems.IntakeSubsystem;

public class IntakeSetSlowOutCommand extends CommandBase {
	IntakeSubsystem intakeSubsystem;

	public IntakeSetSlowOutCommand(IntakeSubsystem intakeSubsystem) {
		this.intakeSubsystem = intakeSubsystem;
		addRequirements(intakeSubsystem);
	}

	@Override
	public void initialize() {
		intakeSubsystem.intakeSlowOut();
	}

	// TODO: uncomment when color matching works
	@Override
	public boolean isFinished() {
		// return !intakeSubsystem.hasObject();
		return false;
	}
}
