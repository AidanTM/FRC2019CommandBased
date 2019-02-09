/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * CameraSubsystem: Camera things. Suprisingly short.
 * We COULD just put this in Robot.java but this keeps
 * the code in the other file cleaner.
 */
public class CameraSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  UsbCamera camera;

  @Override
  public void initDefaultCommand() {
    camera = CameraServer.getInstance().startAutomaticCapture();
  }
}
