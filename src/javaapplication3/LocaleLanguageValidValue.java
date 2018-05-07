package javaapplication3;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/**
 * Valid Values for all the locale languages the JVM knows about
 * @author prenagha
 */
public final class LocaleLanguageValidValue implements EnumeratedValidValue {

  private static final Map VALUES = new TreeMap();
  private String code;
  private String description;

  static {
    // init valid value list as all locales this jvm knows about
    Locale[] locales = Locale.getAvailableLocales();
    for (int i=0; i<locales.length; i++) {
      create(locales[i]);
    }
  }

  private LocaleLanguageValidValue() {}

  /**
   * @see EnumeratedValidValue#getCode()
   */
  public String getCode() {
    return code;
  }

  /**
   * @see EnumeratedValidValue#getDescription()
   */
  public String getDescription() {
    return description;
  }

  /**
   * @see EnumeratedValidValue#getExternalCode()
   */
  public String getExternalCode() {
    return getCode();
  }

  private static LocaleLanguageValidValue create(Locale locale) {
    LocaleLanguageValidValue l = (LocaleLanguageValidValue) VALUES.get(locale.getLanguage());
    if (l == null) {
      l = new LocaleLanguageValidValue();
      l.code = locale.getLanguage();
      l.description = locale.getDisplayLanguage();
      VALUES.put(l.code, l);
      System.out.println("code : "+l.code);
      System.out.println("value : "+l.description);
    }
    return l;
  }

  /**
   * Get the LocaleValidValue corresponding to the supplied <code>code</code>
   * @param code of the item to look up
   * @return <code>LocaleValidValue</code> corresponding to <code>code</code> or null if none
   */
  public static LocaleLanguageValidValue valueOf(String code) {
    return (LocaleLanguageValidValue) VALUES.get(code);
  }

  /**
   * Needed for Enumerated valid values
   * @see EnumeratedValidValue
   * @return collection of all values
   */
  public static Collection getValues() {
    return VALUES.values();
  }

  /**
   * Used by java serialization, try our best to keep one instance per code
   * in the JVM
   * @return the object
   * @throws java.io.ObjectStreamException on error
   * @noinspection UNUSED_THROWS
   */
  private Object readResolve () throws java.io.ObjectStreamException {
    return valueOf(this.code);
  }

  /**
   * @see Comparable#compareTo(Object)
   */
  public int compareTo(Object o) {
    LocaleLanguageValidValue other = (LocaleLanguageValidValue) o;
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

    final LocaleLanguageValidValue that = (LocaleLanguageValidValue) o;
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
    sb.append("LocaleLanguageValidValue{");
    sb.append(" code=").append(code);
    sb.append(", description=").append(description);
    sb.append("}");
    return sb.toString();
  }
}
