/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class PenumaticCommand extends Command {
  XboxController controller = OI.controller;
  int lastTriggerTime = 0;
  public PenumaticCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_PenumaticSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    lastTriggerTime = 30;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double trigger = controller.getTriggerAxis(Hand.kLeft);

    if (trigger > 0.5)
    {
      lastTriggerTime = 0;
      Robot.m_PenumaticSubsystem.pistonOut();
      controller.setRumble(RumbleType.kLeftRumble, 1.0);
    }
    else if (lastTriggerTime < 50)
    {
      lastTriggerTime++;
      Robot.m_PenumaticSubsystem.pistonIn();
      controller.setRumble(RumbleType.kLeftRumble, 0.0);
    }
    else
      Robot.m_PenumaticSubsystem.pistonReset();
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
