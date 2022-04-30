//Playground for testing autonomous commands.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.MoveBall;


public class AutoIntake extends SequentialCommandGroup{ 
    //public AutoIntake (Intake m_Intake, DriveTrain m_DriveTrain){
    public AutoIntake (Intake m_Intake, MoveBall m_lowerConveyor){
        super(
            new ConveyorIntake(m_lowerConveyor, m_Intake)
        );



    }
}
