// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
//import com.revrobotics.CANSparkMax;
//import com.revrobotics.RelativeEncoder;
//import com.ctre.phoenix.motorcontrol.TalonFXSensorCollection;

//import com.revrobotics.CANSparkMax.IdleMode;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.shuffleboard.SimpleWidget;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {

private final WPI_TalonFX m_climberMotor = new WPI_TalonFX(Constants.ManipulatorConstants.kclimberMotor);

 // The network table 
 private static final String TABLE_NAME = "Preferences";
  
 private static final NetworkTable m_table;
 private ShuffleboardTab ClimberTab = Shuffleboard.getTab("Variables");
 private NetworkTableEntry ClimberDownSpeed = ClimberTab.add("DownSpeed", 1.0).getEntry();
 private NetworkTableEntry ClimberUpSpeed = ClimberTab.add("UpSpeed", 1.0).getEntry();
  SimpleWidget EncoderVelocity = ClimberTab.add("EncoderPosition", m_climberMotor.getSelectedSensorPosition());

//public class Encodervelocity = m_Climbermotor.getSelectedSensorPosition;    

 // Creates a new Climber. 
 public Climber() {
  
  // Configures the Intake Talon's to default configuration
  m_climberMotor.configFactoryDefault();
   
  // Invert motor direction if set to true
  m_climberMotor.setInverted(false);
 
  m_climberMotor.setNeutralMode(NeutralMode.Brake);
  
  }
  // need to go 9 revs
  
    // This method will be called once per scheduler run
   // SmartDashboard.putNumber("Encoder Position", m_encoder.getPosition()

//SmartDashboard.putNumber("Encoder Velocity", m_encoder.getVelocity());

 

 @Override
 public void periodic() {
 // This method will be called once per scheduler run
 }

 // Run
 public void climberDown() {
   double DownSpeed = ClimberDownSpeed.getDouble(1.0);
   m_climberMotor.set(DownSpeed*1);
}

 public void climberUp() {
   double UpSpeed = ClimberUpSpeed.getDouble(1.0);
   m_climberMotor.set(UpSpeed*-1);
  
}
 // Stop Motion
 public void stopMotion() {
   m_climberMotor.set(0.0);
 }

 static {
  m_table = NetworkTableInstance.getDefault().getTable(TABLE_NAME);
  m_table.getEntry(".type").setString("RobotPreferences");
 }

}




/*
private RelativeEncoder m_encoder;

 
  public Climber() {
    m_climberMotor.restoreFactoryDefaults();
    m_climberMotor.setIdleMode(IdleMode.kBrake);

    m_encoder = m_climberMotor.getEncoder();

  }
  // need to go 9 revs
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Encoder Position", m_encoder.getPosition());

    SmartDashboard.putNumber("Encoder Velocity", m_encoder.getVelocity());


  }
  */

