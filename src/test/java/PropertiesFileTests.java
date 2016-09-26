import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

public class PropertiesFileTests
{
  @Test
  public void noWhitespaceShouldParseAsEmptyString() throws IOException
  {
    Properties properties = getTestPropertiesFile();
    Assert.assertEquals( "Empty value was not parsed as empty string", "", properties.getProperty( "empty.no.whitespace" ) );
  }

  @Test
  public void singleWhitespaceShouldParseAsEmptyString() throws IOException
  {
    Properties properties = getTestPropertiesFile();
    Assert.assertEquals( "Single whitespace was not parsed as empty string", "", properties.getProperty( "empty.single.whitespace" ) );
  }

  @Test
  public void multipleWhitespaceShouldParseAsEmptyString() throws IOException
  {
    Properties properties = getTestPropertiesFile();
    Assert.assertEquals( "Multiple whitespaces were not parsed as empty string", "", properties.getProperty( "empty.multiple.whitespace" ) );
  }

  private Properties getTestPropertiesFile() throws IOException
  {
    Properties properties = new Properties();
    properties.load( getClass().getResourceAsStream( "test.properties" ) );
    return properties;
  }
}
