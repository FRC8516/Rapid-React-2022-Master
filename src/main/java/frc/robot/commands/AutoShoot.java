//Don't let the name fool you. This is the EVERYTHING for autonomous.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.MoveBall;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.IntakeArm;

public class AutoShoot extends SequentialCommandGroup {
    /**
     * Creates a new AutoShoot.
     */
    public AutoShoot(Flywheel m_flyWheel, MoveBall m_conveyor, DriveTrain m_DriveTrain, Intake m_Intake, IntakeArm m_IntakeArm) {
      // Add your commands in the super() call, e.g.
      // super(new FooCommand(), new BarCommand());
      super(
        //These are all the (current) autonomous commands.
        //new ArmControlReverse(m_IntakeArm).withTimeout(1.0),
        //new AutoDriveIntake(m_Intake, m_DriveTrain).withTimeout(0.5),
        //new AutoDriveForwards(m_DriveTrain).withTimeout(2.0)
        //new AutoDriveBackwards(m_DriveTrain).withTimeout(0.9),
        //new ShootBall(m_flyWheel, m_conveyor).withTimeout(2.0),
        new ShootBall(m_flyWheel, m_conveyor).withTimeout(2.0),
        new AutoDriveForward(m_DriveTrain).withTimeout(1.0),
        new ArmControlReverse(m_IntakeArm).withTimeout(1.0)
        ); 
    }
  } 
 