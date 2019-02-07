/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DrivetrainCommand;

/**
 * DrivetrainSubsystem: Contains the main SPARK motor controllers for the robot.
 */
public class DrivetrainSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //These are the four motors that make up the drivetrain subsystem.
	//We will group them up later.
	Spark leftFront;
	Spark leftBack;
	Spark rightFront;
	Spark rightBack;
	
	//Each SpeedControllerGroup will hold two motors. We have two
	//groups for the left and right side.
	SpeedControllerGroup leftGroup;
	SpeedControllerGroup rightGroup;
	
	//This connects the two SpeedControllerGroups together, creating one union
	//drivetrain with four motors.
	DifferentialDrive drivetrain;

  @Override
  public void initDefaultCommand() {
    //Intitiate the SPARK motors, inputting the ports.
    leftFront = new Spark(RobotMap.leftFrontPort);
    leftBack = new Spark(RobotMap.leftBackPort);
    rightFront = new Spark(RobotMap.rightBackPort);
    rightBack = new Spark(RobotMap.rightFrontPort);

    //SpeedControllerGroups. Bundle two SPARKs together.
    leftGroup = new SpeedControllerGroup(leftFront, leftBack);
    rightGroup = new SpeedControllerGroup(rightFront, rightBack);

    //Initialize the main drivetrain.
    drivetrain = new DifferentialDrive(leftGroup, rightGroup);

    //Disable safety. This will prevent the robot from browning out too much.
    leftFront.setSafetyEnabled(false);
    leftBack.setSafetyEnabled(false);
    rightFront.setSafetyEnabled(false);
		rightBack.setSafetyEnabled(false);
    drivetrain.setSafetyEnabled(false);

    // Set the default command for a subsystem here.
    setDefaultCommand(new DrivetrainCommand());
  }

  public void moveRobot(double x, double z)
  {
    drivetrain.curvatureDrive(x, z, true);
  }
}
