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
import frc.robot.commands.PneumaticCommand;
import frc.robot.others.*;

/**
 * PneumaticSubsystem: Deals with all of the penumatics within the robot.
 */
public class PneumaticSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  DoubleSolenoid hatchBirdPiston;
  DoubleSolenoid hatchVerticalPiston;
  DoubleSolenoid ballGripperPiston;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    hatchBirdPiston = new DoubleSolenoid(RobotMap.solenoidHatchForwardPort, RobotMap.solenoidHatchBackwardPort);
    hatchVerticalPiston = new DoubleSolenoid(RobotMap.solenoidVerticalForwardPort, RobotMap.solenoidVerticalBackwardPort);
    ballGripperPiston = new DoubleSolenoid(RobotMap.solenoidGripperForwardPort, RobotMap.solenoidGripperBackwardPort);
    
    setDefaultCommand(new PneumaticCommand());
  }
  //Yuck!
  public void pistonIn(PneumaticEnum piston)
  {
    switch (piston) {
      case Bird:
       hatchBirdPiston.set(DoubleSolenoid.Value.kReverse);
      break;

      case Vertical:
        hatchVerticalPiston.set(DoubleSolenoid.Value.kReverse);
      break;

      case Gripper:
        ballGripperPiston.set(DoubleSolenoid.Value.kReverse);
      break;
    }
  }

  public void pistonOut(PneumaticEnum piston)
  {
    switch (piston) {
      case Bird:
       hatchBirdPiston.set(DoubleSolenoid.Value.kForward);
      break;

      case Vertical:
        hatchVerticalPiston.set(DoubleSolenoid.Value.kForward);
      break;

      case Gripper:
        ballGripperPiston.set(DoubleSolenoid.Value.kForward);
      break;
    }
  }

  public void pistonReset(PneumaticEnum piston)
  {
    switch (piston) {
      case Bird:
       hatchBirdPiston.set(DoubleSolenoid.Value.kOff);
      break;

      case Vertical:
        hatchVerticalPiston.set(DoubleSolenoid.Value.kOff);
      break;

      case Gripper:
        ballGripperPiston.set(DoubleSolenoid.Value.kOff);
      break;
    }
  }
}
