/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.PenumaticCommand;

/**
 * PenumaticSubsystem: Deals with all of the penumatics within the robot.
 */
public class PenumaticSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  DoubleSolenoid piston;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    piston = new DoubleSolenoid(RobotMap.solenoidForwardPort, RobotMap.solenoidBackwardPort);
    setDefaultCommand(new PenumaticCommand());
  }

  public void pistonIn()
  {
      piston.set(DoubleSolenoid.Value.kReverse);
  }

  public void pistonOut()
  {
      piston.set(DoubleSolenoid.Value.kForward);
  }

  public void pistonReset()
  {
      piston.set(DoubleSolenoid.Value.kOff);
  }
}
