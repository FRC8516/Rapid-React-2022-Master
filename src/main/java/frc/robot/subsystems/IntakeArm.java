// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
//import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeArm extends SubsystemBase {
  // Solenoid corresponds to a single solenoid.
 // private final Solenoid m_solenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 0);

  // DoubleSolenoid corresponds to a double solenoid.
  private final DoubleSolenoid m_doubleSolenoid =
      new DoubleSolenoid(PneumaticsModuleType.REVPH, 1, 2);

  private int kSolenoidButton;

  /** Creates a new IntakeArm. */
  public IntakeArm() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
/*
  public void MoveIntakeArm() {
    if (kSolenoidButton == 1) {
      m_doubleSolenoid.set(DoubleSolenoid.Value.kForward);
      kSolenoidButton = 0;
    } else  {
      
      m_doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
      kSolenoidButton = 1;
    }

  }
*/

public void MoveIntakeArm() {
  if(kSolenoidButton == 0) {
    m_doubleSolenoid.set(DoubleSolenoid.Value.kForward);
    kSolenoidButton = 1;
  }
 

}
public void MoveIntakeArmBack() {
  if(kSolenoidButton == 1) 
    m_doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    kSolenoidButton = 0;
}
  //public void DownMotion() {
    //m_doubleSolenoid.set(DoubleSolenoid.Value.kForward);
  //}
//
  //public void UpMotion() {
    //m_doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

