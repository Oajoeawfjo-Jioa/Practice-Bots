// Copyright (c) 2022 Team 303

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.RobotMap.DrivebaseConstants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.networktables.GenericEntry;

public class DrivebaseSubsystem extends SubsystemBase {

	/* ShuffleBoard */
	public static final ShuffleboardTab DRIVEBASE_TAB = Shuffleboard.getTab("Drivebase");

	public static final GenericEntry LEFT_ENCODER_ENTRY = DRIVEBASE_TAB.add("Left Encoder", 0).getEntry();
	public static final GenericEntry RIGHT_ENCODER_ENTRY = DRIVEBASE_TAB.add("Right Encoder", 0).getEntry();
	public static final GenericEntry ENCODER_DISTANCE_ENTRY = DRIVEBASE_TAB.add("Encoder Distance", 0).getEntry();

	/* Left Motors */
	private final CANSparkMax leftSparkMax;

	/* Right Motors */
	private final CANSparkMax rightSparkMax;

	/* Encoders */
	/*
	private final RelativeEncoder frontLeftEncoder;
	private final RelativeEncoder backLeftEncoder;
	private final RelativeEncoder frontRightEncoder;
	private final RelativeEncoder backRightEncoder;*/

	private double maxOutput = 1;

	public DrivebaseSubsystem() {
		/* Left Motors */
		leftSparkMax = new CANSparkMax(DrivebaseConstants.LEFT_SPARK_ID, MotorType.kBrushless);

		leftSparkMax.setIdleMode(IdleMode.kBrake);

		leftSparkMax.setInverted(DrivebaseConstants.LEFT_SPARK_INVERTED);


		/* Right Motors */
		rightSparkMax = new CANSparkMax(DrivebaseConstants.RIGHT_SPARK_ID, MotorType.kBrushless);

		rightSparkMax.setIdleMode(IdleMode.kBrake);

		rightSparkMax.setInverted(DrivebaseConstants.RIGHT_SPARK_INVERTED);


		/* All Together */

		/* Encoders */
		/*
		frontLeftEncoder = leftFrontSparkMax.getEncoder();
		backLeftEncoder = leftBackSparkMax.getEncoder();
		frontRightEncoder = rightFrontSparkMax.getEncoder();
		backRightEncoder = rightBackSparkMax.getEncoder();*/
	}

	public void drive(double leftSpeed, double rightSpeed) {
		rightSparkMax.set(leftSpeed);
		leftSparkMax.set(rightSpeed);
		//this.drive.tankDrive(leftSpeed*DrivebaseConstants.LEFT_MULTIPLIER, rightSpeed*DrivebaseConstants.RIGHT_MULTIPLIER);
	}

	/*
	public void drive(double leftSpeed, double rightSpeed, boolean squareInputs) {
		this.drive.tankDrive(leftSpeed*DrivebaseConstants.LEFT_MULTIPLIER, rightSpeed*DrivebaseConstants.RIGHT_MULTIPLIER, squareInputs);
	}

	public void arcadeDrive(double power, double turningPower, boolean squareInputs) {
		this.drive.arcadeDrive(power, turningPower, squareInputs);
	}

	public void arcadeDrive(double power, double turningPower) {
		this.drive.arcadeDrive(power, turningPower);
	}*/

	/*

	public void resetEncoders() {
		frontLeftEncoder.setPosition(0);
		backLeftEncoder.setPosition(0);
		frontRightEncoder.setPosition(0);
		backRightEncoder.setPosition(0);
	}*/
	/*
	public int getLeftEncoder() {
		// Take average of both encoders
		return (int) ((frontLeftEncoder.getPosition() + backLeftEncoder.getPosition()) / 2);
	}

	public int getRightEncoder() {
		// Take average of both encoders
		return (int) ((frontRightEncoder.getPosition() + backRightEncoder.getPosition()) / 2);
	}*/

	/**
	 * Converts encoder units to inches
	 * 
	 * @return
	 */
	/*
	private static double encoderUnitsToInches(double encoderUnits) {
		return encoderUnits * DrivebaseConstants.DISNATCE_PER_ENCODER_PULSE;
	}*/

	/**
	 * Measures how far the robot should have traveled (in inches)
	 * based on the left motor's measured rotation
	 */
	/*
	public double getLeftEncoderDistance() {
		return encoderUnitsToInches(getLeftEncoder());
	}*/

	/**
	 * Measures how far the robot should have traveled (in inches)
	 * based on the right motor's measured rotation
	 */
	/*
	public double getRightEncoderDistance() {
		return encoderUnitsToInches(getRightEncoder());
	}*/

	/**
	 * Takes the average of both motor encoders to calculate how far
	 * the robot should have traveled (assuming a straight path)
	 */

	/*
	public double getAverageEncoderDistance() {
		return (getLeftEncoderDistance() + getRightEncoderDistance()) / 2.0;
	}*/

	/**
	 * Sets the max output of the drive. Useful for scaling the drive to drive more
	 * slowly.
	 *
	 * @param maxOutput the maximum output to which the drive will be constrained
	 */

	public double getMaxOutput() {
		return this.maxOutput;
	}

	@Override
	public void periodic() {
		/* Update ShuffleBoard */
		/*
		LEFT_ENCODER_ENTRY.setDouble(getLeftEncoder());
		RIGHT_ENCODER_ENTRY.setDouble(getRightEncoder());
		ENCODER_DISTANCE_ENTRY.setDouble(getAverageEncoderDistance());*/
	}
}
