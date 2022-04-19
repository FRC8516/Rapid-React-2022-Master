// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeArm;

public class ArmControlReverse extends CommandBase {
  private final IntakeArm m_intakeArm;

  /** Creates a new ArmControl. */
  public ArmControlReverse(IntakeArm intakearm) {
    m_intakeArm = intakearm;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intakearm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_intakeArm.MoveIntakeArmBack();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
