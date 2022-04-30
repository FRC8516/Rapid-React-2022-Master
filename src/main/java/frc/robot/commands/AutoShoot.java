//Don't let the name fool you. This is the EVERYTHING for autonomous. 
//It is a two ball (meaning it shoots two balls during the entirety of the autonomous phase).

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.MoveBall;
import frc.robot.subsystems.DriveTrain;
import oi.limelightvision.limelight.frc.LimeLight;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.IntakeArm;

public class AutoShoot extends SequentialCommandGroup {
    /**
     * Creates a new AutoShoot.
     */
    public AutoShoot(Flywheel m_flyWheel, MoveBall m_conveyor, DriveTrain m_DriveTrain, Intake m_Intake, IntakeArm m_IntakeArm, LimeLight m_limeLight){
      // Add your commands in the super() call, e.g.
      // super(new FooCommand(), new BarCommand());
      addCommands(
        /*
        These are all the (current) autonomous commands.
        new ArmControlReverse(m_IntakeArm).withTimeout(1.0)
        new AutoDriveIntake(m_Intake, m_DriveTrain).withTimeout(1.0)
        new AutoDriveForwards(m_DriveTrain).withTimeout(1.0)
        new AutoDriveBackwards(m_DriveTrain).withTimeout(1.0)
        new ShootBall(m_flyWheel, m_conveyor).withTimeout(1.0)
        --> wrong new Drive_and_Shoot(m_flyWheel, m_conveyor, m_DriveTrain, m_limeLight, m_joystick).withTimeout(1.0)
        */

        //Current autonomous.
        //new ShootBall(m_flyWheel, m_conveyor).withTimeout(2.0),
        //new AutoDriveForward(m_DriveTrain).withTimeout(1.0)
        //);

    ///New autonomous to try? Two ball in theory, using limelight to correct any adjustment errors.
    
        //new AutoDriveForward(m_DriveTrain).withTimeout(0.2),
        //new Drive_and_Shoot(m_flyWheel, m_conveyor, m_DriveTrain, m_limeLight).withTimeout(3),
        new ArmControlReverse(m_IntakeArm).withTimeout(0.1),
        new ArmControl(m_IntakeArm).withTimeout(0.1),
        new ArmControlReverse(m_IntakeArm).withTimeout(1.0),
        new AutoDriveIntake(m_Intake, m_DriveTrain).withTimeout(0.9),
        new AutoDriveBackwards(m_DriveTrain).withTimeout(0.6),
        new LowerConveyorEject(m_conveyor).withTimeout(0.1),
        new Drive_and_Shoot(m_flyWheel, m_conveyor, m_DriveTrain, m_limeLight).withTimeout(4),
        new ArmControl(m_IntakeArm).withTimeout(1.0)
        ); 
    }

  } 
 /*     new ArmControlReverse(m_IntakeArm).withTimeout(0.1),
        new ArmControl(m_IntakeArm).withTimeout(0.1),
        new ArmControlReverse(m_IntakeArm).withTimeout(1.0),
        new AutoDriveIntake(m_Intake, m_DriveTrain).withTimeout(2.2),
        new AutoDriveBackwards(m_DriveTrain).withTimeout(1.9),
        new LowerConveyorEject(m_conveyor).withTimeout(0.1),
        new Drive_and_Shoot(m_flyWheel, m_conveyor, m_DriveTrain, m_limeLight).withTimeout(4),
        new ArmControl(m_IntakeArm).withTimeout(1.0) */