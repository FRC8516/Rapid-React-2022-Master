// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ManipulatorConstants;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class MoveBall extends SubsystemBase {
  // Lower Conveyor motorr
  private final WPI_VictorSPX lowerConveyorMotor = new WPI_VictorSPX(ManipulatorConstants.kLowerConyMotor);
  
  // The network table 
  private static final String TABLE_NAME = "Preferences";
  
  private static final NetworkTable m_table;
  private ShuffleboardTab ConyTab = Shuffleboard.getTab("Variables");
  private NetworkTableEntry lowerConveyorSpeed = ConyTab.add("LowerConveySpeed", 1.0).getEntry();
 // private NetworkTableEntry ejectConySpeed = ConyTab.add("EjectSpeed", 1.0).getEntry();
  

  /** Creates a new MoveBall. */
  public MoveBall() {
    // Configures the Intake Victors's to default configuration
    lowerConveyorMotor.configFactoryDefault();
    
   // Invert motor direction if set to true
   lowerConveyorMotor.setInverted(true);
  
   lowerConveyorMotor.setNeutralMode(NeutralMode.Coast); 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  // Run
  public void intakeBall() {
    double InSpeed = lowerConveyorSpeed.getDouble(0.5);
    lowerConveyorMotor.set(InSpeed);
}

  public void ejectBall() {
   double OutSpeed = lowerConveyorSpeed.getDouble(1.0);
   lowerConveyorMotor.set(OutSpeed*-1);
  
}

   // Stop Motion
  public void stopMotion() {
   lowerConveyorMotor.set(0.0);
  }

  static {
    m_table = NetworkTableInstance.getDefault().getTable(TABLE_NAME);
    m_table.getEntry(".type").setString("RobotPreferences");
   }

}
