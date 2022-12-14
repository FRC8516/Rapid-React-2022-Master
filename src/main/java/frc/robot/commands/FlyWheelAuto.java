// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Flywheel;

public class FlyWheelAuto extends CommandBase {

  private final Flywheel m_flywheel;
  /** Creates a new RunFlywheel. */
  public FlyWheelAuto(Flywheel flywheel) {
    m_flywheel = flywheel;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(flywheel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  //This is the same as 'RunFlyWheel' but the flywheel is set to max power.
  @Override
  public void execute() {

    m_flywheel.ballOutAuto();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_flywheel.stopMotion();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
