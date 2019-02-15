package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Climber;
import frc.robot.AutoClimb;

import static frc.robot.Climber.Location.FRONT;
import static frc.robot.Climber.Location.BACK;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
	Climber climberFront;
  	Climber climberBack;
 	Climber climberLeftWheel;
  	Climber climberRightWheel;

	final String defaultAuto = "Default";
	final String customAuto = "My Auto";
	String autoSelected;
	public Joystick leftStick = new Joystick(RobotMap.LEFT_JOYSTICK);
	public Joystick rightStick = new Joystick(RobotMap.RIGHT_JOYSTICK);
	private Joystick manipulatorStickL = new Joystick(RobotMap.LEFT_MANIPULATOR_STICK);
	private Joystick manipulatorStickR = new Joystick(RobotMap.RIGHT_MANIPULATOR_STICK);
	public GenericHID driverGamepad =  new Joystick(RobotMap.DRIVER_GAMEPAD);
	SendableChooser<String> chooser = new SendableChooser<>();
	JoystickButton frButton = new JoystickButton(leftStick, RobotMap.FRONT_RIGHT_BUTTON);
	JoystickButton flButton = new JoystickButton(leftStick, RobotMap.FRONT_LEFT_BUTTON);
	JoystickButton brButton = new JoystickButton(leftStick, RobotMap.BACK_RIGHT_BUTTON);
	JoystickButton blButton = new JoystickButton(leftStick, RobotMap.BACK_LEFT_BUTTON);
	JoystickButton leftTrigger = new JoystickButton(leftStick, RobotMap.LEFT_TRIGGER);
	JoystickButton rightTrigger = new JoystickButton(rightStick, RobotMap.RIGHT_TRIGGER);
	JoystickButton tuningActivation = new JoystickButton(leftStick, RobotMap.LEFT_SWERVE_TUNING_BUTTON);
	JoystickButton stickTriggerL = new JoystickButton(manipulatorStickL, RobotMap.LEFT_MANIPULATOR_TRIGGER);
	JoystickButton stickTriggerR = new JoystickButton(manipulatorStickR, RobotMap.RIGHT_MANIPULATOR_TRIGGER);
	JoystickButton stickThumbL = new JoystickButton(manipulatorStickL, RobotMap.LEFT_MANIPULATOR_THUMB_BUTTON);
	JoystickButton stickThumbR = new JoystickButton(manipulatorStickR, RobotMap.RIGHT_MANIPULATOR_THUMB_BUTTON);

	public JoystickButton driverGamepadStartButton = new JoystickButton(driverGamepad, RobotMap.START_BUTTON_VALUE);
	public JoystickButton driverGamepadBackButton = new JoystickButton(driverGamepad, RobotMap.BACK_BUTTON_VALUE);

	public JoystickButton autoClimbButton = new JoystickButton(manipulatorStickL, 6); //find actual button number
	public JoystickButton stopAutoClimbButton = new JoystickButton(manipulatorStickR, 7); //find actual button number

	AutoClimb autoClimb;

	Climber climber;

	boolean driveMode = false;

	boolean autoClimbMode = false;
	
	GamepadSwerve swerveDrive = new GamepadSwerve();

  	boolean alignState = false;

	@Override
	public void robotInit() {
		swerveDrive.swerveInit();

		climber = new Climber(RobotMap.SPEED_DEFAULT_DRIVE, RobotMap.SPEED_DEFAULT_CLIMB);

		autoClimb = new AutoClimb(climber, swerveDrive);

	}

	@Override
	public void teleopPeriodic() {
		swerveDrive.runSwerve(driverGamepad, driverGamepadStartButton, driverGamepadBackButton, frButton, flButton, blButton, brButton);
		climberControl();

	}

	@Override
	public void testPeriodic() {
		//swerveDrive.individualModuleControl(frButton.get(), flButton.get(), brButton.get(), blButton.get());
		
	}

	//Code below here is not particular to swerve, temporary presence, for line alignment, auto-intervention
	public void autoAlign() {
		
		//swerveDrive.syncroDrive(0.5, 90, 0);
	}

	public void climberControl() {
		double yPosL = manipulatorStickL.getY();
    	boolean stickTriggerLeft = stickTriggerL.get();
    	boolean stickTriggerRight = stickTriggerR.get();
    	boolean stickThumbLeft = stickThumbL.get();
		boolean stickThumbRight = stickThumbR.get();

		//check logic
		if (autoClimbButton.get()) {
			autoClimbMode = true;
			autoClimb.autoClimbInit();
		}else if(stopAutoClimbButton.get()) {
			autoClimbMode = false;
		}

		if (autoClimbMode == true) {
			if (autoClimb.autoClimbFinished()) {
				autoClimbMode = false;
			}
			return;
		}
		
		// The 0.25 and -0.25 are so that the joystick doesn't have to be perfectly centered to stop
		if (yPosL < 0.25) {
			climber.driveForward();
			} else if (yPosL > -0.25) {
			climber.driveReverse();
			} else {
			climber.stopDriving();
			}

			if (stickTriggerLeft) {
				climber.up(FRONT);
			} else if (stickThumbLeft) {
				climber.down(FRONT);
			} else {
				climber.stopClimbing(FRONT);
			}

			if (stickTriggerRight) {
				climber.up(BACK);
			} else if (stickThumbRight) {
				climber.down(BACK);
			} else {
			climber.stopClimbing(BACK);
			}
	}

}

