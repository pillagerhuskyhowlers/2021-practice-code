// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.util;


/** Add your docs here. */
public class Utils {
    /**
     * Limit value from -1.0 to 1.0
     */
    public static double limit(double value){
      if(value<=-1.0)
         return -1.0;
     else if(value>=1.0)
         return 1.0;
      else 
         return value;
     }

     //Treat values witin specified deadband as zero

     public static double applyDeadband(double value, double deadband){
       if(Math.abs(value)<deadband)
       return 0.0;
       else 
        return value;
        
     }

}
