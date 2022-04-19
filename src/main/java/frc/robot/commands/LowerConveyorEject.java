// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.MoveBall;

public class LowerConveyorEject extends CommandBase {
  private final MoveBall m_lowerConveyor;

  /** Creates a new LowerConveyor. */
  public LowerConveyorEject(MoveBall lowerConveyor) {
    m_lowerConveyor = lowerConveyor;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(lowerConveyor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_lowerConveyor.ejectBall();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_lowerConveyor.stopMotion();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
