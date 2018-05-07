/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 *
 * @author aramshanker
 */
/**
 * Interface for any enumeration-pattern classes which encapsulate valid value
 * lists which are served to the application via the ValidValue class. 
 * 
 * Further explanation: The ValidValues class serves up valid values as key/value (code/name) pairs
 * to the rest of the application(s). @see ValidValues and related classes.
 * However, some of the valid values are enumerated in code via classes which implement a fairly
 * standard Java enumeration pattern (private constructor, static final enumerated instances, etc)
 * (@see com.csc.er.common.domain.attributes.values.rfd.RFDType for example). For these special enumerations,
 * the ValidValueSet method which loads the rest of the valid values from the database will load these
 * special valid values from the appropriate enumeration class. Each such enumeration class should
 * implement this interface. 
 * 
 * IN ADDITION, each class which implements this interface should also include public static Collection getValues(). 
 * We can't include that on the interface because it's static, but please keep it in mind. 
 * @author fabiobr
 */
public interface EnumeratedValidValue extends Comparable{

  /**
   * @return The code or id for the enumerated instance. Corresponds to 
   * com.csc.er.common.domain.ValidValueGroup's "key". It is this code which is stored
   * in the database whenever a column represents a valid valued item. 
   */
  String getCode();
  
  /**
   * @return The description or name for the enumerated instance. Corresponds to
   * @see com.csc.er.common.domain.ValidValueGroup's "value". 
   */
  String getDescription();
  
  /**
   * @return The code or id for the enumerated instance which is specified in an 
   * external interface such as an XSD. This is typically longer and more human-readable
   * than the string returned by getCode(). 
   */
  String getExternalCode();
  
}