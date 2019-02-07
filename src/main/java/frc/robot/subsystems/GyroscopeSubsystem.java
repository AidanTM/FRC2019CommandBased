/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * GyroscopeSubsyem: Sets up and calibrates the gyroscope on the RoboRIO.
 */
public class GyroscopeSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  ADXRS450_Gyro gyro;


  @Override
  public void initDefaultCommand() {
      gyro = new ADXRS450_Gyro(Port.kOnboardCS0);
      //If we can't find a gyroscope, give up.
      if (gyro == null) return;
      //Calibrate the gyroscope. This will set an angle of "0" to the Robot's current direction.
      gyro.calibrate();
      //Tell us that calibration is done.
	    SmartDashboard.putNumber("Gyro", getAngle());
	    DriverStation.reportWarning("Gyro calibrated.", false);
  }

  public double getAngle()
  {
    return gyro.getAngle();
  }
}
