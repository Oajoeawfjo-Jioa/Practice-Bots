// Copyright (c) 2022 Team 303

package frc.robot;

/*
TODO Change around all the CAN IDs to fit
*/

public final class RobotMap {

	public static final class DrivebaseConstants {

		/*Speed Multipliers for uneven motor speeds*/
		public static final double LEFT_MULTIPLIER = 1;
		public static final double RIGHT_MULTIPLIER = 1;
		//public static final double Z_ROTATION_MULTIPLIER = LEFT_MULTIPLIER > RIGHT_MULTIPLIER ? -LEFT_MULTIPLIER/RIGHT_MULTIPLIER: RIGHT_MULTIPLIER/LEFT_MULTIPLIER;

		/* CAN IDs of the Motors on the Drive Base */
		public static final int LEFT_SPARK_ID = 1;
		public static final int RIGHT_SPARK_ID = 2;

		/* Encoder CAN IDs */
		public static final int LEFT_CANCODER_ID = 1;
		public static final int RIGHT_CANCODER_ID = 6;

		/* Drivebase Motor Inversion */
		public static final boolean LEFT_SPARK_INVERTED = false;
		public static final boolean RIGHT_SPARK_INVERTED = false;

		/* Motor Encoder Calculations */
		public static final double WHEEL_DIAMTER = 6; // Diameter in inches
		public static final int ENCODER_COUNTS_PER_REV = 42; // Neo Hall Effect Sensor
		public static final double DRIVE_GEAR_RATIO = 12.75; // Toughbox mini 12.75:1
		public static final double DISNATCE_PER_ENCODER_PULSE; // Inches traveled for each encoder unit

		static {
			double wheelCircumference = WHEEL_DIAMTER * Math.PI;
			double motorRotationsPerEncoderPulse = 1 / ENCODER_COUNTS_PER_REV;
			double axelRotationsPerMotorRotation = 1 / DRIVE_GEAR_RATIO;

			DISNATCE_PER_ENCODER_PULSE = motorRotationsPerEncoderPulse
					* axelRotationsPerMotorRotation
					* wheelCircumference;
		}
	}

	public static final class IOConstants {

		public static final int LEFT_JOYSTICK_ID = 1;
		public static final int RIGHT_JOYSTICK_ID = 2;
		public static final int OPERATOR_CONTROLLER = 0;
	}
}
