/* Bad. Just dont worry about this
package frc.robot.commands;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.commands.AutoShoot;
import frc.robot.commands.AutoShoot1;

public class AutoChooser {
}

private ShuffleboardTab VarTab = Shuffleboard.getTab("Variables");
private NetworkTableEntry m_AutoChooser = VarTab.add("2ball auto", true).getEntry();{

public m_AutoCommand();
      if(m_AutoChooser.setBoolean(true)){
    m_AutoCommand = m_autoShoot;
  }else{
    m_AutoCommand = m_AutoShoot1;
  }
}}
*/