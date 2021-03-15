package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.SubSystem;

public class RobotContainer {

    private final SubSystem subSystem;
    private final DriveCommand driveTrainCommand;

    private final Joystick controller;

    public RobotContainer() {
        controller = new Joystick(0);
        subSystem = new SubSystem();
        driveTrainCommand = new DriveCommand(subSystem,
                () -> controller.getRawAxis(Constants.speedJoyStick) * Constants.speedJoyStickScaler,
                () -> controller.getRawAxis(Constants.rotationJoyStick) * Constants.rotationJoyStickScaler);
        subSystem.setDefaultCommand(driveTrainCommand);
        configureButtonBindings();
    }

    private void configureButtonBindings() {
    }

    public Command getAutonomousCommand() {
        return null;
    }
}
