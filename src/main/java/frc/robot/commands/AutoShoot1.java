//The name might be too literal. This is a one ball autonomous code, meaning it shoots one ball during the entire autonomous phase.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.MoveBall;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.IntakeArm;

public class AutoShoot1 extends SequentialCommandGroup {
    /**
     * Creates a new AutoShoot.
     */
    public AutoShoot1(Flywheel m_flyWheel, MoveBall m_conveyor, DriveTrain m_DriveTrain, IntakeArm m_intakeArm){
      // Add your commands in the super() call, e.g.
      addCommands(
        //One ball autonomous.
        new ShootBall(m_flyWheel, m_conveyor, m_intakeArm).withTimeout(3.0),
        new AutoDriveForward(m_DriveTrain).withTimeout(1.0)
        );
    }
}