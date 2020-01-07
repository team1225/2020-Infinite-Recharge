/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.CANDigitalInput;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.TimedRobot;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This is a demo program showing the use of the DifferentialDrive class.
 * Runs the motors with arcade steering.
 */
public class Robot extends TimedRobot {
  private final int leftMotorID  = 10;
  private final int rightMotorID = 11;

  private CANSparkMax m_leftMotor;
  private CANSparkMax m_rightMotor;
  private CANEncoder m_rightEncoder;
  private CANEncoder m_leftEncoder;

  //private DifferentialDrive m_robotDrive;
  private PWMTalonSRX m_test_motor0;
  private Joystick m_stick;

  @Override
  public void robotInit() {
    m_leftMotor  = new CANSparkMax(leftMotorID, MotorType.kBrushless);
    m_rightMotor = new CANSparkMax(rightMotorID, MotorType.kBrushless);

    m_leftMotor.restoreFactoryDefaults();
    m_rightMotor.restoreFactoryDefaults();

    m_rightEncoder = m_rightMotor.getEncoder();
    m_rightEncoder.setPosition(0);
    m_leftEncoder = m_leftMotor.getEncoder();
    m_leftEncoder.setPosition(0);

    //m_robotDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);
    
    m_rightMotor.enableSoftLimit(CANSparkMax.SoftLimitDirection.kForward, false);
    m_rightMotor.setSoftLimit(CANSparkMax.SoftLimitDirection.kForward, 69);
    m_rightMotor.enableSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, false);
    m_rightMotor.setSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, 0);

    m_stick = new Joystick(0);

    m_test_motor0 = new PWMTalonSRX(0);
  }

  /**
   * Periodic code for all robot modes
   */
  @Override
  public void robotPeriodic() {
    // Intentionally Empty
  }

  /**
   * Initialization code for teleop mode
   */
  @Override
  public void teleopInit() {
    // Intentionally Empty
  }

  @Override
  public void teleopPeriodic() {
    // Drive with arcade drive.
    // That means that the Y axis drives forward
    // and backward, and the X turns left and right.
    //m_robotDrive.arcadeDrive(m_stick.getY()*.30, m_stick.getX()*.50);

    //m_rightMotor.set(m_stick.getY());\
    m_test_motor0.set(m_stick.getY());
  }

  /**
   * Initialization code for disabled mode
   */
  @Override
  public void disabledInit() {
    // Intentionally Empty
  }

  /**
   * Periodic code for disabled mode
   */
  @Override
  public void disabledPeriodic() {
    // Intentionally Empty
  }

  /**
   * Initialization code for autonomous mode
   */
  @Override
  public void autonomousInit() {
    // Intentionally Empty
  }

  /**
   * Periodic code for autonomous mode
   */
  @Override
  public void autonomousPeriodic() {
    // Intentionally Empty
  }

  /**
   * Initialization code for test mode
   */
  @Override
  public void testInit() {
    // Intentionally Empty
  }

  /**
   * Periodic code for test mode
   */
  @Override
  public void testPeriodic() {
    // Intentionally Empty
  }
}
