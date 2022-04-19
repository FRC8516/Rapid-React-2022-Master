// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


//Dangit Todd you got us. This is a code that was intended to run the lower conveyor. Then we found MoveBall. Why would you name these things in such a way?

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ManipulatorConstants;

public class Conveyor extends SubsystemBase {

  // Intake motor
  private final WPI_VictorSPX ConveyorMotor = new WPI_VictorSPX(ManipulatorConstants.kLowerConyMotor);
  

  // The network table 
  private static final String TABLE_NAME = "Preferences";
  
  private static final NetworkTable m_table;
  private ShuffleboardTab ConveyorTab = Shuffleboard.getTab("Variables");
  private NetworkTableEntry ConveyorInSpeed = ConveyorTab.add("InSpeed", 1.0).getEntry();
  private NetworkTableEntry ConveyorOutSpeed = ConveyorTab.add("OutSpeed", 1.0).getEntry();
  //private NetworkTableEntry ConveyorSpeed = IntakeTab.add("HoldSpeed", 0.25).getEntry();


  // Creates a new Intake. 
  public Conveyor() {
   
   // Configures the Intake Victors's to default configuration
   ConveyorMotor.configFactoryDefault();
    
   // Invert motor direction if set to true
   ConveyorMotor.setInverted(false);
  
   ConveyorMotor.setNeutralMode(NeutralMode.Coast); 

  }

  @Override
  public void periodic() {
  // This method will be called once per scheduler run
  }

  // Run
  public void ConveyorInSpeed() {
    double InSpeed = ConveyorInSpeed.getDouble(1.0);
    ConveyorMotor.set(InSpeed*1);
}

  public void ConveyorOutSpeed() {
    double OutSpeed = ConveyorOutSpeed.getDouble(1.0);
    ConveyorMotor.set(OutSpeed*-1);
   
}
/*
  public void holdBall() {
    double HoldSpeed = holdSpeed.getDouble(0.25);
    ConveyorMotor.set(HoldSpeed*-1);
  }
*/

  // Stop Motion
  public void stopMotion() {
    ConveyorMotor.set(0.0);
  }

  static {
   m_table = NetworkTableInstance.getDefault().getTable(TABLE_NAME);
   m_table.getEntry(".type").setString("RobotPreferences");
  }

 }

 
 
