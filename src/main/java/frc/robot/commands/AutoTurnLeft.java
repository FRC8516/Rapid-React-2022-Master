package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class AutoTurnLeft extends CommandBase {
  
    private final DriveTrain m_driveTrain;
  
    public AutoTurnLeft(DriveTrain driveTrain) {
      m_driveTrain = driveTrain;
      addRequirements(driveTrain);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      m_driveTrain.autoTurnLeft();
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
      m_driveTrain.stopMotion();
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
    
}
