//Playground for testing autonomous commands.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;


public class AutoDriveIntake extends ParallelCommandGroup{ 
    public AutoDriveIntake (Intake m_Intake, DriveTrain m_DriveTrain){
        super(
            //new ShootBall(m_flyWheel, m_conveyor).withTimeout(2.0),
            new AutoDriveForward(m_DriveTrain),
            new IntakeBall(m_Intake)
        );



    }
}
