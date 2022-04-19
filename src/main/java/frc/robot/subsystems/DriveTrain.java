// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;


public class DriveTrain extends SubsystemBase {
 
  //Drive Motors
  private final WPI_TalonFX m_frontLeftMotor = new WPI_TalonFX(DriveConstants.kFrontLeftChannel);
  private final WPI_TalonFX m_rearLeftMotor = new WPI_TalonFX(DriveConstants.kRearLeftChannel);
  private final WPI_TalonFX m_frontRightMotor = new WPI_TalonFX(DriveConstants.kFrontRightChannel);
  private final WPI_TalonFX m_rearRightMotor = new WPI_TalonFX(DriveConstants.kRearRightChannel);

  // Drive Class
  private MecanumDrive m_robotDrive;

  

  double joyThreshold = 0.05; // Default threshold value from XboxController

  public DriveTrain() {

    // Invert the right side motors.
    // You may need to change or remove this to match your robot.
    m_frontRightMotor.setInverted(true);
    m_rearRightMotor.setInverted(true);

    m_robotDrive = new MecanumDrive(m_frontLeftMotor, m_rearLeftMotor, m_frontRightMotor, m_rearRightMotor);

    // Configures the Drive Train Falcon's to default configuration
      //Config brake mode and default configration
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  /**
   * Mecanum drive for differential drive platform.
   *
   * @param xSpeed The robot's speed along the X axis [-1.0..1.0]. Forward is positive.
   * @param zRotation robot's rotation rate around the Z axis [-1.0..1.0]. Clockwise is
   *     positive.*/

  // Drive Type
  public void drive(double ySpeed, double xSpeed, double zRotation){

    // Use the joystick X axis for lateral movement, Y axis for forward
    // movement, and Z axis for rotation.
    m_robotDrive.driveCartesian(ySpeed*-0.6, xSpeed*0.6, zRotation*0.6, 0.0);

    if(Math.abs(xSpeed) > joyThreshold  || Math.abs(zRotation) > joyThreshold ) {
      //m_Drive.arcadeDrive(xSpeed, zRotation);

      //m_Drive.arcadeDrive(xSpeed*1.0, zRotation*-0.6);
    }
    else {
      //m_Drive.arcadeDrive(0.0, 0.0);
    }
  }

  public void autoDrive(){
    
  }
  public void autoDriveBackwards(){
    m_frontLeftMotor.set(ControlMode.PercentOutput, -0.3);
    m_frontRightMotor.set(ControlMode.PercentOutput, -0.3);
    m_rearLeftMotor.set(ControlMode.PercentOutput, -0.3);
    m_rearRightMotor.set(ControlMode.PercentOutput, -0.3);
  }

  public void autoDriveForward(){
    m_frontLeftMotor.set(ControlMode.PercentOutput, 0.3);
    m_frontRightMotor.set(ControlMode.PercentOutput, 0.3);
    m_rearLeftMotor.set(ControlMode.PercentOutput, 0.3);
    m_rearRightMotor.set(ControlMode.PercentOutput, 0.3);
  }

  public void stopMotion() {
    m_frontLeftMotor.set(ControlMode.PercentOutput, 0.0);
    m_frontRightMotor.set(ControlMode.PercentOutput, 0.0);
    m_rearLeftMotor.set(ControlMode.PercentOutput, 0.0);
    m_rearRightMotor.set(ControlMode.PercentOutput, 0.0);
  }
}