/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.IntakeCommand;

/**
 * IntakeSubsystem: Creates the variables for the two motors in the ball intake mechanic.
 */
public class IntakeSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Talon leftWheel;
  Talon rightWheel;

  DifferentialDrive talonGroup;
  @Override
  public void initDefaultCommand() {
    leftWheel = new Talon(RobotMap.leftIntakePort);
    rightWheel = new Talon(RobotMap.rightIntakePort);
    talonGroup = new DifferentialDrive(leftWheel, rightWheel);

    leftWheel.setSafetyEnabled(false);
    rightWheel.setSafetyEnabled(false);
    talonGroup.setSafetyEnabled(false);

    // Set the default command for a subsystem here.
     setDefaultCommand(new IntakeCommand());
  }

  public void setWheelSpeed(double speed)
  {
    talonGroup.tankDrive(speed, speed);
  }
}
