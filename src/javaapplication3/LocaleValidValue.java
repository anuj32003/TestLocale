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
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/**
 * Valid Values for all the locales the JVM knows about
 * @author prenagha
 */
public final class LocaleValidValue implements EnumeratedValidValue {

  private static final Map VALUES = new TreeMap();
  private String code;
  private Locale locale;

  static {
    // init valid value list as all locales this jvm knows about
    Locale[] locales = Locale.getAvailableLocales();
    for (int i=1; i<locales.length; i++) {
      create(locales[i]);
    }
  }

  private LocaleValidValue() {}

  /**
   * @see com.csc.er.common.domain.EnumeratedValidValue#getCode()
   */
  public String getCode() {
    return code;
  }

  /**
   * @see com.csc.er.common.domain.EnumeratedValidValue#getDescription()
   */
  public String getDescription() {
    return locale.getDisplayName();
  }

  /** @return locale associated with vv item */
  public Locale getLocale() {
    return locale;
  }

  /**
   * @see com.csc.er.common.domain.EnumeratedValidValue#getExternalCode()
   */
  public String getExternalCode() {
    return getCode();
  }

  private static LocaleValidValue create(Locale locale) {
    String key = getKeyForLocale(locale);
    LocaleValidValue l = (LocaleValidValue) VALUES.get(key);
    if (l == null) {
      l = new LocaleValidValue();
      l.code = key;
      l.locale = locale;
      VALUES.put(l.code, l);
      System.out.println("Key::"+ key);
      System.out.println("value::"+ locale);
    }/* else {
      if(VALUES.get(l.code) != null ){
    	 System.out.println("l.code +++++++++++++++++++++++++>::"+ l.code); 
        VALUES.put(l.code, l);
      }*/ 
        //throw new IllegalArgumentException("Already have locale " + locale);
   // }
    return l;
  }

  /**
   * Get the vv item for a locale
   * @param locale to find
   * @return vv item
   */
  public static LocaleValidValue valueOfLocale(Locale locale) {
    if (locale == null)
      return null;
    String key = getKeyForLocale(locale);
    return (LocaleValidValue) VALUES.get(key);
  }

  private static String getKeyForLocale(Locale l) {
    return l.getLanguage()
      + (l.getCountry()!=null&&l.getCountry().length()>0?"_" + l.getCountry():"")
      + (l.getVariant()!=null&&l.getVariant().length()>0?"_" + l.getVariant():"");
  }

  /**
   * Get the LocaleValidValue corresponding to the supplied <code>code</code>
   * @param code of the item to look up
   * @return <code>LocaleValidValue</code> corresponding to <code>code</code> or null if none
   */
  public static LocaleValidValue valueOf(String code) {
    return (LocaleValidValue) VALUES.get(code);
  }

  /**
   * Needed for Enumerated valid values
   * @see com.csc.er.common.domain.EnumeratedValidValue
   * @return collection of all values
   */
  public static Collection getValues() {
    return VALUES.values();
  }

  /**
   * Used by java serialization, try our best to keep one instance per code
   * in the JVM
   * @return the object
   * @throws java.io.ObjectStreamException on object error
   * @noinspection UNUSED_THROWS
   */
  private Object readResolve () throws java.io.ObjectStreamException {
    return LocaleValidValue.valueOf(this.code);
  }

  /**
   * @see Comparable#compareTo(Object)
   */
  public int compareTo(Object o) {
    LocaleValidValue other = (LocaleValidValue) o;
    return this.code.compareTo(other.code);
  }

  /**
   * @see Object#equals(Object)
   */
  public boolean equals(Object o) {
    if (this == o)
      return true;

    if (o == null || getClass() != o.getClass())
      return false;

    final LocaleValidValue that = (LocaleValidValue) o;
    return code.equals(that.code);
  }

  /**
   * @see Object#hashCode()
   */
  public int hashCode() {
    return code.hashCode();
  }

  /**
   * @return string representation of object
   * @see Object#toString()
   */
  public String toString() {
    final StringBuffer sb = new StringBuffer(200);
    sb.append("LocaleValidValue{");
    sb.append(" code=").append(code);
    sb.append(", locale=").append(locale);
    sb.append("}");
    return sb.toString();
  }
}
