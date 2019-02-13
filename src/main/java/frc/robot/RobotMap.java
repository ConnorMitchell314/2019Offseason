package frc.robot;

public class RobotMap { 
	//Joysticks
	public static final int LEFT_JOYSTICK = 0;
	public static final int RIGHT_JOYSTICK = 1;
	public static final int LEFT_MANIPULATOR_STICK = 2;
    public static final int RIGHT_MANIPULATOR_STICK = 3;
    
    public static final int DRIVER_GAMEPAD = 0;

    //Driver Gamepad Buttons AND axis:
    public static final int RIGHT_STICK_X_AXIS = 0;
    public static final int RIGHT_STICK_Y_AXIS = 1;
    public static final int LEFT_TRIGGER_AXIS = 2;
    public static final int RIGHT_TRIGGER_AXIS = 3;
    public static final int LEFT_STICK_X_AXIS = 4;
    public static final int LEFT_STICK_Y_AXIS = 5;

    public static final int START_BUTTON_VALUE = 8;
    public static final int BACK_BUTTON_VALUE = 7;

	//Left Stick Buttons:
	public static final int LEFT_TRIGGER = 1;
	public static final int LEFT_SWERVE_TUNING_BUTTON = 7;
	public static final int FRONT_RIGHT_BUTTON = 6;
	public static final int FRONT_LEFT_BUTTON = 5;
	public static final int BACK_RIGHT_BUTTON = 4;
	public static final int BACK_LEFT_BUTTON = 3;
	//Right Stick Buttons:
	public static final int RIGHT_TRIGGER = 1;

	//Left Manipulator Stick Buttons:
	public static final int LEFT_MANIPULATOR_TRIGGER = 1;
	public static final int LEFT_MANIPULATOR_THUMB_BUTTON = 2;

	//Right Manipulator Stick Buttons:
	public static final int RIGHT_MANIPULATOR_TRIGGER = 1;
	public static final int RIGHT_MANIPULATOR_THUMB_BUTTON = 2;

	//Robot Ports
    public static final int DRIVE_FRONT_RIGHT_MOTOR = 0;
	public static final int DRIVE_FRONT_LEFT_MOTOR = 2;
	public static final int DRIVE_BACK_LEFT_MOTOR = 4;
	public static final int DRIVE_BACK_RIGHT_MOTOR = 6;

	public static final int STEER_FRONT_RIGHT_MOTOR = 1;
	public static final int STEER_FRONT_LEFT_MOTOR = 3;
	public static final int STEER_BACK_LEFT_MOTOR = 5;
	public static final int STEER_BACK_RIGHT_MOTOR = 7;

	public static final int ENCODER_ZERO_VALUE_FRONT_RIGHT = 257;
	public static final int ENCODER_ZERO_VALUE_FRONT_LEFT = 17;
	public static final int ENCODER_ZERO_VALUE_BACK_LEFT = 288;
	public static final int ENCODER_ZERO_VALUE_BACK_RIGHT = 190;

	public static final int ENCODER_FRONT_RIGHT = 0;
	public static final int ENCODER_FRONT_LEFT = 1;
	public static final int ENCODER_BACK_LEFT = 2;
	public static final int ENCODER_BACK_RIGHT = 3;

	//need to get real numbers for drive encoders
	public static final int DRIVE_ENCODER_FRONT_RIGHT_A = 10;
	public static final int DRIVE_ENCODER_FRONT_RIGHT_B = 11;
	public static final int DRIVE_ENCODER_FRONT_LEFT_A = 12;
	public static final int DRIVE_ENCODER_FRONT_LEFT_B = 13;
	public static final int DRIVE_ENCODER_BACK_LEFT_A = 14;
	public static final int DRIVE_ENCODER_BACK_LEFT_B = 15;
	public static final int DRIVE_ENCODER_BACK_RIGHT_A = 16;
	public static final int DRIVE_ENCODER_BACK_RIGHT_B = 17;

	// all CANs for robot
	public static final int CAN_CLIMBER_FRONT = 7;
    public static final int CAN_CLIMBER_BACK = 9;
    public static final int CAN_CLIMBER_WHEEL_LEFT = 3;
	public static final int CAN_CLIMBER_WHEEL_RIGHT = 5;
	
	// Motor Speeds
    public static final double SPEED_DEFAULT_TEST = 0.75;
	
	public static final double DEFAULT_FIND_SPEED = 0.5;

	// Ultrasonic Sensors
	public static final double ULTRASONIC_VOLTAGE_TO_INCHES = 0.0098;
	
	// Wheels
	public static final double WHEEL_DIAMETER = 4;
	public static final double WHEEL_CIRCUMFERENCE = Math.PI * WHEEL_DIAMETER;

	//dimensions of the robot in CM
	public static final int ROBOT_X_IN_CM = 51;
	public static final int ROBOT_Y_IN_CM = 51;
	
	public static final double TRANSLATION_DEADZONE = 0.1;
	public static final double ROTATION_DEADZONE = 0.1;
	public static final double ABSOLUTE_ROTATION_DEADZONE = 0.3;
    
}