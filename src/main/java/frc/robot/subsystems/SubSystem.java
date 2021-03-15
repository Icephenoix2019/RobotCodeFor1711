// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SubSystem extends SubsystemBase {

    private final WPI_TalonSRX rwTalon;

    private final WPI_VictorSPX lwTalon;

    private final DifferentialDrive diffDrive;

    public SubSystem() {
        rwTalon = new WPI_TalonSRX(Constants.RwTalon);
        lwTalon = new WPI_VictorSPX(Constants.LwTalon);

        diffDrive = new DifferentialDrive(lwTalon, rwTalon);
    }

    public void arcadeDrive(double speed, double rotation) {
        diffDrive.arcadeDrive(speed, rotation);
    }

    public void stop() {
        rwTalon.set(0);
        lwTalon.set(0);
    }

    @Override
    public void periodic() {

    }

    @Override
    public void simulationPeriodic() {

    }
}
