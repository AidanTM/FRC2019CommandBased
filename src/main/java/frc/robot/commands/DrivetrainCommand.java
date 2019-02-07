/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.												*/
/* Open Source Software - may be modified and shared by FRC teams. The code	 */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.																															 */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

/**
 * An example command.	You can replace me with your own command.
 */
public class DrivetrainCommand extends Command {
	XboxController controller = OI.controller;

	double[] speedVal = new double[2];
	public DrivetrainCommand() {
    // Use requires() here to declare subsystem dependencies
		requires(Robot.m_DrivetrainSubsystem);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		speedVal[0] = controller.getY(Hand.kLeft) * 0.5;
		speedVal[1] = controller.getX(Hand.kLeft) * 0.5;

		Robot.m_DrivetrainSubsystem.moveRobot(speedVal[0], speedVal[1]);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
