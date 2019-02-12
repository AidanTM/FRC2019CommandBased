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
import frc.robot.others.PneumaticEnum;

public class PneumaticCommand extends Command {
  XboxController controller = OI.controller;
  int lastTriggerTime = 0;
  public PneumaticCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_PneumaticSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_PneumaticSubsystem.pistonReset(PneumaticEnum.Gripper);
    Robot.m_PneumaticSubsystem.pistonReset(PneumaticEnum.Vertical);
    Robot.m_PneumaticSubsystem.pistonReset(PneumaticEnum.Bird);
    lastTriggerTime = 30;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double trigger = controller.getTriggerAxis(Hand.kLeft);

    if (trigger > 0.1)
    {
      lastTriggerTime = 0;
      Robot.m_PneumaticSubsystem.pistonOut(PneumaticEnum.Bird);
      controller.setRumble(RumbleType.kLeftRumble, 1.0);
    }
    else if (lastTriggerTime < 50)
    {
      lastTriggerTime++;
      Robot.m_PneumaticSubsystem.pistonIn(PneumaticEnum.Bird);
      controller.setRumble(RumbleType.kLeftRumble, 0.0);
    }
    else
      Robot.m_PneumaticSubsystem.pistonReset(PneumaticEnum.Bird);

    double throttle = controller.getY(Hand.kRight);

    if (throttle > 0.1)
    {
      Robot.m_PneumaticSubsystem.pistonOut(PneumaticEnum.Gripper);
      controller.setRumble(RumbleType.kRightRumble, 1.0);
    }
    else if (throttle < -0.1)
    {
      Robot.m_PneumaticSubsystem.pistonIn(PneumaticEnum.Gripper);
      controller.setRumble(RumbleType.kRightRumble, 0.0);
    }
    else
      Robot.m_PneumaticSubsystem.pistonReset(PneumaticEnum.Gripper);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {

    Robot.m_PneumaticSubsystem.pistonOut(PneumaticEnum.Gripper);
    Robot.m_PneumaticSubsystem.pistonOut(PneumaticEnum.Vertical);
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
