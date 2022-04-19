// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import javax.swing.JOptionPane;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import oi.limelightvision.limelight.frc.LimeLight;

public class Drive_With_Limelight extends CommandBase {
  private final DriveTrain m_drivetrain;
  private LimeLight m_limelight;
  private Joystick m_joystick;


  /** Creates a new Drive_With_Limelight. */
  public Drive_With_Limelight(Joystick joystick, LimeLight limelight, DriveTrain drivetrain) {
    m_drivetrain = drivetrain;
    m_joystick = joystick;
    m_limelight = limelight;
    addRequirements(m_drivetrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_limelight.setPipeline(2);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double zRotation;
    double kp = .07;

    if(m_limelight.getIsTargetFound()){
      zRotation = m_limelight.getdegRotationToTarget() * kp;
    }else{
      zRotation = m_joystick.getZ();
    }

    m_drivetrain.drive(m_joystick.getY(), m_joystick.getX(), zRotation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_limelight.setPipeline(0);
    m_drivetrain.drive(0,0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
