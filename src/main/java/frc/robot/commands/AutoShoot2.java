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

public class AutoShoot2 extends SequentialCommandGroup {
    /**
     * Creates a new AutoShoot.
     */
    public AutoShoot2(Flywheel m_flyWheel, MoveBall m_conveyor, DriveTrain m_DriveTrain, Intake m_Intake, IntakeArm m_IntakeArm, LimeLight m_limeLight){
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

    ///New autonomous to try? Two ball in theory, using limelight to correct any adjustment errors.
    
      //new AutoDriveForward(m_DriveTrain).withTimeout(0.2),
      //new Drive_and_Shoot(m_flyWheel, m_conveyor, m_DriveTrain, m_limeLight).withTimeout(3),
      new ArmControlReverse(m_IntakeArm).withTimeout(0.1),
      new ArmControl(m_IntakeArm).withTimeout(0.1),
      new ArmControlReverse(m_IntakeArm).withTimeout(0.5),
      //ArmControlReverse drops the arm. ArmControl raises it. The stutter here (of drop arm/pull up/drop) is because it gave me trouble sometimes when I only did one command, but it stopped giving me trouble when I did a bunch. It's probably something to do with the way I wrote the command and the solenoids sometimes being left in the wrong position for the position the intake is in.
      new AutoDriveIntake(m_Intake, m_DriveTrain).withTimeout(0.26),
      new AutoIntake(m_Intake, m_conveyor).withTimeout(2),
      new AutoDriveBackwards(m_DriveTrain).withTimeout(0.25),
      new AutoDriveForward(m_DriveTrain).withTimeout(0.1),
      new LowerConveyorEject(m_conveyor).withTimeout(0.3),
      //new AutoTurnLeft(m_DriveTrain).withTimeout(0.04),
      //new AutoIntake(m_Intake, m_conveyor).withTimeout(3),
      //new ShootBall(m_flyWheel, m_conveyor, m_IntakeArm).withTimeout(3.0),
      new ShootBall(m_flyWheel, m_conveyor, m_IntakeArm).withTimeout(2.0),
      //new Drive_and_Shoot(m_flyWheel, m_conveyor, m_DriveTrain, m_limeLight).withTimeout(3.0),
      new AutoDriveForward(m_DriveTrain).withTimeout(0.2)
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
        new ArmControl(m_IntakeArm).withTimeout(1.0)
        
Christian's 2 Ball Auto #1
        new ArmControlReverse(m_IntakeArm).withTimeout(0.1),
        new ArmControl(m_IntakeArm).withTimeout(0.1),
        new ArmControlReverse(m_IntakeArm).withTimeout(0.5),
        new AutoDriveIntake(m_Intake, m_DriveTrain).withTimeout(0.22),
        new AutoIntake(m_Intake, m_conveyor).withTimeout(1),
        new AutoDriveBackwards(m_DriveTrain).withTimeout(0.22),
        new LowerConveyorEject(m_conveyor).withTimeout(0.1),
        new AutoTurnLeft(m_DriveTrain).withTimeout(0.04),
        new AutoIntake(m_Intake, m_conveyor).withTimeout(3),

        */