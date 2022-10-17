//Don't let the name fool you. This is the EVERYTHING for autonomous. 
//This is a 3 ball autonomous (meaning it shoots 3 balls during the entirety of the autnonomous phase)

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.MoveBall;
import frc.robot.subsystems.DriveTrain;
import oi.limelightvision.limelight.frc.LimeLight;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.IntakeArm;

public class AutoShoot3 extends SequentialCommandGroup {
    /**
     * Creates a new AutoShoot.
     */
    public AutoShoot3(Flywheel m_flyWheel, MoveBall m_conveyor, DriveTrain m_DriveTrain, Intake m_Intake, IntakeArm m_IntakeArm, LimeLight m_limeLight){
      // Add your commands in the super() call, e.g.
      // super(new FooCommand(), new BarCommand());
      addCommands(
        /*
        These are all the (current) autonomous commands.
        new ArmControlReverse(m_IntakeArm).withTimeout(1.0)
        new AutoDriveIntake(m_Intake, m_DriveTrain).withTimeout(1.0)
        new AutoDriveForwards(m_DriveTrain).withTimeout(1.0)
        new AutoDriveBackwards(m_DriveTrain).withTimeout(1.0)
        new ShootBall(m_flyWheel, m_conveyor, m_IntakeArm).withTimeout(1.0)
        new Drive_and_Shoot(m_flyWheel, m_conveyor, m_DriveTrain, m_limeLight).withTimeout(1.0)
        new AutoDriveLeft(m_DriveTrain).withTimeout(1.0)
        new AutoDriveRight(m_DriveTrain).withTimeout(1.0)
        new AutoIntake(m_Intake, m_conveyor).withTimeout(1.0),
        new AutoTurnLeft(m_DriveTrain).withTimeout(0.3)
        new AutoTurnRight(m_DriveTrain).withTimeout(0.4),


        */

    ///New autonomous to try? Three (four with human player?) ball in theory, using limelight to correct any adjustment errors.
    //Christian's 3 Ball Auto #2 (good one)
    new ArmControlReverse(m_IntakeArm).withTimeout(0.01),
    new ArmControl(m_IntakeArm).withTimeout(0.01),
    new ArmControlReverse(m_IntakeArm).withTimeout(0.5),
    new AutoDriveIntake(m_Intake, m_DriveTrain).withTimeout(0.26),
    new AutoIntake(m_Intake, m_conveyor).withTimeout(2),
    new AutoDriveBackwards(m_DriveTrain).withTimeout(0.22),
    new LowerConveyorEject(m_conveyor).withTimeout(0.1),
    //new AutoTurnRight(m_DriveTrain).withTimeout(0.05),
    //new AutoIntake(m_Intake, m_conveyor).withTimeout(3),
    new AutoDriveForward (m_DriveTrain).withTimeout(0.1),
    new ShootBall(m_flyWheel, m_conveyor, m_IntakeArm).withTimeout(3.0)
    //new Drive_and_Shoot(m_flyWheel, m_conveyor, m_DriveTrain, m_limeLight).withTimeout(3.0),
    //new AutoTurnRight(m_DriveTrain).withTimeout(0.1),
    //new AutoDriveRight(m_DriveTrain).withTimeout(0.7),
    //new AutoDriveRight(m_DriveTrain).withTimeout(0.7),
    //new AutoDriveIntake(m_Intake, m_DriveTrain).withTimeout(0.5),
    //new AutoIntake(m_Intake, m_conveyor).withTimeout(1),
    //new AutoDriveBackwards(m_DriveTrain).withTimeout(0.33),
    //new AutoTurnRight(m_DriveTrain).withTimeout(0.05),
    //new AutoIntake(m_Intake, m_conveyor).withTimeout(3)
    //new ShootBall(m_flyWheel, m_conveyor, m_IntakeArm).withTimeout(3.0)
    //new Drive_and_Shoot(m_flyWheel, m_conveyor, m_DriveTrain, m_limeLight).withTimeout(3.0)
        


        /* Random stuff we arent using right now 

        Raymond old auto #1
        //new AutoDriveRight(m_DriveTrain).withTimeout(2.5),
        //new AutoDriveIntake(m_Intake, m_DriveTrain).withTimeout(1.5),
        //new AutoDriveLeft(m_DriveTrain).withTimeout(4.5)
        //new Drive_and_Shoot(m_flyWheel, m_conveyor, m_DriveTrain, m_limeLight).withTimeout(3),
        //new AutoDriveRight(m_DriveTrain).withTimeout(0.7),
        //new AutoDriveIntake(m_Intake, m_DriveTrain).withTimeout(2.5),
        //new AutoIntake(m_Intake, m_conveyor).withTimeout(1.0),
        //new AutoDriveBackwards(m_DriveTrain).withTimeout(2.5),
        //new AutoIntake(m_Intake, m_conveyor).withTimeout(2.4)
        //new Drive_and_Shoot(m_flyWheel, m_conveyor, m_DriveTrain, m_limeLight).withTimeout(2.4)
        
        
        Christian 3 ball auto #1
        new ArmControlReverse(m_IntakeArm).withTimeout(0.1),
        new ArmControl(m_IntakeArm).withTimeout(0.1),
        new ArmControlReverse(m_IntakeArm).withTimeout(0.5),
        new AutoDriveIntake(m_Intake, m_DriveTrain).withTimeout(0.9),
        new AutoDriveBackwards(m_DriveTrain).withTimeout(0.3),
        new LowerConveyorEject(m_conveyor).withTimeout(0.1),
        new AutoIntake(m_Intake, m_conveyor).withTimeout(2),
        new AutoDriveBackwards(m_DriveTrain).withTimeout(0.6),
        new AutoDriveRight(m_DriveTrain).withTimeout(2.8),
        new AutoTurnRight(m_DriveTrain).withTimeout(0.35),
        new AutoDriveIntake(m_Intake, m_DriveTrain).withTimeout(1.5),
        new AutoDriveBackwards(m_DriveTrain).withTimeout(1),
        new AutoTurnLeft(m_DriveTrain).withTimeout(0.05)


        Christian's 3 Ball Auto #2 (good one)
        new ArmControlReverse(m_IntakeArm).withTimeout(0.1),
        new ArmControl(m_IntakeArm).withTimeout(0.1),
        new ArmControlReverse(m_IntakeArm).withTimeout(0.5),
        new AutoDriveIntake(m_Intake, m_DriveTrain).withTimeout(0.22),
        new AutoIntake(m_Intake, m_conveyor).withTimeout(1),
        new AutoDriveBackwards(m_DriveTrain).withTimeout(0.22),
        new LowerConveyorEject(m_conveyor).withTimeout(0.1),
        new AutoTurnLeft(m_DriveTrain).withTimeout(0.04),
        new AutoIntake(m_Intake, m_conveyor).withTimeout(3),
        new AutoTurnRight(m_DriveTrain).withTimeout(0.11),
        new AutoDriveRight(m_DriveTrain).withTimeout(0.75),
        new AutoDriveRight(m_DriveTrain).withTimeout(0.7),
        new AutoDriveIntake(m_Intake, m_DriveTrain).withTimeout(0.5),
        new AutoIntake(m_Intake, m_conveyor).withTimeout(1),
        new AutoDriveBackwards(m_DriveTrain).withTimeout(0.33),
        new AutoTurnRight(m_DriveTrain).withTimeout(0.05),
        new AutoIntake(m_Intake, m_conveyor).withTimeout(3),


        
        */
        );
    }
} 
    
