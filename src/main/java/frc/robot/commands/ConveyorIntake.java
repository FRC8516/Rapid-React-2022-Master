// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.MoveBall;
import frc.robot.subsystems.Intake;

public class ConveyorIntake extends CommandBase {
  private final MoveBall m_lowerConveyor;
  private final Intake m_Intake;

  /** Creates a new ConveyorIntake. */
  public ConveyorIntake(MoveBall lowerConveyor, Intake intake) {
    m_lowerConveyor = lowerConveyor;
    m_Intake = intake;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(lowerConveyor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_lowerConveyor.intakeBall();
    m_Intake.intakeBall();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_lowerConveyor.stopMotion();
    m_Intake.stopMotion();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
